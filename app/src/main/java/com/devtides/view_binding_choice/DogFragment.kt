package com.devtides.view_binding_choice

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devtides.view_binding_choice.databinding.FragmentDogBinding

class DogFragment : Fragment() {

    private var binding: FragmentDogBinding? = null
    private var activityLink: PassDataInterface? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDogBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityLink = context as PassDataInterface
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.dogButton?.setOnClickListener {
            activityLink?.switchFragment()
        }

        binding?.dogSwitch?.setOnCheckedChangeListener { buttonView, isChecked ->
            activityLink?.likeDog(isChecked)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}