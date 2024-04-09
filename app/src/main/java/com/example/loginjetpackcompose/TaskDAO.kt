package com.example.loginjetpackcompose

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TaskDAO {
    @Query("SELECT * FROM contacts")
    fun getAll(): List<Contact>

    @Query("SELECT * FROM contacts WHERE id = :id")
    fun getById(id: Long): Contact

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun newTask(taskEntity: Contact)
}