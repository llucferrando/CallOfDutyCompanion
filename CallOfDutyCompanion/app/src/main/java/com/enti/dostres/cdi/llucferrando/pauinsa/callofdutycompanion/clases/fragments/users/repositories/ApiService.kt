package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.repositories

import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.NewsData
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.UsersData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class ApiService : Repository {

    companion object {
        const val BASE_URL = "https://api.steampowered.com"
        const val API_KEY = "1c1a485d398d35aba0bbffacb95e64ed"
        const val PRIVATE_KEY = "9da41f67a88ea1d093b0e89f9ba9a9783deadbb9"

        val Timestamp: String get() = Timestamp(System.currentTimeMillis()).time.toString()

        val Hash: String get() {
            val input = "$Timestamp$PRIVATE_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }

        val UsersApiService: RetrofitUsersApiService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitUsersApiService::class.java)
        }
        val NewsApiService: RetrofitNewsApiService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitNewsApiService::class.java)
        }
    }

    interface RetrofitUsersApiService {
        @GET("ISteamNews/GetNewsForApp/v2/")
        suspend fun GetUsers(
            @Query("ts") timestamp: String = Timestamp,
            @Query("apikey") apiKey: String = API_KEY,
            @Query("hash") hash: String = Hash
        ) : Response<CharactersResponse>
    }

    interface RetrofitNewsApiService {
        @GET("ISteamNews/GetNewsForApp/v2/")
        suspend fun GetNews(
            @Query("gameId") gameId: Int = 2000950,
        ) : Response<NewsResponse>
    }

    override suspend fun GetUsers(): MutableList<UsersData> {

        val response = UsersApiService.GetUsers()

        if(response.isSuccessful) {

            response.body()?.charactersData?.usersList?.let { users ->
                return users
            } ?: kotlin.run {
                //Controlar el error de alguna forma
                return mutableListOf()
            }

        } else {
            //Controlar el error de alguna forma
            return mutableListOf()
        }
    }

    override suspend fun GetNews(): MutableList<NewsData> {

        val response = NewsApiService.GetNews()

        if(response.isSuccessful) {

            response.body()?.newsData?.newsList?.let { news ->
                return news
            } ?: kotlin.run {
                //Controlar el error de alguna forma
                return mutableListOf()
            }

        } else {
            //Controlar el error de alguna forma
            return mutableListOf()
        }
    }
}