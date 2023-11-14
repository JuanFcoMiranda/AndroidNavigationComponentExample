package com.jfma75.navigationcomponentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jfma75.navigationcomponentexample.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)

        binding.materialToolbar.title = "Third Fragment"

        binding.materialToolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        return binding.root
    }
}