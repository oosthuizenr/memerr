package app.memerr.base.app

import android.app.Application
import app.memerr.base.di.component.BaseComponent
import app.memerr.base.di.component.DaggerBaseComponent
import app.memerr.base.di.modules.AppModule

class MemerrApplication: Application() {
    companion object {
        lateinit var baseComponent: BaseComponent
    }

    override fun onCreate() {
        super.onCreate()

        baseComponent = DaggerBaseComponent.builder().appModule(AppModule(this)).build()
    }
}