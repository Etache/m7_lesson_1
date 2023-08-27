package com.example.m7_lesson_1.usecases

import com.example.m7_lesson_1.repositories.ContactRepository

class GetContactUseCase (
    private val repository: ContactRepository
) {
    fun getContacts() = repository.getContacts()
}