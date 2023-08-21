package com.example.m7_lesson_1.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.example.m7_lesson_1.R
import com.example.m7_lesson_1.domain.models.ContactEntity
import com.example.m7_lesson_1.presentation.base.BaseActivity

class MainActivity : BaseActivity() {

    private val viewModel by viewModels<ContactViewModel>()
    private lateinit var contactEntity: ContactEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getContacts()
        createContact()
        updateContact()
        deleteContact()
    }

    private fun getContacts() {
        viewModel.getAllContacts()
        viewModel.getAllContacts.collectInfo(
            loadingState = {
                println("SHOW PROGRESS BAR")
            },
            emptyState = {
                println("DATA IS EMPTY")
            },
            errorState = {
                println("SOME ERROR: $it")
            },
            successState = {
                println("IT IS DATA: $it")
            })
    }

    private fun createContact() {
        viewModel.createContacts(contactEntity)
        viewModel.createContact.collectInfo(
            loadingState = {
                println("SHOW PROGRESS BAR")
            },
            emptyState = {
                println("DATA IS EMPTY")
            },
            errorState = {
                println("SOME ERROR: $it")
            },
            successState = {
                println("IT IS DATA: $it")
            }
        )
    }

    private fun updateContact() {
        viewModel.updateContact(contactEntity)
        viewModel.updateContact.collectInfo(
            loadingState = {
                println("SHOW PROGRESS BAR")
            },
            emptyState = {
                println("DATA IS EMPTY")
            },
            errorState = {
                println("SOME ERROR: $it")
            },
            successState = {
                println("IT IS DATA: $it")
            }
        )
    }

    private fun deleteContact() {
        viewModel.deleteContact(contactEntity)
        viewModel.deleteContact.collectInfo(
            loadingState = {
                println("SHOW PROGRESS BAR")
            },
            emptyState = {
                println("DATA IS EMPTY")
            },
            errorState = {
                println("SOME ERROR: $it")
            },
            successState = {
                println("IT IS DATA: $it")
            }
        )
    }
}