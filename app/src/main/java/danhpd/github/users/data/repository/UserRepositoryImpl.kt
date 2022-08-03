package danhpd.github.users.data.repository

import danhpd.github.users.data.api.ApiInterface
import danhpd.github.users.data.models.User
import danhpd.github.users.domain.UserRepository
import retrofit2.await

class UserRepositoryImpl : UserRepository {
    override suspend fun getUsers(size: Int): List<User> {
        val apiInterface = ApiInterface.create().getUsers(size = size)
        return apiInterface.await()
    }

}