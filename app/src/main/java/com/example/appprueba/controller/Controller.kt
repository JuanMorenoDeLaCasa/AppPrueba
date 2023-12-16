package com.example.appprueba

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.appprueba.databinding.ActivityMainBinding

class Controller(val context: Context, private val binding: ActivityMainBinding) {
    private lateinit var listItems: MutableList<Item>
    private val adapterItem: AdapterItem by lazy { AdapterItem(listItems, this) }

    init {
        initData()
    }

    private fun initData() {
        listItems = DaoItems.myDao.getDataItems().toMutableList()
    }

    fun loggOut() {
        Toast.makeText(context, "He mostrado los datos en pantalla", Toast.LENGTH_LONG).show()
        listItems.forEach {
            println(it)
        }
    }

    fun setAdapter() {
        binding.myRecyclerView.adapter = adapterItem
    }

    fun showDeleteItemDialog(itemName: String) {
        AlertDialog.Builder(context)
            .setMessage("Elemento eliminado: $itemName")
            .setPositiveButton("Aceptar") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }
}
