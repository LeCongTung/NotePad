package com.example.notepad.feature.home

import android.R
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.notepad.databases.NoteDatabase
import com.example.notepad.databinding.ActivityHomeBinding
import com.example.notepad.feature.home.adapter.NoteAdapter
import com.example.notepad.feature.note.NoteActivity
import com.example.notepad.models.Note
import java.util.Arrays


class HomeActivity : AppCompatActivity() {

    //    MARK: Init
    private lateinit var binding: ActivityHomeBinding
    private val noteDatabase by lazy { NoteDatabase.getDatabase(this).noteDao() }

    //    MARK: Properties
    private var listNote = listOf<Note>()
    private val listItems = arrayOf("C", "C++", "JAVA", "PYTHON")
    private val checkedItems = BooleanArray(listItems.size)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initEventListener()
    }

    override fun onRestart() {
        super.onRestart()

    }

    override fun onResume() {
        super.onResume()

        observeNotes()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initEventListener() {
        binding.buttonSetting.setOnClickListener {

        }

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, NoteActivity::class.java))
        }

        binding.btnSort.setOnClickListener {
            openDialogSort()
        }
    }

    private fun observeNotes() {
        listNote = noteDatabase.readAllDataDayUpdateDe()
        binding.rvNotes.adapter = NoteAdapter(this, listNote)
    }

    private fun openDialogSort(){
        val listSort = arrayOf("dayUpdate decrease", "dayUpdate increase", "title A-Z", "title Z-A", "dateCreate increase", "dateCreate decrease") // them item vo day
        val mBuilder = AlertDialog.Builder(this)
        mBuilder.setTitle("Choose an item")
        mBuilder.setSingleChoiceItems(listSort, -1) { dialogInterface, i ->
            Toast.makeText(this, listSort[i], Toast.LENGTH_SHORT).show()

            when (i){
                0 ->  listNote = noteDatabase.readAllDataDayUpdateDe()
                1 ->  listNote = noteDatabase.readAllDataDayUpdateIn()
                2 ->  listNote = noteDatabase.readAllDataTitleAtoZ()
                3 ->  listNote = noteDatabase.readAllDataTitleZtoA()
                4 ->  listNote = noteDatabase.readAllDataDayCreateDe()
                5 ->  listNote = noteDatabase.readAllDataDayCreateIn()
            }
            binding.rvNotes.adapter = NoteAdapter(this, listNote)
            dialogInterface.dismiss()
        }
        // Set the neutral/cancel button click listener
        mBuilder.setNeutralButton("Cancel") { dialog, which ->
            // Do something when click the neutral button
            dialog.cancel()
        }

        val mDialog = mBuilder.create()
        mDialog.show()
    }
}