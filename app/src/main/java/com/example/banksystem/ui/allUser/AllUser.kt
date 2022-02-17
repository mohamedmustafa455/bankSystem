package com.example.banksystem.ui.allUser

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.banksystem.R
import com.example.banksystem.databinding.AllUserFragmentBinding

class AllUser : Fragment() {



    private lateinit var viewModel: AllUserViewModel
    private lateinit var binding:AllUserFragmentBinding
    private lateinit var adapter : customAdapteruser

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.all_user_fragment, container, false)
        binding= AllUserFragmentBinding.inflate(inflater)

        viewModel = ViewModelProvider(this,
            AllUserViewModelFactory(requireActivity().application)).get(AllUserViewModel::class.java)

//        viewModel = ViewModelProvider(this).get(AllUserViewModel::class.java)

        setupRV()
        return binding.root
    }
    private fun setupRV() {
        adapter = customAdapteruser()

        binding.rvAllUser.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

        activity?.let {
            viewModel.readAllData.observe(
                viewLifecycleOwner, {
                    adapter.differ.submitList(it)
                    binding.rvAllUser.adapter = adapter

                }
            )

        }
    }



}