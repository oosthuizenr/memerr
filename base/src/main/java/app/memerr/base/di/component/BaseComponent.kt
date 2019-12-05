package app.memerr.base.di.component

import android.content.Context
import app.memerr.base.di.modules.AppModule
import app.memerr.base.di.modules.GsonModule
import app.memerr.base.di.modules.OkHttpModule
import app.memerr.base.di.modules.RetrofitModule
import com.google.gson.Gson
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class MemerrAppScope

@MemerrAppScope
@Component(modules = [
    AppModule::class,
    GsonModule::class,
    OkHttpModule::class,
    RetrofitModule::class
])
interface BaseComponent {
    val context: Context
    val gson: Gson
    val retrofit: Retrofit
}