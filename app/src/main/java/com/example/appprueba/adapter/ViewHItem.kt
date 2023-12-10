package com.example.appprueba

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appprueba.databinding.ItemItemBinding


class ViewHItem(view: View, private val adapter: AdapterItem, private val itemList: MutableList<Item>) :
    RecyclerView.ViewHolder(view) {

    lateinit var binding: ItemItemBinding

    init {
        binding = ItemItemBinding.bind(view)
        binding.btnEdit.setOnClickListener {
            // Implementa la lógica para editar el item si es necesario
        }
        binding.btnDelete.setOnClickListener {
            // Obtiene la posición del item en la lista
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                // Remueve el item de la lista
                itemList.removeAt(position)
                // Notifica al adaptador sobre el cambio en los datos
                adapter.notifyItemRemoved(position)
            }
        }
    }

    // Método que se encarga de mapear los item por propiedad del modelo.
    fun renderize(item: Item) {
        binding.txtviewName.text = item.name
        binding.txtviewCity.text = item.precio
        binding.txtviewProvince.text = item.peso
        binding.txtviewPhone.text = item.color
        Glide.with(itemView.context)
            .load(item.imageResource)
            .centerCrop()
            .into(binding.ivItem)
    }
}
