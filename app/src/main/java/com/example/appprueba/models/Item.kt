package com.example.appprueba

import android.net.Uri

data class Item(
    var name: String,
    var precio: String,
    var peso: String,
    var color: String,
    var imageResource: Uri?
) {
    // Constructor adicional para crear un Item con imagen por defecto
    constructor(name: String, precio: String, peso: String, color: String, defaultImageResource: Int) :
            this(name, precio, peso, color, Uri.parse("android.resource://com.example.appprueba/drawable/$defaultImageResource"))
}
