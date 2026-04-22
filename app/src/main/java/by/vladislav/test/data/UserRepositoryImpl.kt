package by.vladislav.test.data

import by.vladislav.test.doman.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi
): UserRepository {
    override suspend fun provideSomeData(): String{
        return api.provideDataFromServer()
    }
}