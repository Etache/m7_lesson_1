package com.example.m7_lesson_1.database.dao

import androidx.room.*
import com.example.m7_lesson_1.models.Contact

@Dao
interface ContactDao {

    @Query("SELECT * FROM contacts")
    suspend fun getContacts(): List<Contact>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)
}