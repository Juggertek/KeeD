package marcelfuchs.example.org.keed.data

import java.time.LocalDateTime

//import androidx.room.ColumnInfo
//import androidx.room.Entity
//import androidx.room.PrimaryKey

//@Entity(tableName = "keed_table")
data class Keed(val kill: Int, val death: Int) {
    companion object {
        var id = 0L
    }

    //    @PrimaryKey(autoGenerate = true)
    var keedId: Long = ++id

    //    @ColumnInfo(name = "creation_date")
    var creationDateTime = LocalDateTime.now()

    //    @ColumnInfo(name = "creation_time")
//    var creationTime = "Test Time"

    //    @ColumnInfo(name = "ratio")
    var ratio= (kill.toFloat() / death.toFloat())
}