package com.example.banksystem.ui.transferBalance

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.banksystem.databinding.ItemRvRecordTransferBinding
import com.example.banksystem.roomDatabase.entity.TrnsferBalanceTable

class customAdapertransferbalance:RecyclerView.Adapter<customAdapertransferbalance.viewHolder>() {

    private var differcallback= object :DiffUtil.ItemCallback<TrnsferBalanceTable>(){
        override fun areItemsTheSame(
            oldItem: TrnsferBalanceTable,
            newItem: TrnsferBalanceTable
        ): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: TrnsferBalanceTable,
            newItem: TrnsferBalanceTable
        ): Boolean {
            return oldItem==newItem
        }

    }
    var differ= AsyncListDiffer(this,differcallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var v=ItemRvRecordTransferBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewHolder(v)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
     var data:TrnsferBalanceTable=differ.currentList[position]

        holder.binding.tvSender.text=data.sender
        holder.binding.tvReceiver.text=data.recever
        holder.binding.tvAmountTransfer.text=data.amount.toString()

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
    class viewHolder(var binding: ItemRvRecordTransferBinding):RecyclerView.ViewHolder(binding.root) {

    }
}
