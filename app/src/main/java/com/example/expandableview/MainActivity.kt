package com.example.expandableview

import android.app.ActionBar
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.expandableview.fragment.HomeFragment
import com.example.expandableview.fragment.NotificationFragment
import com.example.expandableview.fragment.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottom:BottomNavigationView
    var  homeFragment = HomeFragment()
    val notificationFragment =NotificationFragment()
    val settingsFragment = SettingsFragment()
    private val SELECTED_ITEM = "selected_item"
    private var menuItemSelected: MenuItem? = null
    private var mMenuItemSelected = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



         bottom=findViewById<BottomNavigationView>(R.id.bottom)
       bottom.setOnNavigationItemSelectedListener {


           when(it.itemId)
           {
               R.id.homes -> {
                   Toast.makeText(this, "home fragment", Toast.LENGTH_SHORT).show()
                   supportFragmentManager
                       .beginTransaction()
                       .replace(R.id.framelayout, homeFragment)
                       .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                       .commit()

                   //loadFragment(homeFragment)

               }
               R.id.notification -> {
                   Toast.makeText(this, "notification fragment", Toast.LENGTH_SHORT).show()
                   supportFragmentManager
                       .beginTransaction()
                       .replace(R.id.framelayout, notificationFragment)
                       .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                       .commit()
                   //loadFragment(notificationFragment)
               }
               R.id.settings -> {
                   Toast.makeText(this, "settomgs fragment", Toast.LENGTH_SHORT).show()
                   supportFragmentManager
                       .beginTransaction()
                       .replace(R.id.framelayout, settingsFragment)

                       .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                       .commit()
                   //loadFragment(settingsFragment)
               }
           }
          true


       }

    }


    /*override fun onBackPressed() {
        val homeItem: MenuItem = bottom.getMenu().getItem(0)
        if (mMenuItemSelected !== homeItem.getItemId()) {
            loadFragment(homeFragment)
        } else {
            super.onBackPressed()
        }
    } */



   /* private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.framelayout, fragment)
        transaction.addToBackStack(homeFragment.toString())
        transaction.commit()
    }*/
}