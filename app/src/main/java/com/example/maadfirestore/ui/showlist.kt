package com.example.maadfirestore.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.maadfirestore.R
import com.example.maadfirestore.databinding.ActivityMainBinding.inflate
import com.example.maadfirestore.databinding.FragmentShowlistBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.zip.Inflater

@AndroidEntryPoint
class showlist : Fragment() {

    lateinit var binding: FragmentShowlistBinding
    val viewModel:taskviewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return if (this::binding.isInitialized) {
            binding.root
        } else {
            binding = FragmentShowlistBinding.inflate(inflater,container,false)

            return binding.root
        }


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllTask()
        viewModel.allNotes.observe(viewLifecycleOwner){
          for (note in it){
              Log.i("TAG", "Task : $note ")

              val showlistadapter=showlistadapter(requireContext(),it)
              binding.showlistrecview.adapter=showlistadapter

          }
        }

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_showlist3_to_showdetails3)
        }
    }

}