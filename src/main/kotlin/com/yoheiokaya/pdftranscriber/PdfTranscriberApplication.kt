package com.yoheiokaya.pdftranscriber

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PdfTranscriberApplication

fun main(args: Array<String>) {
	System.setProperty("jsse.enableSNIExtension", "false")
	runApplication<PdfTranscriberApplication>(*args)
}
