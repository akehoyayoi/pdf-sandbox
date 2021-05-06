package com.yoheiokaya.pdftranscriber.dto

data class Sentence(val content: String, val fontSize: Float, val offsetX: Float, val offsetY: Float, val page: Int)
data class TranscribeRequest(val url: String, val sentences: Array<Sentence>)