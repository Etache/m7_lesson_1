package com.example.m7_lesson_1.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m7_lesson_1.domain.models.ContactEntity
import com.example.m7_lesson_1.domain.usecases.CreateContactUseCase
import com.example.m7_lesson_1.domain.usecases.DeleteContactUseCase
import com.example.m7_lesson_1.domain.usecases.GetContactUseCase
import com.example.m7_lesson_1.domain.usecases.UpdateContactUseCase
import com.example.m7_lesson_1.domain.utils.Resource
import com.example.m7_lesson_1.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    private val getContactUseCase: GetContactUseCase,
    private val createContactUseCase: CreateContactUseCase,
    private val updateContactUseCase: UpdateContactUseCase,
    private val deleteContactUseCase: DeleteContactUseCase
) : ViewModel() {

    private val _getContactMutableStateFlow = MutableStateFlow<UIState<List<ContactEntity>>>(UIState.Empty())
    val getAllContacts: StateFlow<UIState<List<ContactEntity>>> = _getContactMutableStateFlow

    private val _createContactMutableStateFlow = MutableStateFlow<UIState<ContactEntity>>(UIState.Empty())
    val createContact: StateFlow<UIState<ContactEntity>> = _createContactMutableStateFlow

    private val _updateContactMutableStateFlow = MutableStateFlow<UIState<ContactEntity>>(UIState.Empty())
    val updateContact: StateFlow<UIState<ContactEntity>> = _updateContactMutableStateFlow

    private val _deleteContactMutableStateFlow = MutableStateFlow<UIState<ContactEntity>>(UIState.Empty())
    val deleteContact: StateFlow<UIState<ContactEntity>> = _deleteContactMutableStateFlow


    fun getAllContacts() {
        viewModelScope.launch {
            getContactUseCase.getContacts().collect() {
                when (it) {
                    is Resource.Error -> {
                        _getContactMutableStateFlow.value = UIState.Error(it.message ?: "Some error")
                    }
                    is Resource.Loading -> {
                        _getContactMutableStateFlow.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _getContactMutableStateFlow.value = UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }

    fun createContacts(contactEntity: ContactEntity) {
        viewModelScope.launch {
            createContactUseCase.createContact(contactEntity).collect() {
                when (it) {
                    is Resource.Error -> {
                        _getContactMutableStateFlow.value = UIState.Error(it.message ?: "Create error")
                    }
                    is Resource.Loading -> {
                        _getContactMutableStateFlow.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _getContactMutableStateFlow.value = UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }

    fun updateContact(contactEntity: ContactEntity) {
        viewModelScope.launch {
            updateContactUseCase.updateContact(contactEntity).collect() {
                when (it) {
                    is Resource.Error -> {
                        _updateContactMutableStateFlow.value = UIState.Error(it.message ?: "Update error")
                    }
                    is Resource.Loading -> {
                        _updateContactMutableStateFlow.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _updateContactMutableStateFlow.value = UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }

    fun deleteContact(contactEntity: ContactEntity) {
        viewModelScope.launch {
            deleteContactUseCase.deleteContact(contactEntity).collect() {
                when (it) {
                    is Resource.Error -> {
                        _deleteContactMutableStateFlow.value = UIState.Error(it.message ?: "Delete error")
                    }
                    is Resource.Loading -> {
                        _deleteContactMutableStateFlow.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _deleteContactMutableStateFlow.value = UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }

}