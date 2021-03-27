package com.example.nytimesmostpopulararticles.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.nytimesmostpopulararticles.R
import com.example.nytimesmostpopulararticles.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.mtMain)
        configureNavController()
    }

    private fun configureNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun showMessage(message: String?) {
        if (!message.isNullOrEmpty()) {
            Snackbar.make(findViewById(R.id.clMain), message, Snackbar.LENGTH_LONG)
                .show()
        }
    }

    fun showMessage(messageResId: Int) {
        showMessage(getString(messageResId))
    }

    fun replaceFragment(direction: NavDirections) {
        navController.navigate(direction)
    }
}
