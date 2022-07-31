package com.example.myfriendlist.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myfriendlist.data.User
import com.example.myfriendlist.databinding.ItemCardBinding

class UserAdapter(private val listUser: ArrayList<User>, private val context: Context) : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
    inner class UserViewHolder(private val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User, context: Context) {
            with(binding){
                tvName.text = user.name
                tvUsername.text = user.username
                ivAvatar.setImageResource(user.avatar)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemCardBinding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(itemCardBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = listUser[position]
        holder.bind(user, this.context)
    }


    override fun getItemCount(): Int = listUser.size
}