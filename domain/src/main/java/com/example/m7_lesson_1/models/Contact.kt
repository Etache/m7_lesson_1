package com.example.m7_lesson_1.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val number: String
)
