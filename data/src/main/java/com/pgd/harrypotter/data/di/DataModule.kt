package com.pgd.harrypotter.data.di

import com.pgd.harrypotter.data.datasource.recipe.RecipeDataSource
import com.pgd.harrypotter.data.datasource.recipe.RecipeDataSourceImpl
import com.pgd.harrypotter.data.repository.recipe.RecipeRepositoryImpl
import com.pgd.harrypotter.domain.repository.RecipeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsRecipeDataSource(recipeDataSourceImpl: RecipeDataSourceImpl)
            : RecipeDataSource

    @Binds
    abstract fun bindsRecipeRepository(recipeRepository: RecipeRepositoryImpl)
            : RecipeRepository

}
