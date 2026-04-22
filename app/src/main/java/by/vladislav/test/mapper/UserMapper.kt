package by.vladislav.test.mapper

import by.vladislav.test.doman.model.User
import by.vladislav.test.model.UserResponse
import jakarta.inject.Inject

class UserMapper @Inject constructor() {

    fun toDomain(response: UserResponse): User {
        return User(
            id = response.id,
            name = response.name,
            email = response.email,
        )
    }

    fun toDomainList(response: List<UserResponse>): List<User>{
        return response.map { toDomain(it) }
    }

}