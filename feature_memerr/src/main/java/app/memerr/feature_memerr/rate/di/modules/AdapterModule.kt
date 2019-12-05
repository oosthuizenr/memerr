package app.memerr.feature_memerr.rate.di.modules

import app.memerr.feature_memerr.rate.adapter.CardStackAdapter
import app.memerr.feature_memerr.rate.di.component.RateScope
import dagger.Module
import dagger.Provides

@Module
class AdapterModule {
    @Provides
    @RateScope
    fun providesCardStackAdapter() = CardStackAdapter()
}