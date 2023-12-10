package com.example.appprueba

interface InterfaceDao {
    fun getDataItems() : List<Item>
    fun onEditClick(position: Int)
    fun onDeleteClick(position: Int)

}