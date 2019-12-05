package app.memerr.feature_memerr.rate.di.component

import app.memerr.feature_memerr.rate.contract.MemesDataSource
import app.memerr.feature_memerr.rate.di.modules.AdapterModule
import app.memerr.feature_memerr.rate.di.modules.ContractModule
import app.memerr.feature_memerr.rate.view.RateFragment
import app.memerr.feature_memerr.shared.di.component.SharedComponent
import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class RateScope

@RateScope
@Component(
    modules = [
        ContractModule::class,
        AdapterModule::class
    ],
    dependencies = [
        SharedComponent::class
    ]
)
interface RateComponent {
    fun inject(fragment: RateFragment)
    fun inject(datasource: MemesDataSource)

    companion object {
        private var component: RateComponent? = null

        fun component(): RateComponent {
            if (component == null) {
                component = DaggerRateComponent.builder().sharedComponent(SharedComponent.component()).build()
            }

            return component!!
        }

        fun destroy() {
            component = null
        }
    }
}