package com.hari.notty.core.network.model

import com.hari.notty.core.network.request.LoginRequestDto
import com.hari.notty.core.network.request.LoginResponseDto

interface AuthRemoteDataSource {
    suspend fun login(request:LoginRequestDto):LoginResponseDto
}