package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), INOtesRVAdapter {
    private val viewModel: NoteViewModel by viewModel()

  //  lateinit var viewModel: NoteViewModel
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycleview)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = NotesRvAdapter(this, this)
        recyclerView.adapter = adapter

      //  viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)

        viewModel.clientes.observe(this, Observer { list ->
            list?.let {
                adapter.updateList(it)
            }
        }
        )


    }

    override fun onItemClicked(note: Note) {

    }

    fun Save(view: View) {
        val data = findViewById<EditText>(R.id.editTextTextPersonName)
        viewModel.insert(Note(data.text.toString()))
    }
}