package app.memerr.feature_memerr.rate.contract

import androidx.paging.PageKeyedDataSource
import app.memerr.feature_memerr.rate.di.component.RateComponent
import app.memerr.feature_memerr.shared.di.component.SharedComponent
import app.memerr.feature_memerr.shared.model.Meme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MemesDataSource(private val scope: CoroutineScope): PageKeyedDataSource<Int, Meme>() {
    @Inject
    lateinit var repository: Contract.Repository

    init {
        RateComponent.component().inject(this)
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Meme>
    ) {
        scope.launch {
            try {
                val memes = repository.getMemes(1)

                callback.onResult(memes, 1, 2)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Meme>) {
        scope.launch {
            try {
                val memes = repository.getMemes(params.key)

                callback.onResult(memes, params.key + 1)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Meme>) {
//        scope.launch {
//            try {
//                val memes = repository.getMemes(params.key)
//
//                callback.onResult(memes, params.key + 1)
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
    }
}