package com.yoheiokaya.pdfsandbox.controller

import com.yoheiokaya.pdfsandbox.service.DownloadService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class Greeting(val hello: String)

@RestController
@RequestMapping("/v1")
class TestController(val downloadService: DownloadService) {
    @GetMapping("/greeting")
    fun hello(): Greeting {
        val path = downloadService.download("https://www.chofu-across.jp/CMS/wp-content/uploads/2019/06/shinseisho_shisetsu_chusen_r12.pdf")
        return Greeting(path!!)
    }
}