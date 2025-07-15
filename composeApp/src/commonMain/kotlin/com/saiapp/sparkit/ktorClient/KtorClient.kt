package com.saiapp.sparkit.ktorClient

import com.saiapp.sparkit.ktorClient.Login.LoginRequest
import com.saiapp.sparkit.ktorClient.Login.LoginResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


class KtorClient {
    fun getClient() : HttpClient{
        return HttpClient {
            install(ContentNegotiation){
                json(json = Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                })
            }

            install(HttpTimeout){
                socketTimeoutMillis = 3000
                connectTimeoutMillis = 3000
                requestTimeoutMillis = 3000
            }



            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL

            }

            install(DefaultRequest){
                    url{
                        host = "spark-backend-bcgf.onrender.com"
                        protocol = URLProtocol.HTTPS
                        headers {
                            append(HttpHeaders.Authorization,"asdf")
                        }
                        contentType(ContentType.Application.Json)
                    }
            }
        }
    }

    suspend fun login(token: String): LoginResponse {
        return getClient().post {
            url {
                path("/api/users/login")
            }
            contentType(ContentType.Application.Json)
            setBody(LoginRequest(token))
        }.body<LoginResponse>()
    }
}