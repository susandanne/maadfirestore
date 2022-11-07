package com.example.maadfirestore.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.maadfirestore.R
import com.example.maadfirestore.data.model.Note
import com.example.maadfirestore.databinding.FragmentShowlistBinding
import com.example.maadfirestore.utils.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class showlist : Fragment() {

    lateinit var binding: FragmentShowlistBinding
    val viewModel: taskviewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return if (this::binding.isInitialized) {
            binding.root
        } else {
            binding = FragmentShowlistBinding.inflate(inflater, container, false)

            return binding.root
        }


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatingActionButton.setOnClickListener {

            findNavController().navigate(R.id.action_showlist3_to_createtask3)


        }

        viewModel.getAllTask()
        viewModel.alltask.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.failure -> {
                    Log.i("tag", "fail marce ${it.message}")
                }
                is UiState.loading -> {
                    Log.i("tag", "loading")
                }

                is UiState.success -> {
                    var data: List<Note> = it.data!!
                    recyclerview(data)


                }
            }
        }
    }

    private fun recyclerview(data: List<Note>) {
       val showlistadapter=showlistadapter(requireActivity(),data)
       binding.noteListRecyclerview.adapter=showlistadapter
    }
}




