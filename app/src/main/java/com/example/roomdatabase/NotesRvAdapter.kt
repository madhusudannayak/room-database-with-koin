package com.example.roomdatabase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class NotesRvAdapter(val context: Context,val listener : INOtesRVAdapter) : RecyclerView.Adapter<NotesRvAdapter.NoteViewHolder>() {
    val allNotes = ArrayList<Note>()

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textview = itemView.findViewById<TextView>(R.id.text)
        val delete = itemView.findViewById<ImageView>(R.id.delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
       val viewholder =NoteViewHolder( LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
        viewholder.delete.setOnClickListener {allNotes[viewholder.adapterPosition]

        }
        return viewholder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.textview.text =currentNote.text
    }

    override fun getItemCount(): Int {
       return allNotes.size
    }
    fun updateList(newList: List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }
}
interface  INOtesRVAdapter{
    fun onItemClicked(note: Note)
}