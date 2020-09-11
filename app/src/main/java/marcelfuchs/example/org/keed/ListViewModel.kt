package marcelfuchs.example.org.keed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {

    val keedList = ArrayList<Keed>()

    // Listengrösse auf Startwert 0 setzen, da die Liste noch nicht initialisiert ist
    private val _listSize = MutableLiveData(0)
    val listSize: LiveData<Int> = _listSize

    init {
        // Arrayliste mit Werten füllen
        for (i in 1..4) {
            val item = Keed(10, i)
            keedList.add(item)
            _listSize.value = (_listSize.value ?: 0) + 1
        }
    }

    fun removeFromList(position: Int) {
        keedList.removeAt(position)
        _listSize.value = (_listSize.value ?: 0) - 1
    }
}