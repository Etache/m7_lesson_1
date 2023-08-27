package com.example.m7_lesson_1.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.m7_lesson_1.database.dao.ContactDao
import com.example.m7_lesson_1.models.Contact

@Database(entities = [Contact::class], [],1)
abstract class ContactDatabase: RoomDatabase() {
    abstract fun getContactDao(): ContactDao
}