package com.example.m7_lesson_1.data.repositories

import com.example.m7_lesson_1.data.database.dao.ContactDao
import com.example.m7_lesson_1.data.models.Contact
import com.example.m7_lesson_1.domain.mapper.mapToContactEntity
import com.example.m7_lesson_1.domain.models.ContactEntity
import com.example.m7_lesson_1.domain.repositories.ContactRepository
import com.example.m7_lesson_1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ContactRepositoryImpl @Inject constructor(
    private val contactDao: ContactDao
) : ContactRepository {

    override fun getContacts(): Flow<Resource<List<ContactEntity>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = contactDao.getContacts()
                emit(Resource.Success(data.mapToContactEntity()))
            } catch(e: Exception) {
                emit(Resource.Error(e.localizedMessage, null))
            }
        }
    }

    override fun createContact(contact: Contact): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                Resource.Success(contactDao.createContact(contact))
            } catch (e: Exception) {
                Resource.Error(e.localizedMessage)
            }
        }
    }

    override fun updateContact(contact: Contact): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                Resource.Success(contactDao.updateContact(contact))
            } catch (e: Exception) {
                Resource.Error(e.localizedMessage)
            }
        }
    }

    override fun deleteContact(contact: Contact): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                Resource.Success(contactDao.deleteContact(contact))
            } catch (e: Exception) {
                Resource.Error(e.localizedMessage)
            }
        }
    }
}