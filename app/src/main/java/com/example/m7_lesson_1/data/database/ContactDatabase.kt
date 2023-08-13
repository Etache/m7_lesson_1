package com.example.m7_lesson_1.data.database

import androidx.room.Database
import com.example.m7_lesson_1.data.database.dao.ContactDao
import com.example.m7_lesson_1.data.models.Contact

@Database(entities = [Contact::class], [],1)
abstract class ContactDatabase {
    abstract fun getContactDao(): ContactDao
}