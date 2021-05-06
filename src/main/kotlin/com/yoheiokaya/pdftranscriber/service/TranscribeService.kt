package com.yoheiokaya.pdftranscriber.service

import com.yoheiokaya.pdftranscriber.dto.Sentence
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPageContentStream
import org.apache.pdfbox.pdmodel.font.PDType0Font
import org.springframework.stereotype.Service
import java.io.File


@Service
class TranscribeService {

    fun transcribe(pdfFile: File, sentences: Array<Sentence>): File? {
        try {
            val document = PDDocument.load(pdfFile)
            val classLoader = javaClass.classLoader
            val font = PDType0Font.load(document, File(classLoader.getResource("ipaexg.ttf").file))
            val sentenceMap = sentences.groupBy({ it.page } ,{ it })
            sentenceMap.forEach { (page, values) ->
                val page = document.getPage(page)
                PDPageContentStream(document, page, PDPageContentStream.AppendMode.PREPEND, true).use { contentStream ->
                    values.forEach { sentence ->
                        contentStream.beginText()
                        contentStream.setFont(font, sentence.fontSize)
                        contentStream.newLineAtOffset(sentence.offsetX, sentence.offsetY)
                        contentStream.showText(sentence.content)
                        contentStream.endText()
                    }
                }
            }
            document.save("test.pdf")
            document.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return File("test.pdf")
    }

}