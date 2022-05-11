package com.hari.notty.core.network

import com.hari.notty.core.di.NetworkModule
import com.hari.notty.core.network.model.AuthRemoteDataSource
import com.hari.notty.core.network.request.LoginRequestDto
import com.hari.notty.core.network.request.LoginResponseDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(
    private val httpClient: HttpClient
) : AuthRemoteDataSource {
    override suspend fun login(request: LoginRequestDto): LoginResponseDto {
        val response: HttpResponse =
            httpClient.post("v1/api/user/signin") {
                setBody(request)
            }
        return try {
            response.body()
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }


}