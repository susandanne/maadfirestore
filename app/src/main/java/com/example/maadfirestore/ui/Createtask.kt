package com.example.maadfirestore.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.maadfirestore.data.model.Note
import com.example.maadfirestore.databinding.FragmentCreatetaskBinding
import com.example.maadfirestore.utils.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Createtask : Fragment() {
lateinit var binding: FragmentCreatetaskBinding
   val viewmodel:taskviewmodel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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


      viewmodel.addnote(Note("",task,"high",""+System.currentTimeMillis()))
          Log.i("TAG"," $task")
      }
        viewmodel.creeteresponse.observe(viewLifecycleOwner){
              when(it){
                  is UiState.failure -> {
                      Toast(it.message)
                  }
                  is UiState.loading -> {
                      Toast("loading")
                  }
                  is UiState.success -> {
                      Toast("success")
                      findNavController().popBackStack()
                  }
              }
        }

    }

    private fun Toast(message: String?) {

    }


}