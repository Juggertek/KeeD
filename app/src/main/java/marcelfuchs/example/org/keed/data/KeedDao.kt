package marcelfuchs.example.org.keed.data
//
//import androidx.lifecycle.LiveData
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.Query
//import androidx.room.Update
//
//@Dao
//interface KeedDatabaseDao {
//    @Insert
//    fun insert(keed: Keed)
//
//    @Update
//    fun update(keed: Keed)
//
//    @Query("SELECT * from keed_table WHERE keedId = :key")
//    fun get(key: Long): Keed?
//
//    @Query("DELETE FROM keed_table")
//    fun clear()
//
//    @Query("SELECT * FROM keed_table ORDER BY keedId DESC")
//    fun getAllKeed(): LiveData<List<Keed>>
//
//    @Query("SELECT * FROM keed_table ORDER BY keedId DESC LIMIT 1")
//    fun getKeed(): Keed?
//}