package com.avatr.app1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.avatr.app1.databinding.App1NewsActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: App1NewsActivityBinding

    private val navController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navHostFragment.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = App1NewsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindNavigation()
    }

    private fun bindNavigation() {
        navController.setGraph(R.navigation.app1_nav_graph)
    }
}