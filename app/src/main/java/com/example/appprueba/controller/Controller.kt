package com.example.appprueba

import android.content.Context
import android.widget.Toast

class Controller ( val context : Context){
    lateinit var listItems : MutableList<Item> //lista de objetos
    init {
        initData()
    }
    fun initData(){
        // listItems = DaoItems2.myDao.toMutableList()
        listItems = DaoItems. myDao.getDataItems(). toMutableList() //llamamos al singleton.
    }
    fun loggOut() {
        Toast.makeText( context, "He mostrado los datos en pantalla", Toast. LENGTH_LONG).show()
        listItems.forEach{
            println (it)
        }
    }
    fun setAdapter() { // Cargamos nuestro AdapterItem al adapter del RecyclerView
        val myActivity = context as MainActivity
        myActivity. binding.myRecyclerView.adapter = AdapterItem( listItems) // Cargamos el Adapter que creamos.
    }

}