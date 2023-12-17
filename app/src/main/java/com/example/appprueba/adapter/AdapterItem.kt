package com.example.appprueba

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appprueba.databinding.ItemItemBinding

class AdapterItem(val listItem: MutableList<Item>, val controller: Controller) :
    RecyclerView.Adapter<ViewHItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHItem {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layoutItemHotel = R.layout.item_item
        return ViewHItem(layoutInflater.inflate(layoutItemHotel, parent, false), this)
    }

    override fun onBindViewHolder(holder: ViewHItem, position: Int) {
        holder.renderize(listItem[position])
    }

    override fun getItemCount(): Int = listItem.size

    fun deleteItem(position: Int) {
        if (position in 0 until listItem.size) {
            val deletedItem = listItem[position]

            AlertDialog.Builder(controller.context)
                .setMessage("¿Deseas borrar el elemento ${deletedItem.name}?")
                .setPositiveButton("Sí") { _, _ ->
                    // Realiza la lógica de eliminación aquí
                    listItem.removeAt(position)
                    // Notifica al adaptador sobre el cambio
                    notifyItemRemoved(position)
                    // Muestra un diálogo indicando que el elemento fue eliminado
                    controller.showDeleteItemDialog(deletedItem.name)
                }
                .setNegativeButton("No") { dialog, _ ->
                    dialog.dismiss()
                }
                .create()
                .show()
        }
    }
}
