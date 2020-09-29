package marcelfuchs.example.org.keed.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import marcelfuchs.example.org.keed.model.Keed

class ListViewModel : ViewModel() {

    val keedList = ArrayList<Keed>()

    private val _listSize = MutableLiveData(0)
    val listSize: LiveData<Int> = _listSize


    fun addItemToList(kill: Int, death: Int) {
        val newItem = Keed(kill, death)
        keedList.add(newItem)
        _listSize.value = keedList.size
    }

    fun removeItemFromList(position: Int) {
        keedList.removeAt(position)
        _listSize.value = keedList.size
    }
}