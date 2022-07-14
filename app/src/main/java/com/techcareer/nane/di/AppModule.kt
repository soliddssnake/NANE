package com.techcareer.nane.di

import com.techcareer.nane.data.repo.FoodDaoRepository
import com.techcareer.nane.retrofit.ApiUtils
import com.techcareer.nane.retrofit.FoodDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideFoodDaoRepository(foodDao: FoodDao) : FoodDaoRepository {
        return FoodDaoRepository(foodDao)
    }

    @Provides
    @Singleton
    fun provideFoodDao() : FoodDao {
        return ApiUtils.getFoodDao()
    }
}