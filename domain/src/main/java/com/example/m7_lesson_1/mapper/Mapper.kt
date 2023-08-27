package com.example.m7_lesson_1

import com.example.m7_lesson_1.models.ContactEntity
import com.example.m7_lesson_1.models.Contact

fun List<Contact>.mapToContactEntity() = this.map {
    ContactEntity(
        id = it.id,
        name = it.name,
        number = it.number
    )
}