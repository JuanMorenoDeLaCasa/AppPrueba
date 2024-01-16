package com.example.appprueba

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.appprueba.databinding.FragmentSecondBinding


class Controller(val context: Context, private val binding: FragmentSecondBinding) {
    private lateinit var listItems: MutableList<Item>
    private val adapterItem: AdapterItem by lazy { AdapterItem(listItems, this) }

    companion object {
        const val PICK_IMAGE_REQUEST = 1
    }

    init {
        initData()
    }

    private fun initData() {
        listItems = Repository.listItems.toMutableList()
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

    fun showCreateOrEditItemDialog(item: Item? = null) {
        val dialog = AlertDialog.Builder(context)
        val dialogView = (context as Activity).layoutInflater.inflate(R.layout.dialog_create_edit_item, null)
        dialog.setView(dialogView)

        val editTextName = dialogView.findViewById<EditText>(R.id.editTextName)
        val editTextPrecio = dialogView.findViewById<EditText>(R.id.editTextPrecio)
        val editTextPeso = dialogView.findViewById<EditText>(R.id.editTextPeso)
        val editTextColor = dialogView.findViewById<EditText>(R.id.editTextColor)
        // ... (otros campos)

        // Configurar el diálogo según si se está creando o editando
        if (item != null) {
            editTextName.setText(item.name)
            editTextPrecio.setText(item.precio)
            editTextPeso.setText(item.peso)
            editTextColor.setText(item.color)
            // ... (otros campos)
        }

        val btnChooseImage = dialogView.findViewById<Button>(R.id.btnChooseImage)
        btnChooseImage.setOnClickListener {
            openGalleryForImage()
        }

        dialog.setPositiveButton("Guardar") { _, _ ->
            val newItem = if (item != null) {
                item.apply {
                    name = editTextName.text.toString()
                    precio = editTextPrecio.text.toString()
                    peso = editTextPeso.text.toString()
                    color = editTextColor.text.toString()
                    // ... (otros campos)
                }
            } else {
                Item(
                    editTextName.text.toString(),
                    editTextPrecio.text.toString(),
                    editTextPeso.text.toString(),
                    editTextColor.text.toString(),
                    selectedImageUri ?: Uri.parse("android.resource://com.example.appprueba/drawable/placeholder_image")
                )
            }

            if (item != null) {
                // Si estamos editando, notificar al adaptador sobre el cambio
                adapterItem.notifyItemChanged(listItems.indexOf(item))
            } else {
                // Si estamos creando, agregar el nuevo ítem a la lista y notificar al adaptador
                listItems.add(newItem)
                adapterItem.notifyItemInserted(listItems.size - 1)
            }
        }

        dialog.setNegativeButton("Cancelar") { _, _ ->
            // Acciones al cancelar el diálogo
        }

        dialog.show()
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

    private var selectedImageUri: Uri? = null

    private fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        (context as Activity).startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            selectedImageUri = data.data
            // Aquí puedes realizar la lógica para manejar la imagen seleccionada.
            // Puedes mostrarla en una vista previa, asignarla a un campo en el diálogo, etc.
            Toast.makeText(context, "Imagen seleccionada: $selectedImageUri", Toast.LENGTH_SHORT).show()
        }
    }
}
