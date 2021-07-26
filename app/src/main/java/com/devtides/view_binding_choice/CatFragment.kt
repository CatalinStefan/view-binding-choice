package com.devtides.view_binding_choice

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devtides.view_binding_choice.databinding.FragmentCatBinding

class CatFragment : Fragment() {

    private var binding: FragmentCatBinding? = null
    private var activityLink: PassDataInterface? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityLink = context as PassDataInterface
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.catButton?.setOnClickListener {
            activityLink?.switchFragment()
        }

        binding?.catSwitch?.setOnCheckedChangeListener { buttonView, isChecked ->
            activityLink?.likeCat(isChecked)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}