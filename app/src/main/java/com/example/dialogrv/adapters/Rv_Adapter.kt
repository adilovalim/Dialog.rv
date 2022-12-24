package com.example.dialogrv.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

import com.example.dialogrv.R
import com.example.dialogrv.User
import kotlinx.android.synthetic.main.item_user.view.*

class Rv_Adapter( var userList: List<User>,var onMyItemClickListener: OnMyItemClickListener):RecyclerView.Adapter<Rv_Adapter.MyViewHolder>(){
    inner class MyViewHolder(var itemView: View): RecyclerView.ViewHolder(itemView){
        fun onBind(user:User){
            itemView.tv_user.text= user.name
            itemView.setOnClickListener {
                onMyItemClickListener.onMyItemClick(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user:User =userList[position]
        holder.onBind(user)
    }

    override fun getItemCount(): Int {
        return userList.size
    }
    interface OnMyItemClickListener{
        fun onMyItemClick(user: User)
    }

}