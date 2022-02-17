package com.example.banksystem.ui.transferBalance

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.banksystem.R
import com.example.banksystem.databinding.TransferBalanceFragmentBinding
import com.example.banksystem.ui.allUser.AllUserViewModel
import com.example.banksystem.ui.allUser.AllUserViewModelFactory
import com.example.banksystem.ui.allUser.customAdapteruser

class transfer_balance : Fragment() {



    private lateinit var viewModel: TransferBalanceViewModel
    private lateinit var binding:TransferBalanceFragmentBinding
    private lateinit var adapter:customAdapertransferbalance


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         inflater.inflate(R.layout.transfer_balance_fragment, container, false)
        binding= TransferBalanceFragmentBinding.inflate(inflater)

        viewModel = ViewModelProvider(this,
            TransViewModelFactory(requireActivity().application)
        ).get(TransferBalanceViewModel::class.java)

        viewModel = ViewModelProvider(this).get(TransferBalanceViewModel::class.java)

        setupRV()
        return binding.root
    }
    private fun setupRV() {
        adapter = customAdapertransferbalance()

        binding.RVTransferRecord.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.RVTransferRecord.adapter = adapter

        activity?.let {
            viewModel.getdata()!!.observe(
                viewLifecycleOwner, {
                    adapter.differ.submitList(it!!)
                }
            )

        }
    }



}