package eu.tutorials.mvvm.viewmodel

import eu.tutorials.mvvm.data.model.User

sealed interface UserUiState {
    object Loading : UserUiState
    data class Success(val users: List<User>) : UserUiState
    data class Error(val message: String) : UserUiState
}