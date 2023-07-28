package com.example.m7_lesson_1.data.repositories

import com.example.m7_lesson_1.data.database.dao.ContactDao
import com.example.m7_lesson_1.data.models.Contact
import com.example.m7_lesson_1.domain.repositories.ContactRepository

class ContactRepositoryImpl(
    private val contactDao: ContactDao
) : ContactRepository {
    override fun getContacts(): List<Contact> {
        contactDao.getContacts()
    }

    override fun createContact(contact: Contact) {
        contactDao.createContact(contact)
    }

    override fun updateContact(contact: Contact) {
        contactDao.updateContact(contact)
    }

    override fun deleteContact(contact: Contact) {
        contactDao.deleteContact(contact)
    }
}