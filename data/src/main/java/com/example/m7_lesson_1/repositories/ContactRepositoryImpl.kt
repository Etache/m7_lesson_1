package com.example.m7_lesson_1.repositories

import com.example.m7_lesson_1.base.BaseRepository
import com.example.m7_lesson_1.database.dao.ContactDao
import kotlinx.coroutines.flow.Flow
import com.example.m7_lesson_1.mapToContactEntity
import com.example.m7_lesson_1.models.Contact
import com.example.m7_lesson_1.models.ContactEntity
import com.example.m7_lesson_1.utils.Resource
import javax.inject.Inject

class ContactRepositoryImpl @Inject constructor(
    private val contactDao: ContactDao
) : ContactRepository, BaseRepository() {

    private lateinit var contact: Contact

    override fun getContacts(): Flow<Resource<List<ContactEntity>>> = makeRequest {
        contactDao.getContacts().mapToContactEntity()
    }

    override fun createContact(contactEntity: ContactEntity): Flow<Resource<Unit>> = makeRequest {
        contactDao.createContact(contact)
    }

    override fun deleteContact(contactEntity: ContactEntity): Flow<Resource<Unit>> = makeRequest {
        contactDao.deleteContact(contact)
    }

    override fun updateContact(contactEntity: ContactEntity): Flow<Resource<Unit>> = makeRequest {
        contactDao.updateContact(contact)
    }
}