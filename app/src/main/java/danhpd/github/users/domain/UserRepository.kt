package danhpd.github.users.domain

import danhpd.github.users.data.models.User

interface UserRepository {
    suspend fun getUsers(size: Int): List<User>
}