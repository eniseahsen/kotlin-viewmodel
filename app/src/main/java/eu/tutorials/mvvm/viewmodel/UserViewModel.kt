package eu.tutorials.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.tutorials.mvvm.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    private val repository = UserRepository()
    private val _uiState = MutableStateFlow<UserUiState>(UserUiState.Loading) //sadece viewmodel içinde değiştirilir
    val uiState: StateFlow<UserUiState> = _uiState //read only
    init{
        fetchUsers()
    }

    fun fetchUsers(){
        viewModelScope.launch{
            _uiState.value = UserUiState.Loading
            try{
                val users = repository.getUsers()
                _uiState.value = UserUiState.Success(users)
            }
            catch (e: Exception){
                _uiState.value = UserUiState.Error(e.message ?: "Bilinmeyen hata")
            }
        }
    }
}