package marcelfuchs.example.org.keed.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import marcelfuchs.example.org.keed.data.KeedDatabase
import marcelfuchs.example.org.keed.model.Keed
import marcelfuchs.example.org.keed.repository.KeedRepository

class ListViewModel(application: Application) : AndroidViewModel(application) {

    val keedList: LiveData<List<Keed>>
    private val repository: KeedRepository

    init {
        val keedDao = KeedDatabase.getInstance(application).keedDao()
        repository = KeedRepository(keedDao)
        keedList = repository.readAllData
    }

    fun addKeed(keed: Keed) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addKeed(keed)
        }
    }

    fun deleteUser(user: Keed) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteKeed(user)
        }
    }
}