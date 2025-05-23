package org.sopt.alami.core.network

import javax.inject.Inject
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.sopt.alami.BuildConfig

class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val authRequest = originalRequest.newBuilder().newAuthBuilder().build()

        val response = chain.proceed(authRequest)

        return response
    }

    private fun Request.Builder.newAuthBuilder() =
        this.addHeader(USER_ID, "${BuildConfig.USER_ID}")

    companion object {
        private const val USER_ID = "userId"
    }
}
