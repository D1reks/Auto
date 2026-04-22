package by.vladislav.test.doman

interface UserRepository {
    suspend fun provideSomeData(): String
}