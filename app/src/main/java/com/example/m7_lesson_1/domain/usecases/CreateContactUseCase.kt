package com.example.m7_lesson_1.domain.usecases

import com.example.m7_lesson_1.data.models.Contact
import com.example.m7_lesson_1.domain.repositories.ContactRepository
import javax.inject.Inject

class CreateContactUseCase @Inject constructor (private val contactRepository: ContactRepository) {
    fun createContact(contact: Contact) =
        contactRepository.createContact(contact)
}