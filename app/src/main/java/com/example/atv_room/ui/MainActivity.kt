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
    }

    override fun onClick(view: View){
        if(view.id == R.id.addProductBtn){
            Intent(this, AddProductActivity::class.java)
            startActivity(Intent(this, AddProductActivity::class.java))
        }
    }
}