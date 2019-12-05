package app.memerr.feature_memerr.shared.api

import app.memerr.feature_memerr.shared.model.Meme
import retrofit2.http.GET
import retrofit2.http.Query

interface MemerrService {
    @GET("memes")
    suspend fun getMemes(
        @Query("page")
        page: Int,
        @Query("window")
        window: String,
        @Query("sort")
        sort: String
    ): List<Meme>
}