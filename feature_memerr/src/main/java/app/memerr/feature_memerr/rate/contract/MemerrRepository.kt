package app.memerr.feature_memerr.rate.contract

import app.memerr.feature_memerr.rate.contract.Contract
import app.memerr.feature_memerr.shared.model.Meme

class MemerrRepository(
    val remote: Contract.Remote
): Contract.Repository {
    override suspend fun getMemes(page: Int, window: String, sort: String): List<Meme> = remote.getMemes(page, window, sort)
}