package com.example.notepad.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notepad.models.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM Note ORDER BY dateCreate DESC")
    fun readAllDataDayCreateDe(): List<Note>

    @Query("SELECT * FROM Note ORDER BY dateUpdate ASC")
    fun readAllDataDayCreateIn(): List<Note>

    @Query("SELECT * FROM Note ORDER BY dateUpdate ASC")
    fun readAllDataTitleAtoZ(): List<Note>

    @Query("SELECT * FROM Note ORDER BY dateUpdate DESC")
    fun readAllDataTitleZtoA(): List<Note>

    @Query("SELECT * FROM Note ORDER BY dateUpdate DESC")
    fun readAllDataDayUpdateDe(): List<Note>

    @Query("SELECT * FROM Note ORDER BY dateUpdate ASC")
    fun readAllDataDayUpdateIn(): List<Note>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note)

    @Query("UPDATE Note SET title = :title AND content = :content AND dateUpdate = :date WHERE id = :id")
    fun update(title: String, content: String, date: String, id: Int)

    @Delete
    fun delete(note: Note)
}