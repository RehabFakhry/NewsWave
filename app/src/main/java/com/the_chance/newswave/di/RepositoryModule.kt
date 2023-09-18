package com.the_chance.newswave.di

import com.the_chance.data.repository.NewsRepositoryImpl
import com.the_chance.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindNewsRepository(repository: NewsRepositoryImpl): NewsRepository

//    @Singleton
//    @Binds
//    abstract fun bindAuthRepository(repository: AuthRepositoryImpl): AuthRepository

}