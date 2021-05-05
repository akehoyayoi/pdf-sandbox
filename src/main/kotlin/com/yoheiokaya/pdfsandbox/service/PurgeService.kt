package com.yoheiokaya.pdfsandbox.service

import org.springframework.stereotype.Service
import java.io.File
import java.nio.file.Files

@Service
class PurgeService {
    fun purge(files: Array<File>) {
        try {
            files.forEach { file ->
                Files.deleteIfExists(file.toPath())
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }
}