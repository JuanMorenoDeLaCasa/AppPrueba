package com.example.appprueba


class DaoItems private constructor(): InterfaceDao {
    companion object {
        val myDao: DaoItems by lazy{ //lazy delega a un primer acceso
            DaoItems() //Me creo sólo este objeto una vez.
        }
    }
    //Método que accede a la BBDD y devuelve todos los datos
    override fun getDataItems(): List<Item> = Repository. listItems
    override fun onEditClick(position: Int) {
        TODO("Not yet implemented")
    }

    override fun onDeleteClick(position: Int) {
        TODO("Not yet implemented")
    }
}
