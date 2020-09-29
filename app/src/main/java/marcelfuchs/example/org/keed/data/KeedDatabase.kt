package marcelfuchs.example.org.keed.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import marcelfuchs.example.org.keed.converter.Converters
import marcelfuchs.example.org.keed.model.Keed

@Database(entities = [Keed::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class KeedDatabase : RoomDatabase() {
    abstract fun keedDao(): KeedDao

    companion object {
        @Volatile
        private var INSTANCE: KeedDatabase? = null
        fun getInstance(context: Context): KeedDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        KeedDatabase::class.java,
                        "keed_history_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}