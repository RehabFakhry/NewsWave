package com.the_chance.newswave.di

import android.app.Application
import androidx.savedstate.SavedStateRegistryOwner
import com.google.firebase.auth.FirebaseAuth
import com.the_chance.data.source.remote.network.NewsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val API_KEY = "ae9d7ae31523e9bc1400e9f2f8229fc4"
    private const val BASE_URL = "http://api.mediastack.com/v1/"


    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor { chain ->
            // Add the API key as a query parameter to the request
            val originalRequest = chain.request()
            val originalHttpUrl = originalRequest.url

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("access_key", API_KEY)
                .build()

            val request = originalRequest.newBuilder()
                .url(url)
                .build()

            chain.proceed(request)
        }
        .build()


    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }


    @Singleton
    @Provides
    fun provideRetrofitBuilder(
        client: OkHttpClient,
        factory: GsonConverterFactory,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(factory)
        .build()

    @Singleton
    @Provides
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()


    @Singleton
    @Provides
    fun provideNewsService(
        retrofit: Retrofit
    ): NewsService = retrofit.create(NewsService::class.java)


    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

}


//    @Singleton
//    @Provides
//    fun provideOkHttpClient(
//        loggingInterceptor: HttpLoggingInterceptor,
//    ): OkHttpClient = OkHttpClient
//        .Builder()
//        .addInterceptor(loggingInterceptor)
//        .addInterceptor { chain ->
//            // Add the API key as a header to the request
//            val request = chain.request().newBuilder()
//                .addHeader("Authorization", "Bearer $API_KEY")
//                .build()
//            chain.proceed(request)
//        }
//        .build()