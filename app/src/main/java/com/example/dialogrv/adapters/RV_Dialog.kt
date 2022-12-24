package com.example.dialogrv.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dialogrv.Dialog
import com.example.dialogrv.R
import kotlinx.android.synthetic.main.dialog_1.view.*
import kotlinx.android.synthetic.main.item_dialog.view.*

class RV_Dialog(var dialogList: List<Dialog>, var onMyItemClickListener: OnMyItemClickListener):RecyclerView.Adapter<RV_Dialog.MyViewHolder>() {
    inner class MyViewHolder(var itemView: View): RecyclerView.ViewHolder(itemView){
        fun onBind(dialog: Dialog){
            itemView.dialog_tv.text = dialog.dialog_name
            itemView.setOnClickListener {
                onMyItemClickListener.onMyItemClick(dialog)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_dialog, parent,false)
        val myViewHolder =MyViewHolder(itemView)
        return myViewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val dialog:Dialog =dialogList[position]
        holder.onBind(dialog)
    }

    override fun getItemCount(): Int {
        return dialogList.size
    }

    interface OnMyItemClickListener{
        fun onMyItemClick(dialog: Dialog)
    }
}