package com.the_chance.data.repository

import android.util.Log
import com.the_chance.domain.utill.ForbiddenException
import com.the_chance.domain.utill.NotFoundException
import com.the_chance.domain.utill.UnAuthorizedException
import retrofit2.Response

abstract class BaseRepository {

    protected suspend fun <T> wrap(function: suspend () -> Response<T>): T {
        try {
            val response = function()
            return if (response.isSuccessful) {
                response.body()?: throw NotFoundException()
            } else {
                Log.d("tag", "repository failed")
                when (response.code()) {
                    401 -> throw UnAuthorizedException()
                    403 -> throw ForbiddenException()
                    404 -> throw NotFoundException()

                    else -> throw Exception(response.toString())
                }
            }
        } catch (e: Exception) {
            Log.e("Tag", "response Error:${e.message}")
            throw Exception(e.message)

        }
    }
}
