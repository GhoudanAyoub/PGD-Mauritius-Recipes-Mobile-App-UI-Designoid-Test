package com.pgd.harrypotter.domain.di

import com.pgd.harrypotter.domain.usecase.recipe.GetRecipe
import com.pgd.harrypotter.domain.usecase.recipe.GetRecipeUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindsGetRecipeUseCase(getRecipe: GetRecipe): GetRecipeUseCase

}
