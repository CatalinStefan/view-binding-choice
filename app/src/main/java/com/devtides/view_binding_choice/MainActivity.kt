package com.devtides.view_binding_choice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.devtides.view_binding_choice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PassDataInterface {

    private val catFragment = CatFragment()
    private val dogFragment = DogFragment()
    private var currentFragment: Fragment? = null

    private var likeCat = false
    private var likeDog = false

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        switchFragment()

        updateLabel()
    }

    override fun likeCat(like: Boolean) {
        likeCat = like
        updateLabel()
    }

    override fun likeDog(like: Boolean) {
        likeDog = like
        updateLabel()
    }

    private fun updateLabel() {
        val textId = if (likeCat)
            if (likeDog)
                R.string.main_both
            else
                R.string.main_cats
        else
            if (likeDog)
                R.string.main_dogs
            else
                R.string.main_neither

        binding.petPreference.setText(textId)
    }

    override fun switchFragment() {
        val nextFragment = if (currentFragment == null || currentFragment == dogFragment)
            catFragment
        else
            dogFragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentLayout, nextFragment)
            .commit()

        currentFragment = nextFragment
    }
}