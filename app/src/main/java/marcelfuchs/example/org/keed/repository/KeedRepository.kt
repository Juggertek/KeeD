package marcelfuchs.example.org.keed.repository

import androidx.lifecycle.LiveData
import marcelfuchs.example.org.keed.data.KeedDao
import marcelfuchs.example.org.keed.model.Keed

class KeedRepository(private val keedDao: KeedDao) {

    val readAllData: LiveData<List<Keed>> = keedDao.readAllData()

    suspend fun addUser(keed: Keed) {
        keedDao.addKeed(keed)
    }

    suspend fun deleteUser(keed: Keed) {
        keedDao.deleteKeed(keed)
    }
}