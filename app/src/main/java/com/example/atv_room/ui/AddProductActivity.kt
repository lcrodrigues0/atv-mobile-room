package com.example.atv_room.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.atv_room.databinding.ActivityAddProductBinding
import com.example.atv_room.R
import com.example.atv_room.data.model.ProductModel
import com.example.atv_room.data.room.AppDatabase
import com.example.atv_room.utils.Constants
import com.example.atv_room.viewModel.AddProductViewModel

class AddProductActivity: AppCompatActivity(), View.OnClickListener {
    private lateinit var binding:  ActivityAddProductBinding
    private lateinit var addProductVM: AddProductViewModel

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addBtn.setOnClickListener(this)

        addProductVM = ViewModelProvider(this).get(AddProductViewModel::class.java)
        setObserver()
    }

    private fun setObserver(){
        addProductVM.getIsSaved().observe(this, Observer {
            if(it == Constants.BD_MSGS.SUCCESS)
                Toast.makeText(applicationContext, R.string.success_add_msg, Toast.LENGTH_SHORT).show()
            else if(it == Constants.BD_MSGS.FAIL)
                Toast.makeText(applicationContext, R.string.fail_add_msg, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onClick(view: View){
        if(view.id == R.id.addBtn){
            if( binding.productNameEt.text.toString().trim().isEmpty() ||
                binding.productPriceEt.text.toString().trim().isEmpty() ||
                binding.productQttEt.text.toString().trim().isEmpty() ){
                Toast.makeText(applicationContext, R.string.fill_fields_msg, Toast.LENGTH_SHORT).show()
            }
            else {
                val prod = ProductModel().apply {
                    this.name = binding.productNameEt.text.toString().trim()
                    this.price = binding.productPriceEt.text.toString().toDouble()
                    this.quantity = binding.productQttEt.text.toString().toInt()
                }

                addProductVM.saveProduct(prod)
                clearFields()
            }
        }
    }

    private fun clearFields(){
        binding.productQttEt.text.clear()
        binding.productNameEt.text.clear()
        binding.productPriceEt.text.clear()
    }
}