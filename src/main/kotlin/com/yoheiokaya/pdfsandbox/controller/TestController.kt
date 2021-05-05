package com.yoheiokaya.pdfsandbox.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class Greeting(val hello: String)

@RestController
@RequestMapping("/v1")
class TestController {
    @GetMapping("/greeting")
    fun hello() = Greeting("world")
}