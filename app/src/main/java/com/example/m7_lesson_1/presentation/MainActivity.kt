package com.example.m7_lesson_1.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.m7_lesson_1.R
import com.example.m7_lesson_1.domain.models.ContactEntity
import com.example.m7_lesson_1.presentation.utils.UIState
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

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

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getAllContacts.collect {
                    when (it) {
                        is UIState.Loading -> {
                            println("Show progeress bar")
                        }
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Success -> {
                            println("Show data in recycler view")
                        }
                    }
                }
            }
        }
    }

    private fun createContact() {
        viewModel.createContacts(contactEntity)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.createContact.collect {
                    when (it) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Loading -> {
                            println("Show progress bar")
                        }
                        is UIState.Success -> {
                            println("Show data in recycler view")
                        }
                    }
                }
            }
        }
    }

    private fun updateContact() {
        viewModel.updateContact(contactEntity)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.updateContact.collect {
                    when (it) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Loading -> {
                            println("Show progress bar")
                        }
                        is UIState.Success -> {
                            println("Show data in recycler view")
                        }
                    }
                }
            }
        }
    }

    private fun deleteContact() {
        viewModel.deleteContact(contactEntity)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.deleteContact.collect {
                    when (it) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Loading -> {
                            println("Show progress bar")
                        }
                        is UIState.Success -> {
                            println("Show data in recycler view")
                        }
                    }
                }
            }
        }
    }
}