package app.memerr.feature_memerr.shared.di.component

import android.content.Context
import app.memerr.base.app.MemerrApplication
import app.memerr.base.di.component.BaseComponent
import app.memerr.feature_memerr.rate.contract.MemesDataSource
import app.memerr.feature_memerr.shared.api.MemerrService
import app.memerr.feature_memerr.shared.di.modules.ApiModule
import app.memerr.feature_memerr.rate.di.modules.ContractModule
import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class MemerrSharedScope

@MemerrSharedScope
@Component(
    modules = [
        ApiModule::class
    ],
    dependencies = [
        BaseComponent::class
    ]
)
interface SharedComponent {
    val context: Context
    val memerrService: MemerrService

    companion object {
        private var component: SharedComponent? = null

        fun component(): SharedComponent {
            if (component == null) {
                component = DaggerSharedComponent.builder().baseComponent(MemerrApplication.baseComponent).build()
            }

            return component!!
        }

        fun destroy() {
            component = null
        }
    }
}

