package com.example.m7_lesson_1.domain.mapper

import com.example.m7_lesson_1.data.models.Contact
import com.example.m7_lesson_1.domain.models.ContactEntity

fun List<Contact>.mapToContactEntity() = this.map {
    ContactEntity(
        id = it.id,
        name = it.name,
        number = it.number
    )
}