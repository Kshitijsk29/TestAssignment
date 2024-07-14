package com.nextin.testassignment

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore.Images
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.nextin.testassignment.activities.RefineActivity
import com.nextin.testassignment.fragments.ConnectionFragment
import com.nextin.testassignment.fragments.ExploreFragment

class MainActivity : AppCompatActivity() {

    private val refineImage : ImageView get() = findViewById(R.id.refineImage)
    private val navigationView : BottomNavigationView get() = findViewById(R.id.navigationView)
    private val mainToolbar : Toolbar get() = findViewById(R.id.toolBarExcerise)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar()

        refineImage.setOnClickListener {
            startActivity(Intent(this,RefineActivity::class.java))
        }


        replaceFragment(ExploreFragment())


        navigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.itemExplore ->{
                    replaceFragment(ExploreFragment())
                }
                R.id.itemConnections ->{
                    replaceFragment(ConnectionFragment())
                }
            }
            true
        }

    }
   private fun setActionBar(){
        setSupportActionBar(mainToolbar)
        val actionBar = supportActionBar
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.menu_icon)
            actionBar.setTitle("Howdy Kshitij Raypale!")
        }
    }
    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainFrameLayout, fragment)
        fragmentTransaction.commit()
    }
}