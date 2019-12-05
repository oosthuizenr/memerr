package app.memerr.feature_memerr.rate.viewmodel

import androidx.lifecycle.*
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import app.memerr.feature_memerr.rate.contract.Contract
import app.memerr.feature_memerr.rate.contract.MemesDataSource
import app.memerr.feature_memerr.shared.model.Meme
import java.lang.IllegalArgumentException
import javax.inject.Inject

class RateViewModel(
    val repository: Contract.Repository
) : ViewModel() {
    var memes: LiveData<PagedList<Meme>>
    var currentTop = 0

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(30)
            .setEnablePlaceholders(false)
            .build()

        memes = initializePagedListBuilder(config).build()
    }

    private fun initializePagedListBuilder(config: PagedList.Config): LivePagedListBuilder<Int, Meme> {
        val dataSourceFactory = object: DataSource.Factory<Int, Meme>() {
            override fun create(): DataSource<Int, Meme> {
                return MemesDataSource(viewModelScope)
            }
        }
        return LivePagedListBuilder<Int, Meme>(dataSourceFactory, config)
    }


    class RateViewModelFactory
    @Inject constructor(
        val repository: Contract.Repository
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(RateViewModel::class.java)) {
                return RateViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown viewmodel class")
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}
