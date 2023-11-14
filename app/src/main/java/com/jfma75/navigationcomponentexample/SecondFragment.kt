package com.jfma75.navigationcomponentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.jfma75.navigationcomponentexample.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var _binding : FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val args:SecondFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val name = args.name

        binding.tvName.text = name
        binding.materialToolbar.title = "Second Fragment"

        binding.tvName.setOnClickListener {
            findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToThirdFragment())
        }

        binding.materialToolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        return binding.root
    }
}