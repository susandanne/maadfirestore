package com.example.maadfirestore.utils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.maadfirestore.R
import com.example.maadfirestore.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        binding.floatingActionButton.setOnClickListener {
//            findNavController().navigate(R.id.action_showlist3_to_showdetails3)
//        }
    }
}