package com.yoheiokaya.pdfsandbox.dto

data class Sentence(val content: String, val fontSize: Float, val offsetX: Float, val offsetY: Float)
data class TranscribeRequest(val url: String, val sentences: Array<Sentence>)