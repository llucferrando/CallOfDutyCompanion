package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.MyApp
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.R
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.firebaseclasses.FB
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.components.AppDrawer
import com.google.android.material.textfield.TextInputLayout

class ChatScreen : Fragment() {

    lateinit var fragmentView: View
    val messagesTable by lazy { fragmentView.findViewById<RecyclerView>(R.id.chat_messages_recycler) }
    val messagesInput by lazy { fragmentView.findViewById<TextInputLayout>(R.id.chat_messages_input) }
    val messagesImage by lazy { fragmentView.findViewById<ImageView>(R.id.chat_messages_image_container) }

    val messageAdapter by lazy{MessagesAdapter(messagesTable)}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.screen_chat, container,false)
        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        messagesTable.layoutManager= LinearLayoutManager(MyApp.get())
        messagesTable.adapter=messageAdapter

        messagesInput.setStartIconOnClickListener{

        }
        messagesInput.setEndIconOnClickListener{
            sendMessage()
        }
    }
    fun sendMessage(){
        if(!FB.authentication.isLoginActive()){
            MyApp.get().closeKeyboard(messagesInput)
            AppDrawer.get().openLogin()
            return
        }
        val inputText= messagesInput.editText?.text.toString()
        val text = if(inputText!="")inputText else null
        messageAdapter.addMessage(text,null)
        messagesInput.editText?.text?.clear()

        //val imageUri =
    }
}