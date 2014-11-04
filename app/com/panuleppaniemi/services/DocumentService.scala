package com.panuleppaniemi.services

import com.google.inject.Singleton
import com.panuleppaniemi.models.{DocumentWithContent, Document}
import play.api.libs.json.Json
import org.pegdown.PegDownProcessor

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
        parseMarkdown(document.filename)
      )
    })
  }

  def parseMarkdown(filename: String): String = {
    (new PegDownProcessor).markdownToHtml(
      scala.io.Source.fromFile("data/" + filename).mkString
    )
  }
}