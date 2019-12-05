package app.memerr.base.di.modules

import android.content.Context
import app.memerr.base.di.component.MemerrAppScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

@Module
class OkHttpModule {
    @Provides
    @MemerrAppScope
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC
        return logging
    }

    @Provides
    @MemerrAppScope
    fun providesOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor { chain ->
                var req = chain.request()
                val urlBuilder = req.url().newBuilder()

                // TODO - Add some form of identifier here
//                urlBuilder.setQueryParameter("clientId", DeviceIdentityUtils.getDeviceIdentity(context))

                req = req.newBuilder().url(urlBuilder.build()).build()

                chain.proceed(req)
            }
            .build()
    }
}