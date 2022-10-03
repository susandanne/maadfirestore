package com.example.maadfirestore.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maadfirestore.R
import com.example.maadfirestore.data.model.Note
import com.example.maadfirestore.databinding.FragmentShowlistBinding

class showlistadapter(
    val context:Context,val createlist: List<Note>
): RecyclerView.Adapter<showlistviewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): showlistviewholder {
//        val binding=FragmentShowlistBinding.inflate(LayoutInflater.from(context),parent,false)
  val view=LayoutInflater.from(context).inflate(R.layout.showlistview,parent,false)
        return showlistviewholder(view)
    }

    override fun onBindViewHolder(holder: showlistviewholder, position: Int) {
          val ntist=createlist[position]
        holder.showtext1.text=ntist.noteText

    }

    override fun getItemCount(): Int {
        return createlist.size
    }
}