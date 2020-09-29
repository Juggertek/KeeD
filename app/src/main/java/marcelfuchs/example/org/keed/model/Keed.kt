package marcelfuchs.example.org.keed.model

import java.sql.Date
import java.sql.Time

data class Keed(
    val kill: Int,
    val death: Int,
    val creationDate: Date = Date(System.currentTimeMillis()),
    val creationTime: Time = Time(System.currentTimeMillis()),
    val ratio: Float = (kill.toFloat() / if (death != 0) death.toFloat() else 1.toFloat())
)