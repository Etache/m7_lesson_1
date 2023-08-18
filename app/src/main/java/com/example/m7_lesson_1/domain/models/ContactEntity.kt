package com.example.m7_lesson_1.domain.models

data class ContactEntity(
    val id: Int,
    val name: String? = null,
    val number: String? = null
)