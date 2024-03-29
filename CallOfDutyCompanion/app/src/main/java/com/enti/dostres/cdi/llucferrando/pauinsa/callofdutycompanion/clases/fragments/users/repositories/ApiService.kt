package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.repositories

import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.R
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.firebaseclasses.FB
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.components.AppDrawer
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.NewsData
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.UsersData
import com.google.android.material.snackbar.Snackbar
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
        const val BASE_URL = "https://api.steampowered.com/"
        const val BASE_PARTNER_URL = "https://partner.steam-api.com/"
        const val API_KEY = "4C9144FAD419AEED4D5D70273E2BA2C7"

        val Timestamp: String get() = Timestamp(System.currentTimeMillis()).time.toString()

        val Hash: String get() {
            val input = "$Timestamp$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }

        val UsersApiService: RetrofitUsersApiService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_PARTNER_URL)
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
        @GET("ISteamUserStats/GetGlobalStatsForGame/v1/")
        suspend fun GetUsers(
            @Query("appid") gameId: Int = 1938090,
            @Query("count") count: Int = 1,
            @Query("name") stat: String = "MostKills",
            @Query("key") key: String = "19C04CE508252F186349B6A55415557E",
            @Query("steamid") steamid: String = "pinza_115"
        ) : Response<CharactersResponse>
    }

    interface RetrofitNewsApiService {
        @GET("ISteamNews/GetNewsForApp/v2/")
        suspend fun GetNews(
            @Query("appid") gameId: Int = 1938090,
            @Query("count") count: Int = 100,
        ) : Response<NewsResponse>
    }

    override suspend fun GetUsers(): MutableList<UsersData> {

        val response = UsersApiService.GetUsers()
        println(response)

        if(response.isSuccessful) {

            response.body()?.charactersData?.usersList?.let { users ->
                return users
            } ?: kotlin.run {
                FB.crashalytics.logSingleError("API Error"){
                    key("data", response.body()?.charactersData?.usersList.toString())
                    key("Requested", "stats" )
                }
                return mutableListOf()
            }

        } else {
            FB.crashalytics.logSingleError("API Error"){
                key("Response result", response.toString())
                key("Requested", "stats" )
            }
            return mutableListOf()
        }
    }

    override suspend fun GetNews(): MutableList<NewsData> {

        val response = NewsApiService.GetNews()
        println(response)

        if(response.isSuccessful) {

            response.body()?.newsItems?.newsData?.let { news ->
                return news
            } ?: kotlin.run {
                FB.crashalytics.logSingleError("API Error"){
                    key("data", response.body()?.newsItems?.newsData.toString())
                    key("Requested", "news" )
                }

                return mutableListOf()
            }

        } else {
            FB.crashalytics.logSingleError("API Error"){
                key("Response result", response.toString())
                key("Requested", "news")
            }

            return mutableListOf()
        }
    }
}