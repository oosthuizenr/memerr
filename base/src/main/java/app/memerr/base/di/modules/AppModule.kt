package app.memerr.base.di.modules

import android.app.Application
import android.content.Context
import app.memerr.base.di.component.MemerrAppScope
import dagger.Module
import dagger.Provides

@Module
class AppModule(val app: Application) {
    @Provides
    @MemerrAppScope
    fun providesContext(): Context = app.applicationContext
}