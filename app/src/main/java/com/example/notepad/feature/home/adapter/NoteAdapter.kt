package com.example.notepad.feature.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notepad.databinding.ItemListBinding
import com.example.notepad.models.Note

class NoteAdapter(
    val context: Context,
    private val listNote: List<Note>
): RecyclerView.Adapter<NoteAdapter.MyViewHolder>() {

    inner class MyViewHolder(var binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listNote.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//      MARK: Binding
        val item = listNote[position]
        holder.binding.titleItem.text = if (item.title.isNullOrEmpty()) item.content else item.title
        holder.binding.date.text = item.dateUpdate.toString()

//        MARK: Events
        holder.binding.item.setOnClickListener {

        }
    }
}