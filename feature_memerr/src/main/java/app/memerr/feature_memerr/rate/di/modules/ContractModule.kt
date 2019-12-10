package app.memerr.feature_memerr.rate.di.modules

import app.memerr.feature_memerr.shared.api.MemerrService
import app.memerr.feature_memerr.rate.contract.Contract
import app.memerr.feature_memerr.rate.contract.Local
import app.memerr.feature_memerr.rate.contract.MemerrRepository
import app.memerr.feature_memerr.rate.contract.Remote
import app.memerr.feature_memerr.rate.di.component.RateScope
import app.memerr.feature_memerr.shared.db.MemeDatabase
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
    fun providesLocal(db: MemeDatabase): Contract.Local =
        Local(db)

    @RateScope
    @Provides
    fun providesRepository(local: Contract.Local, remote: Contract.Remote): Contract.Repository =
        MemerrRepository(local, remote)
}