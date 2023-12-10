package com.example.appprueba

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class AdapterItem(private val listItem: MutableList<Item>) : RecyclerView.Adapter<ViewHItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHItem {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layoutItemHotel = R.layout.item_item
        return ViewHItem(layoutInflater.inflate(layoutItemHotel, parent, false), this, listItem)
    }

    override fun onBindViewHolder(holder: ViewHItem, position: Int) {
        holder.renderize(listItem[position])
    }

    override fun getItemCount(): Int = listItem.size
}
