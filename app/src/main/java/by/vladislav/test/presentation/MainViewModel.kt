package by.vladislav.test.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.vladislav.test.doman.Analytics
import by.vladislav.test.doman.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: UserRepository,
    private val analytics: Analytics
) : ViewModel() {

    private val _userData = MutableStateFlow<String?>(null)
    val userData = _userData.asStateFlow()

    private val _screenTime = MutableStateFlow<Int?>(null)
    val screenTime = _screenTime.asStateFlow()

    init {
        viewModelScope.launch {
            _userData.value = repository.provideSomeData()
            _screenTime.value = analytics.trackNumberOfClicks()
        }
    }

}