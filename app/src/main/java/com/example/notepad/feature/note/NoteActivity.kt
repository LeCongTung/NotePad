package com.example.notepad.feature.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notepad.databases.NoteDatabase
import com.example.notepad.databinding.ActivityNoteBinding
import com.example.notepad.extensions.getCurrentTime
import com.example.notepad.models.Note

class NoteActivity : AppCompatActivity() {

//    MARK: SetUp
    private lateinit var binding: ActivityNoteBinding
    private val noteDatabase by lazy { NoteDatabase.getDatabase(this).noteDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initEventListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        val note = Note(
            0,
            binding.titleEditText.text.toString(),
            binding.contentEditText.text.toString(),
            this.getCurrentTime(),
            this.getCurrentTime()
        )
        noteDatabase.insert(note)
    }

    private fun initEventListener(){

    }

    override fun onBackPressed() {
        super.onBackPressed()

        finish()
    }
}