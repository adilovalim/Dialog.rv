package com.example.dialogrv

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.dialogrv.adapters.RV_Dialog
import com.example.dialogrv.adapters.Rv_Adapter
import com.example.dialogrv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var dialogList: ArrayList<Dialog>
    lateinit var dialoAdapter: RV_Dialog
    lateinit var userAdapter: Rv_Adapter
    lateinit var userList: ArrayList<User>
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        loadUsers()//1
        userAdapter  =Rv_Adapter(userList,object :Rv_Adapter.OnMyItemClickListener{
            override fun onMyItemClick(user: User) {
                val alert = AlertDialog.Builder(this@MainActivity).create()
                val view1 = LayoutInflater.from(this@MainActivity).inflate(R.layout.dialog_1, binding.root, false)
                alert.setView(view1)
                alert.show()

            }

        })//1
        binding.tvRv.adapter =userAdapter//1

        loadDialog()
        dialoAdapter = RV_Dialog(dialogList, object :RV_Dialog.OnMyItemClickListener{
            override fun onMyItemClick(dialog: Dialog) {

                binding.tvRv.adapter = dialoAdapter
            }

        })

    }

    private fun loadDialog() {
        dialogList = ArrayList()
        for (i in 1..10){
            dialogList.add(Dialog(i,"dalog$i"))
        }
    }

    private fun loadUsers() {//1
        userList = ArrayList()
        for (i in 1..50){
            userList.add(User(i, "asdas $i"))
        }

    }


}