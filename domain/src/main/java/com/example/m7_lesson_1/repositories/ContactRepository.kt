package com.example.m7_lesson_1.repositories

import com.example.m7_lesson_1.models.ContactEntity
import com.example.m7_lesson_1.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ContactRepository {
    fun getContacts(): Flow<Resource<List<ContactEntity>>>

    fun createContact(contactEntity: ContactEntity): Flow<Resource<Unit>>

    fun updateContact(contactEntity: ContactEntity): Flow<Resource<Unit>>

    fun deleteContact(contactEntity: ContactEntity): Flow<Resource<Unit>>
}