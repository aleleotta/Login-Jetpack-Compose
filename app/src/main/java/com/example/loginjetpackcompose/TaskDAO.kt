package com.example.loginjetpackcompose

import androidx.room.Dao
import androidx.room.Query

@Dao
interface TaskDAO {
    @Query("SELECT * FROM contacts")
    fun getAll(): List<Contact>

    @Query("SELECT * FROM contacts WHERE id = :id")
    fun getById(id: Long): Contact

    @Query("INSERT INTO contacts (name, phoneNumber, gender) VALUES (:name, :phoneNumber, :gender)")
    fun insert(name: String, phoneNumber: String, gender: String)


}