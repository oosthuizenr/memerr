package app.memerr.feature_memerr.shared.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "rate")
data class Rate (
    val memeId: String,
    val isLiked: Boolean,
    val uploaded: Boolean = false
) {
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
}