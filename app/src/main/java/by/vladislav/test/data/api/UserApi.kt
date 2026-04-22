package by.vladislav.test.data.api

import by.vladislav.test.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: String): UserResponse

    @GET("users")
    suspend fun getUsers(): List<UserResponse>

}