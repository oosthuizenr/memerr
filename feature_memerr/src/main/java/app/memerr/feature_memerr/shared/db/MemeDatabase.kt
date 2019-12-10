package app.memerr.feature_memerr.shared.db

import androidx.room.Database
import androidx.room.RoomDatabase
import app.memerr.feature_memerr.shared.model.Rate

@Database(
    entities = [
        Rate::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MemeDatabase: RoomDatabase() {
    abstract fun rateDao(): RateDao
}