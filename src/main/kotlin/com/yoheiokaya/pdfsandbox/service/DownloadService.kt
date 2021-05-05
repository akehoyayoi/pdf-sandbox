package com.yoheiokaya.pdfsandbox.service

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.nio.file.Files
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.absolutePathString

@Component
class DownloadService(val restTemplate: RestTemplate) {

    // TODO: @OptIn should be removed after 1.0 release for absolutePathString
    @OptIn(ExperimentalPathApi::class)
    fun download(url: String): String? {

        val httpHeader = HttpHeaders()
        httpHeader.add(HttpHeaders.ACCEPT, "application/pdf")

        val response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                HttpEntity<String>(httpHeader),
                ByteArray::class.java
        )

        val path = Files.createTempFile("temp",".pdf")
        Files.write(path, response.body)
        return path.absolutePathString()
    }
}