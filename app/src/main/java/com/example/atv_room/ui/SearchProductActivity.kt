package com.example.atv_room.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.atv_room.databinding.ActivitySearchProductBinding

class SearchProductActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySearchProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}