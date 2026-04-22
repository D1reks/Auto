package by.vladislav.test.hilt

import by.vladislav.test.data.UserRepositoryImpl
import by.vladislav.test.doman.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun provideRepository(impl: UserRepositoryImpl) : UserRepository

}