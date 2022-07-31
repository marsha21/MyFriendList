package com.example.myfriendlist

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfriendlist.data.User
import com.example.myfriendlist.databinding.ActivityMainBinding
import com.example.myfriendlist.ui.adapter.UserAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = UserAdapter(users, this)

        setData()
        with(binding.rvUser){
            this.layoutManager = LinearLayoutManager( this@MainActivity)
            this.setHasFixedSize(true)
            this.adapter = adapter
        }
    }

    private fun setData() {
        val names : Array<String> = resources.getStringArray(R.array.name)
        val username : Array<String> = resources.getStringArray(R.array.username)
        val avatar : TypedArray = resources.obtainTypedArray(R.array.avatar)
        val location : Array<String> = resources.getStringArray(R.array.location)
        val repository : Array<String> = resources.getStringArray(R.array.repository)
        val company : Array<String> = resources.getStringArray(R.array.company)
        val followers : Array<String> = resources.getStringArray(R.array.followers)
        val followings : Array<String> = resources.getStringArray(R.array.following)

        for (i in names.indices){
            val user = User(
                names[i],
                username[i],
                location[i],
                repository[i],
                company[i],
                followers[i],
                followings[i],
                avatar.getResourceId(i, -1)
            )
            users.add(user)
        }
        avatar.recycle()
    }
}