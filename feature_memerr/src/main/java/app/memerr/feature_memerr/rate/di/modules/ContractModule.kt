package app.memerr.feature_memerr.rate.di.modules

import app.memerr.feature_memerr.shared.api.MemerrService
import app.memerr.feature_memerr.rate.contract.Contract
import app.memerr.feature_memerr.rate.contract.MemerrRepository
import app.memerr.feature_memerr.rate.contract.Remote
import app.memerr.feature_memerr.rate.di.component.RateScope
import dagger.Module
import dagger.Provides

@Module
class ContractModule {
    @RateScope
    @Provides
    fun providesRemote(api: MemerrService): Contract.Remote =
        Remote(api)

    @RateScope
    @Provides
    fun providesRepository(remote: Contract.Remote): Contract.Repository =
        MemerrRepository(remote)
}