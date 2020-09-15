package marcelfuchs.example.org.keed.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import marcelfuchs.example.org.keed.data.Keed

class ListViewModel : ViewModel() {

    val keedList = ArrayList<Keed>()

    private val _listSize = MutableLiveData<Int>()
    val listSize: LiveData<Int> = _listSize

    init {
        // Arrayliste mit Werten füllen
        for (i in 1..4) {
            val item = Keed(10, i)
            keedList.add(item)
        }
        _listSize.value=keedList.size
        Log.d("ListViewModel","listSize after creation is: ${listSize.value}")
    }

    fun removeFromList(position: Int) {
        keedList.removeAt(position)
        _listSize.value=keedList.size
        Log.d("ListViewModel","listSize is: ${listSize.value}")
    }
}