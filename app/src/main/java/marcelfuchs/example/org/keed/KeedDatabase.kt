package marcelfuchs.example.org.keed
////
////import android.content.Context
////import androidx.room.Database
////import androidx.room.Room
////import androidx.room.RoomDatabase
////
////@Database(entities = [Keed::class], version = 1, exportSchema = false)
////abstract class KeedDatabase : RoomDatabase() {
////    abstract val keedDatabaseDao: KeedDatabaseDao
////
////    companion object {
////        @Volatile
////        private var INSTANCE: KeedDatabase? = null
////        fun getInstance(context: Context): KeedDatabase {
////            synchronized(this) {
////                var instance = INSTANCE
////
////                if (instance == null) {
////                    instance = Room.databaseBuilder(
////                        context.applicationContext,
////                        KeedDatabase::class.java,
////                        "keed_history_database"
////                    ).fallbackToDestructiveMigration().build()
////                    INSTANCE = instance
////                }
////                return instance
////            }
////        }
////    }
////}