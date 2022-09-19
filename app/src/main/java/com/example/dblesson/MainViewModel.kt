package com.example.dblesson

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(private val userDao: UserDao): ViewModel() {
    val allUsers = this.userDao.getAll()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )

    fun onAddBtn() {
        val size = allUsers.value.size
//        viewModelScope.launch {
        CoroutineScope(Dispatchers.IO).launch {
            userDao.insert(
                NewUser(
                    firstName = "Name $size",
                    lastName = "Lastname $size",
                    age = size
                )
            )
        }
    }

    fun onUpdateBtn() {
//        viewModelScope.launch {
        CoroutineScope(Dispatchers.IO).launch {
            allUsers.value.lastOrNull()?.let {
                val user = it.copy(
                    lastName = "Petrov"
                )
                userDao.update(user)
            }
        }
    }

    fun onDeleteBtn() {
        CoroutineScope(Dispatchers.IO).launch {
            allUsers.value.lastOrNull()?.let {userDao.delete(it)}
        }
    }
}