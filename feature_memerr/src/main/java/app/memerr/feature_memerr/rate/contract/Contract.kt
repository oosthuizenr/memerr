package app.memerr.feature_memerr.rate.contract

import app.memerr.feature_memerr.shared.model.Meme

interface Contract {
    interface Remote {
        suspend fun getMemes(page: Int, window: String, sort: String): List<Meme>
    }

    interface Repository {
        suspend fun getMemes(page: Int, window: String = "day", sort: String = "time"): List<Meme>
    }
}