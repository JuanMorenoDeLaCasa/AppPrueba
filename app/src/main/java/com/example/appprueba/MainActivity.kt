package com.example.appprueba

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appprueba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var controller: Controller
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        initRecyclerView()
        controller = Controller(this, binding)
        controller.setAdapter()

        binding.btnAddItem.setOnClickListener {
            controller.showCreateOrEditItemDialog()
        }
    }

    private fun initRecyclerView() {
        binding.myRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }
}
