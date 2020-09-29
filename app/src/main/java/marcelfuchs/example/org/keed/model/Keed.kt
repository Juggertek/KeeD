package marcelfuchs.example.org.keed.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
import java.sql.Time

@Entity(tableName = "keed_table")
data class Keed(
    val kill: Int,
    val death: Int,
    @PrimaryKey
    val creationDate: Date = Date(System.currentTimeMillis()),
    val creationTime: Time = Time(System.currentTimeMillis()),
    val ratio: Float = (kill.toFloat() / if (death != 0) death.toFloat() else 1.toFloat())
)