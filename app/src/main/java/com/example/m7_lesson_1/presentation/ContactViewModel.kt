package com.example.m7_lesson_1.presentation

import com.example.m7_lesson_1.domain.models.ContactEntity
import com.example.m7_lesson_1.domain.usecases.CreateContactUseCase
import com.example.m7_lesson_1.domain.usecases.DeleteContactUseCase
import com.example.m7_lesson_1.domain.usecases.GetContactUseCase
import com.example.m7_lesson_1.domain.usecases.UpdateContactUseCase
import com.example.m7_lesson_1.presentation.base.BaseViewModel
import com.example.m7_lesson_1.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    private val getContactUseCase: GetContactUseCase,
    private val createContactUseCase: CreateContactUseCase,
    private val updateContactUseCase: UpdateContactUseCase,
    private val deleteContactUseCase: DeleteContactUseCase
) : BaseViewModel() {

    private val _getContactMutableStateFlow = MutableStateFlow<UIState<List<ContactEntity>>>(UIState.Empty())
    val getAllContacts: StateFlow<UIState<List<ContactEntity>>> = _getContactMutableStateFlow

    private val _createContactMutableStateFlow = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val createContact: StateFlow<UIState<Unit>> = _createContactMutableStateFlow

    private val _updateContactMutableStateFlow = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val updateContact: StateFlow<UIState<Unit>> = _updateContactMutableStateFlow

    private val _deleteContactMutableStateFlow = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val deleteContact: StateFlow<UIState<Unit>> = _deleteContactMutableStateFlow


    fun getAllContacts() {
        getContactUseCase.getContacts().collectData(_getContactMutableStateFlow)
    }

    fun createContacts(contactEntity: ContactEntity) {
        createContactUseCase.createContact(contactEntity).collectData(_createContactMutableStateFlow)
    }

    fun updateContact(contactEntity: ContactEntity) {
        updateContactUseCase.updateContact(contactEntity).collectData(_updateContactMutableStateFlow)
    }

    fun deleteContact(contactEntity: ContactEntity) {
        deleteContactUseCase.deleteContact(contactEntity).collectData(_deleteContactMutableStateFlow)
    }

}