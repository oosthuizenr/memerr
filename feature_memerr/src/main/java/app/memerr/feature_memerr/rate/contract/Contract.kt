package app.memerr.feature_memerr.rate.contract

import app.memerr.feature_memerr.shared.model.Meme

interface Contract {
    interface Remote {
        suspend fun getMemes(page: Int, window: String, sort: String): List<Meme>
    }

    interface Local {
        suspend fun likeMeme(meme: Meme)
        suspend fun dislikeMeme(meme: Meme)
    }

    interface Repository {
        suspend fun getMemes(page: Int, window: String = "day", sort: String = "time"): List<Meme>
        suspend fun likeMeme(meme : Meme)
        suspend fun dislikeMeme(meme: Meme)
    }
}