package com.yoheiokaya.pdfsandbox.service

import com.yoheiokaya.pdfsandbox.dto.Sentence
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPage
import org.apache.pdfbox.pdmodel.PDPageContentStream
import org.apache.pdfbox.pdmodel.common.PDRectangle
import org.apache.pdfbox.pdmodel.font.PDType0Font
import org.springframework.stereotype.Service
import java.io.File


@Service
class TranscribeService {

    fun transcribe(pdfFile: File, sentences: Array<Sentence>): File? {
        try {
            val document = PDDocument.load(pdfFile)
            val page = document.getPage(0)
            val classLoader = javaClass.classLoader
            val font = PDType0Font.load(document, File(classLoader.getResource("ipaexg.ttf").file))
            PDPageContentStream(document, page, PDPageContentStream.AppendMode.PREPEND, true).use { contentStream ->
                sentences.forEach { sentence ->
                    contentStream.beginText()
                    contentStream.setFont(font, sentence.fontSize)
                    contentStream.newLineAtOffset(sentence.offsetX, sentence.offsetY)
                    contentStream.showText(sentence.content)
                    contentStream.endText()
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