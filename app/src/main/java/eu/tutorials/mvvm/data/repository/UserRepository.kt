package eu.tutorials.mvvm.data.repository

import eu.tutorials.mvvm.data.model.User
import eu.tutorials.mvvm.data.remote.RetrofitInstance

class UserRepository {
    private val api = RetrofitInstance.api

    suspend fun getUsers(): List<User>{
        return api.getUsers()
    }
}