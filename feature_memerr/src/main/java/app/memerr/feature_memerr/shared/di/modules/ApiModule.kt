package app.memerr.feature_memerr.shared.di.modules

import app.memerr.feature_memerr.shared.api.MemerrService
import app.memerr.feature_memerr.shared.di.component.MemerrSharedScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {
    @MemerrSharedScope
    @Provides
    fun providesMemerrService(retrofit: Retrofit): MemerrService = retrofit.create(MemerrService::class.java)
}