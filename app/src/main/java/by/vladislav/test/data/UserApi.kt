package by.vladislav.test.data

object UserApi {

    suspend fun provideDataFromServer(): String {
        return "Here are ur data"
    }
}