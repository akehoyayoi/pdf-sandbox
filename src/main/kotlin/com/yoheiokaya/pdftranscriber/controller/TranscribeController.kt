package com.yoheiokaya.pdftranscriber.controller

import com.yoheiokaya.pdftranscriber.dto.TranscribeRequest
import com.yoheiokaya.pdftranscriber.service.DownloadService
import com.yoheiokaya.pdftranscriber.service.PurgeService
import com.yoheiokaya.pdftranscriber.service.TranscribeService
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.Resource
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1")
class TranscribeController(
        val downloadService: DownloadService,
        val transcribeService: TranscribeService,
        val purgeService: PurgeService) {

    @PostMapping("/transcribe", produces = [MediaType.APPLICATION_PDF_VALUE])
    fun transcribe(@RequestBody transcribeRequest: TranscribeRequest): Resource {
        val pdfFile = downloadService.download(transcribeRequest.url)
        val transcribedFile = transcribeService.transcribe(pdfFile, transcribeRequest.sentences)
        purgeService.purge(arrayOf(pdfFile))
        return FileSystemResource(transcribedFile!!)
    }
}