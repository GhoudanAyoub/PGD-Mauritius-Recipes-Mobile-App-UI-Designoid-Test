package com.pgd.harrypotter.domain.usecase.recipe

import com.pgd.harrypotter.domain.model.resource.ResultState
import com.pgd.harrypotter.domain.repository.RecipeRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

class GetRecipe @Inject constructor(
    private val recipeRepository: RecipeRepository,
) : GetRecipeUseCase {
    override suspend fun invoke(): Flow<RecipeRequestState> {
        return flow {
            when (val response = recipeRepository.getRecipe()) {
                is ResultState.Success -> {
                    emit(RecipeRequestState.Success(response.data))
                }

                is ResultState.Error -> {
                    emit(
                        RecipeRequestState.Exception(
                            code = response.code,
                            exception = response.exception
                        )
                    )
                }
            }
        }.onStart {
            emit(RecipeRequestState.Loading)
        }
    }
}
