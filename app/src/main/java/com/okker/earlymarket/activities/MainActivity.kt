package com.okker.earlymarket.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import com.okker.earlymarket.R
import com.okker.earlymarket.databinding.ActivityMainBinding
import com.okker.earlymarket.databinding.AppBarMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var b: AppBarMainBinding;

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        b = binding.includeInDrawlayout
        setSupportActionBar(b.toolbar1)

        navigationView = binding.navView
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item1 -> Toast.makeText(applicationContext, "item 1", Toast.LENGTH_SHORT).show()
                R.id.item2 -> Toast.makeText(applicationContext, "item 2", Toast.LENGTH_SHORT).show()
                R.id.item3 -> Toast.makeText(applicationContext, "item 3", Toast.LENGTH_SHORT).show()
            }
            true
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        when(item.itemId){
            R.id.searchItem -> Toast.makeText(applicationContext, "Search Items", Toast.LENGTH_SHORT).show()
            R.id.notificationItem -> Toast.makeText(applicationContext, "Notification", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }


    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Click again to quit Early Market", Toast.LENGTH_SHORT).show()

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            doubleBackToExitPressedOnce = false
        }, 2000)
    }
}