package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.screens

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.R
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.firebaseclasses.FB
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.models.DbMessage

class MessagesAdapter(table: RecyclerView): RecyclerView.Adapter<MessageViewHolder>() {
    var messages = mutableListOf<DbMessage>()

    init{
        FB.db.onTableChange<DbMessage>(DbMessage().getTable()){updateMessages ->
            updateMessages.sortBy { message->
                message.createDate
            }
            val count = messages.count()
            val newCount=updateMessages.count()
            val dif = newCount-count


            messages = updateMessages
            if(dif>0){
                notifyItemRangeInserted(count,dif)
            }else{
                notifyDataSetChanged()
            }
            table.scrollToPosition(newCount-1)

        }
        //FB.db.onTableChange<DbMessage>(DbMessage().getTable(), messa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val viewHolder = MessageViewHolder(layoutInflater.inflate(R.layout.screen_chat_message_cell,parent,false))

        viewHolder.itemView.setOnClickListener{
            //Nothing
        }
        return viewHolder
    }

    override fun getItemCount() = messages.count()



    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {

        holder.setUpWithMessage(messages[position])
    }

    fun addMessage(text:String?, imageUrl: String?){
        val dbMessage = DbMessage(null, FB.authentication.getUser()?.id, text, imageUrl)
        FB.db.save(dbMessage, onSuccess = {
            //TODO EXTRA CONTROL
        }, onFailure = {
            //TODO
        })


    }
}