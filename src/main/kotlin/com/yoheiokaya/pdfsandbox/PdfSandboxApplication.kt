package com.yoheiokaya.pdfsandbox

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PdfSandboxApplication

fun main(args: Array<String>) {
	runApplication<PdfSandboxApplication>(*args)
}
