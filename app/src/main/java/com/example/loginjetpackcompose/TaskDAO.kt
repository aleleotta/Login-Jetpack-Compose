package com.example.loginjetpackcompose

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDAO {
    @Query("SELECT * FROM contacts")
    fun getAll(): List<Contact>

    @Query("SELECT * FROM contacts WHERE id = :id")
    fun getById(id: Long): Contact

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(taskEntity: Contact)

    @Update(onConflict = OnConflictStrategy.ABORT)
    fun updateTask(taskEntity: Contact)

    @Delete
    fun deleteTask(taskEntity: Contact)

    @Query("DELETE FROM contacts WHERE id = :id")
    fun deleteById(id: Long)
}