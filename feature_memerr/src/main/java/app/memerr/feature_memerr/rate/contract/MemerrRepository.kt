package app.memerr.feature_memerr.rate.contract

import app.memerr.feature_memerr.shared.model.Meme

class MemerrRepository(
    private val local: Contract.Local,
    private val remote: Contract.Remote
): Contract.Repository {
    override suspend fun getMemes(page: Int, window: String, sort: String): List<Meme> = remote.getMemes(page, window, sort)

    override suspend fun likeMeme(meme: Meme) = local.likeMeme(meme)

    override suspend fun dislikeMeme(meme: Meme) = local.dislikeMeme(meme)
}