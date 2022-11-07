package com.example.maadfirestore.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.maadfirestore.R
import com.example.maadfirestore.databinding.FragmentShowlistBinding

class showlistviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    public var itemName: TextView = itemView.findViewById(R.id.title)
    public var itemAmount: TextView = itemView.findViewById(R.id.description)



}