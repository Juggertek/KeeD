package marcelfuchs.example.org.keed

import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {

    var keedList: ArrayList<Keed> = ArrayList()

    init {
        // Arrayliste mit Werten füllen
        for (i in 1..4) {
            val item = Keed(10, i)
            keedList.add(item)
        }
    }
}