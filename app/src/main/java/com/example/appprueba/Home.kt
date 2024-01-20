package com.example.appprueba

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.appprueba.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class Home : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navController = findNavController(R.id.nav_host_fragment_content_home)

        // Configura el AppBarConfiguration con el ID del fragmento principal y el DrawerLayout
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.Home), drawerLayout
        )

        // Configura el ActionBar con el NavController y el AppBarConfiguration
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Agrega el botón de hamburguesa al ActionBar
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)

        // Configura el BottomNavigationView
        val bottomNavigationView: BottomNavigationView = binding.navViewBottom
        bottomNavigationView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Permitir que NavController maneje el clic en el botón de inicio o la flecha hacia atrás
        return NavigationUI.onNavDestinationSelected(item, findNavController(R.id.nav_host_fragment_content_home))
                || super.onOptionsItemSelected(item)
    }
}

