package com.yoheiokaya.pdfsandbox.service

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.io.File
import java.nio.file.Files

@Service
class DownloadService(val restTemplate: RestTemplate) {

    fun download(url: String): File {

        val httpHeader = HttpHeaders()
        httpHeader.add(HttpHeaders.ACCEPT, "application/pdf")

        val response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                HttpEntity<String>(httpHeader),
                ByteArray::class.java
        )

        val pdfFile = Files.createTempFile("temp",".pdf")
        Files.write(pdfFile, response.body)
        return pdfFile.toFile()
    }
}