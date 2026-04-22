package by.vladislav.test.hilt

import by.vladislav.test.data.AnalyticsImpl
import by.vladislav.test.doman.Analytics
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SdkModule {

    @Binds
    abstract fun provideAnalytics(impl: AnalyticsImpl) : Analytics

}