package com.engineers100X.pocketbills.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.engineers100X.pocketbills.data.local.AppDatabase
import com.engineers100X.pocketbills.data.local.datastore.UIModeDataStore
import com.engineers100X.pocketbills.data.local.datastore.UIModeImpl
import com.engineers100X.pocketbills.services.exportcsv.ExportCsvService
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun providePreferenceManager(@ApplicationContext context: Context): UIModeImpl {
        return UIModeDataStore(context)
    }

    @Singleton
    @Provides
    fun provideNoteDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "transaction.db")
            .fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideExportCSV(@ApplicationContext context: Context): ExportCsvService {
        return ExportCsvService(appContext = context)
    }
}
