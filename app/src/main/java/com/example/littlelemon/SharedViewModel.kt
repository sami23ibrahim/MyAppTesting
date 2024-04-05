
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class SharedViewModel : ViewModel() {
     val _userName = MutableLiveData<String>("=>SharedViewModel<=")
    val userName: MutableLiveData<String> = _userName

    fun setUserName(newName: String) {
        _userName.value = newName // This updates the LiveData's value
    }
}