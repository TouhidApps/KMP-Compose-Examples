import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MyViewModel(
    private val platform: Platform
): ViewModel() {

    private val _greeting = MutableStateFlow("")
    val greeting = _greeting.asStateFlow()

    init {
        fetchPlatformGreeting()
    }

    private fun fetchPlatformGreeting() {
        viewModelScope.launch {
            _greeting.value = platform.name
        }
    }

    fun changeMyValue() {
        viewModelScope.launch {
            _greeting.value = "Touhid Apps Learn"
        }
    }

}