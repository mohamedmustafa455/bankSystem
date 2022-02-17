package com.example.banksystem.ui.homeScreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.banksystem.R
import com.example.banksystem.databinding.HomeScreenFragmentBinding

class home_screen : Fragment() {

    private lateinit var viewModel: HomeScreenViewModel
    private lateinit var binding:HomeScreenFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*
        view binding
         */
        inflater.inflate(R.layout.home_screen_fragment,container,false)
        binding= HomeScreenFragmentBinding.inflate(inflater)

        viewModel = ViewModelProvider(this).get(HomeScreenViewModel::class.java)


        binding.btnViewAllUser.setOnClickListener{
         var action=home_screenDirections.actionHomeScreenToAllUser()
            findNavController().navigate(action)
        }
        binding.btnViewTransefer.setOnClickListener {
            var action=home_screenDirections.actionHomeScreenToTransferBalance()
            findNavController().navigate(action)
        }

        return binding.root
    }



}