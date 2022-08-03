package danhpd.github.users.domain

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import danhpd.github.users.data.models.User

enum class Status {
    INITIAL,
    PROCESSING,
    USERS_LOADED
}
data class UserListScreenState(
    var status: MutableState<Status> = mutableStateOf(Status.INITIAL),
    val users: SnapshotStateList<User> = mutableStateListOf()
)