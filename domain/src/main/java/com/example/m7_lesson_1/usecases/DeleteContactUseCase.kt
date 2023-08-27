package com.example.m7_lesson_1.usecases

import com.example.m7_lesson_1.models.ContactEntity
import com.example.m7_lesson_1.repositories.ContactRepository
import javax.inject.Inject

class DeleteContactUseCase @Inject constructor(private val contactRepository: ContactRepository) {
    fun deleteContact(contactEntity: ContactEntity) =
        contactRepository.deleteContact(contactEntity)
}