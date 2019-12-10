package app.memerr.feature_memerr.shared.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import app.memerr.feature_memerr.shared.model.Rate

@Dao
abstract class RateDao {
    @Insert
    abstract suspend fun insert(vararg rate: Rate)

    @Query("UPDATE rate SET uploaded = 1 WHERE id IN (:id)")
    abstract suspend fun markAsUploaded(vararg id: String)

    @Query("SELECT * FROM rate WHERE uploaded = 0")
    abstract suspend fun getRatingsToUpload(): List<Rate>
}