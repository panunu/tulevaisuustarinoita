package com.panuleppaniemi.services

import com.google.inject.Singleton
import com.panuleppaniemi.models.{DocumentWithContent, Document}
import play.api.libs.json.Json
import org.clapper.markwrap._

@Singleton
class DocumentService {
  def all: List[DocumentWithContent] = {
    val json = Json.parse(
      scala.io.Source.fromFile("data/documents.json").mkString
    )

    val documents = json.validate[List[Document]].getOrElse(List())

    documents.map(document => {
      DocumentWithContent(
        document,
        scala.io.Source.fromFile("data/" + document.filename).mkString // parseMarkdown(document.filename)
      )
    })
  }

  def parseMarkdown(filename: String): String = {
    MarkWrap.parserFor(MarkupType.Markdown).parseToHTML(
      scala.io.Source.fromFile("data/" + filename).mkString
    )
  }
}