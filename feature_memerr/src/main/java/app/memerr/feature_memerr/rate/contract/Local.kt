package app.memerr.feature_memerr.rate.contract

import app.memerr.feature_memerr.shared.db.MemeDatabase
import app.memerr.feature_memerr.shared.model.Meme
import app.memerr.feature_memerr.shared.model.Rate

class Local(private val db: MemeDatabase): Contract.Local {
    override suspend fun likeMeme(meme: Meme) = db.rateDao().insert(Rate(meme.id, true))

    override suspend fun dislikeMeme(meme: Meme) = db.rateDao().insert(Rate(meme.id, false))
}