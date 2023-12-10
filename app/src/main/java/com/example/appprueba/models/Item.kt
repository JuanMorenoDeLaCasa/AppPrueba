package com.example.appprueba

class Item(
    var name: String,
    var precio: String,
    var peso: String,
    var color: String,
    var imageResource: Int // Usaremos un recurso de imagen (R.drawable.nombre_de_imagen)
) {
    override fun toString(): String {
        return "Item(name='$name', precio='$precio', peso='$peso', color='$color', imageResource=$imageResource)"
    }
}