package app.memerr.feature_memerr.shared.di.modules

import android.content.Context
import androidx.room.Room
import app.memerr.feature_memerr.shared.db.MemeDatabase
import app.memerr.feature_memerr.shared.di.component.MemerrSharedScope
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {
    @MemerrSharedScope
    @Provides
    fun provideMemeDatabase(context: Context) = Room.databaseBuilder(context, MemeDatabase::class.java, "memedb.db").build()

}