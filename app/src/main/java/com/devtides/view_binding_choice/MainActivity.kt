package com.devtides.view_binding_choice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private val catFragment = CatFragment()
    private val dogFragment = DogFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentLayout, catFragment)
            .commit()
    }
}