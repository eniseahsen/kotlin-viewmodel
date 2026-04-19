package eu.tutorials.mvvm.data.remote

import eu.tutorials.mvvm.data.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}