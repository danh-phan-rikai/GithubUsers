package danhpd.github.users.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserListViewModel(private val userRepository: UserRepository) : ViewModel() {
    val uiState = UserListScreenState()

    init {
        loadUsers()
    }

    fun loadUsers(){
        uiState.status.value = Status.PROCESSING
        viewModelScope.launch {
            val list = userRepository.getUsers(size = 100)
            uiState.users.addAll(list)
            uiState.status.value = Status.USERS_LOADED
        }
    }

}