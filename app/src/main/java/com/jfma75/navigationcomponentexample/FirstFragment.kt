package com.jfma75.navigationcomponentexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import com.jfma75.navigationcomponentexample.databinding.FragmentFirstBinding
import com.google.android.material.tabs.TabLayoutMediator

private val strings = arrayOf(R.string.Tab1, R.string.Tab2, R.string.Tab3)
private val icons = arrayOf(R.drawable.ic_groups, R.drawable.ic_calendar, R.drawable.ic_history)

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

       /* binding.btnNavigate.setOnClickListener {
            findNavController().navigate(
                FirstFragmentDirections.actionFirstFragmentToSecondFragment(
                    name = "Tus muertos"
                )
            )
        }*/

        binding.materialToolbar.navigationIcon = null
        binding.materialToolbar.title = "First Fragment"

        val viewPager = binding.viewPager
        val tabLayout = binding.tabs

        val adapter = ViewPagerAdapter(parentFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getString(strings[position])
            tab.icon = AppCompatResources.getDrawable(requireContext(), icons[position])
        }.attach()

        return binding.root
    }
}