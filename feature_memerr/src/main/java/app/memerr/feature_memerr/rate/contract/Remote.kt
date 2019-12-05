package app.memerr.feature_memerr.rate.contract

import app.memerr.feature_memerr.rate.contract.Contract
import app.memerr.feature_memerr.shared.api.MemerrService
import app.memerr.feature_memerr.shared.model.Meme

class Remote(
    val api: MemerrService
): Contract.Remote {
    override suspend fun getMemes(page: Int, window: String, sort: String): List<Meme> = api.getMemes(page, window, sort)
}