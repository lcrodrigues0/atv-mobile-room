package com.example.atv_room.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.atv_room.databinding.ActivityAddProductBinding
import com.example.atv_room.R
import com.example.atv_room.data.model.ProductModel
import com.example.atv_room.data.room.AppDatabase

class AddProductActivity: AppCompatActivity(), View.OnClickListener {
    private lateinit var binding:  ActivityAddProductBinding
    private val db = AppDatabase.getDatabase(this).ProductDAO()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClick(view: View){
        if(view.id == R.id.addBtn){
            if( binding.productNameEt.text.toString().trim().isEmpty() ||
                binding.productPriceEt.text.toString().trim().isEmpty() ||
                binding.productQttEt.text.toString().trim().isEmpty() ){
                Toast.makeText(applicationContext, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
            else {
                val prod = ProductModel().apply {
                    this.name = binding.productNameEt.text.toString().trim()
                    this.price = binding.productPriceEt.text.toString().toDouble()
                    this.quantity = binding.productQttEt.text.toString().toInt()
                }

            }
        }
    }
}