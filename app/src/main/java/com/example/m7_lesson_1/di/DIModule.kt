package com.example.m7_lesson_1.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.m7_lesson_1.data.database.ContactDatabase
import com.example.m7_lesson_1.data.database.dao.ContactDao
import com.example.m7_lesson_1.data.repositories.ContactRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DIModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, RoomDatabase::class.java, "contact")

    @Provides
    fun provideContactDao(contactDatabase: ContactDatabase) =
        contactDatabase.getContactDao()

    @Provides
    fun provideContactRepository(contactDao: ContactDao) =
        ContactRepositoryImpl(contactDao)
}