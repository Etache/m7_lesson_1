package com.example.m7_lesson_1.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.m7_lesson_1.utils.Resource

abstract class BaseRepository {

    protected fun <T> makeRequest(coroutineRequest: suspend () -> T): Flow<Resource<T>> {
        return flow {
            emit(Resource.Loading())
            try {
                emit(Resource.Success(coroutineRequest()))
            } catch(e: Exception) {
                emit(Resource.Error(e.localizedMessage))
            }
        }
    }
}