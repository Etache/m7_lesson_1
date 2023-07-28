package com.example.m7_lesson_1.domain.usecases

import com.example.m7_lesson_1.domain.models.ContactEntity
import com.example.m7_lesson_1.domain.repositories.ContactRepository

class GetContactUseCase (
    private val repository: ContactRepository
) {
    fun getContacts(): List<ContactEntity> {
        return repository.getContacts()
    }
}