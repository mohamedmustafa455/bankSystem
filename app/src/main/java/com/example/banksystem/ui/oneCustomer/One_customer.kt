package com.example.banksystem.ui.oneCustomer

import android.opengl.Visibility
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.banksystem.R
import com.example.banksystem.databinding.OneCustomerFragmentBinding
import com.example.banksystem.ui.allUser.AllUserViewModel
import com.example.banksystem.ui.allUser.AllUserViewModelFactory
import com.example.banksystem.ui.transferBalance.TransferBalanceViewModel

class one_customer : Fragment() {


    private val args: one_customerArgs by navArgs()

    // private  lateinit var trans: TransferBalanceViewModel
    private lateinit var viewModel: OneCustomerViewModel
    private lateinit var binding: OneCustomerFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*
        using databinding
         */
        inflater.inflate(R.layout.one_customer_fragment, container, false)
        binding = OneCustomerFragmentBinding.inflate(inflater)
        viewModel = ViewModelProvider(
            this,
            OneCustomerViewModelFactory(requireActivity().application)
        ).get(OneCustomerViewModel::class.java)

        binding.viewmodel = viewModel


        viewModel.readAllNames.observe(viewLifecycleOwner) { list ->
            val adapter = ArrayAdapter(requireContext(), R.layout.list_user_spener, list)
            (binding.spenerAllUser.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        }

        viewModel.nameSender = args.name!!
        viewModel.balance = args.balance!!.toInt()
        viewModel.email = args.email!!

        //data respaction from pre fragment
        binding.tvName.text = args.name!!
        binding.tvEmail.text = args.email!!
        binding.tvBalance.text = args.balance!!
        binding.btnTransferBalance.setOnClickListener {
            binding.layTran.visibility = View.VISIBLE
        }

        binding.btnConfirm.setOnClickListener {
            viewModel.amount = binding.editText.text!!.toString().toInt()
            var flag = viewModel.Trans()
            if (!flag) {
               binding.tvBalance.text=viewModel.balance!!.toString()
                findNavController()
                    .navigate(one_customerDirections.actionOneCustomerToAllUser())
            } else {

                Toast.makeText(
                    this.context,
                    "the amount is higher than the balance",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }


        return binding.root
    }

}