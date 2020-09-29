package marcelfuchs.example.org.keed.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import marcelfuchs.example.org.keed.model.Keed

@Dao
interface KeedDao {
    @Insert
    suspend fun addKeed(keed: Keed)

    @Delete
    suspend fun deleteKeed(keed: Keed)

    @Query("DELETE FROM keed_table")
    suspend fun deleteAllKeed()

    @Query("SELECT * FROM keed_table")
    fun readAllData():LiveData<List<Keed>>
}