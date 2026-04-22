package by.vladislav.test.data

import by.vladislav.test.doman.Analytics
import javax.inject.Inject
import kotlin.random.Random

class AnalyticsImpl @Inject constructor() : Analytics {
    override fun trackNumberOfClicks(): Int {
        return Random.nextInt(1,5)
    }

}