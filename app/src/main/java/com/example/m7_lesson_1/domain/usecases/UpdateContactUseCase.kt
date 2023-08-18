package com.example.m7_lesson_1.domain.usecases

import com.example.m7_lesson_1.domain.models.ContactEntity
import com.example.m7_lesson_1.domain.repositories.ContactRepository
import javax.inject.Inject

class UpdateContactUseCase @Inject constructor (private val contactRepository: ContactRepository) {
    fun updateContact(contactEntity: ContactEntity) =
        contactRepository.updateContact(contactEntity)
}