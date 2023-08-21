package com.example.m7_lesson_1.data.repositories

import com.example.m7_lesson_1.data.base.BaseRepository
import com.example.m7_lesson_1.data.database.dao.ContactDao
import com.example.m7_lesson_1.data.models.Contact
import com.example.m7_lesson_1.domain.mapper.mapToContactEntity
import com.example.m7_lesson_1.domain.models.ContactEntity
import com.example.m7_lesson_1.domain.repositories.ContactRepository
import com.example.m7_lesson_1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
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