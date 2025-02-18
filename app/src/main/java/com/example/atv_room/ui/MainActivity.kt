package com.example.atv_room.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.atv_room.R
import com.example.atv_room.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addProductBtn.setOnClickListener(this)
        binding.searchProductBtn.setOnClickListener(this)
        binding.listProductBtn.setOnClickListener(this)
    }

    override fun onClick(view: View){
        when(view.id){
            R.id.addProductBtn -> startActivity(Intent(this, AddProductActivity::class.java))
            R.id.searchProductBtn -> startActivity(Intent(this, SearchProductActivity::class.java))
            R.id.listProductBtn -> startActivity(Intent(this, ListProductActivity::class.java))
        }
    }
}