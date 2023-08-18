package com.example.m7_lesson_1.domain.repositories

import com.example.m7_lesson_1.domain.models.ContactEntity
import com.example.m7_lesson_1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ContactRepository {
    fun getContacts(): Flow<Resource<List<ContactEntity>>>

    fun createContact(contactEntity: ContactEntity): Flow<Resource<Unit>>

    fun updateContact(contactEntity: ContactEntity): Flow<Resource<Unit>>

    fun deleteContact(contactEntity: ContactEntity): Flow<Resource<Unit>>
}