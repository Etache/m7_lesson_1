package com.example.m7_lesson_1.domain.repositories

import com.example.m7_lesson_1.data.models.Contact

interface ContactRepository {
    fun getContacts(): List<Contact>

    fun createContact(contact: Contact)

    fun updateContact(contact: Contact)

    fun deleteContact(contact: Contact)
}