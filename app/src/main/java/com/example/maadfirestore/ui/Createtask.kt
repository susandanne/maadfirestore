package com.example.maadfirestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.maadfirestore.R
import com.example.maadfirestore.data.model.Note
import com.example.maadfirestore.databinding.FragmentCreatetaskBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Createtask : Fragment() {
lateinit var binding: FragmentCreatetaskBinding
   val viewmodel:taskviewmodel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if (this::binding.isInitialized) {
            binding.root

        } else {
            binding = FragmentCreatetaskBinding.inflate(inflater, container, false)

            return binding.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      binding.submit.setOnClickListener {
          val task = binding.taskEt.text.toString()


      viewmodel.add(Note("","hello","high",""+System.currentTimeMillis()))

      }

    }


}