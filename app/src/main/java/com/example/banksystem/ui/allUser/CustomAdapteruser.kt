package com.example.banksystem.ui.allUser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.banksystem.databinding.ItemRvUserBinding
import com.example.banksystem.roomDatabase.entity.UserTable

class customAdapteruser:RecyclerView.Adapter<customAdapteruser.viewholdaer>() {


private val differcallback=object :DiffUtil.ItemCallback<UserTable>(){
    override fun areItemsTheSame(oldItem: UserTable, newItem: UserTable): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserTable, newItem: UserTable): Boolean {
        return oldItem == newItem
    }
}

    val differ=AsyncListDiffer(this , differcallback )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholdaer {
        var v =ItemRvUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewholdaer(v)
    }

    override fun onBindViewHolder(holder: viewholdaer, position: Int) {
      var data: UserTable = differ.currentList[position]

        holder.binding.tvNameItem.text    =data.name
        holder.binding.tvEmailItem.text   =data.email
        holder.binding.tvBalanceItem.text =data.balence.toString()
        holder.itemView.setOnClickListener{
            var action=AllUserDirections.actionAllUserToOneCustomer(name=data.name, email = data.email, balance = data.balence.toString())

            it.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
     return  differ.currentList.size
    }
    class viewholdaer(var binding: ItemRvUserBinding):RecyclerView.ViewHolder(binding.root) {

//        init {
////            itemView.setOnClickListener {
////                Toast.makeText(itemView.context, "item click", Toast.LENGTH_SHORT).show()
////                var action=AllUserDirections.actionAllUserToOneCustomer( dataItem.name,dataItem.Email,  dataItem.balance)
////
////                itemView.findFragment<Fragment>().findNavController().navigate(action)
////
////
////            }
//        }U


    }



}
