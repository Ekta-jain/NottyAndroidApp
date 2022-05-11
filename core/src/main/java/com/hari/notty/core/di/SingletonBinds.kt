package com.hari.notty.core.di

import com.hari.notty.core.database.NoteDatabaseImpl
import com.hari.notty.core.database.model.NoteDatabase
import com.hari.notty.core.network.AuthRemoteDataSourceImpl
import com.hari.notty.core.network.model.AuthRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface SingletonBinds {
    @Binds
    fun bindNoteDatabase(database: NoteDatabaseImpl): NoteDatabase

    @Binds
    fun bindAuthRemoteDataSource(authRemoteDataSource: AuthRemoteDataSourceImpl): AuthRemoteDataSource
}