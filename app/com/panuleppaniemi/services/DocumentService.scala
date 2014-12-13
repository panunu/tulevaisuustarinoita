package com.panuleppaniemi.services

import com.google.inject.Singleton
import com.panuleppaniemi.models.{DocumentWithContent, Document, Author}
import play.api.libs.json.{JsValue, Json}
import org.pegdown.PegDownProcessor

@Singleton
class DocumentService {
  def all: List[DocumentWithContent] = withParsedContent(toDocuments(parseJson))

  private def parseJson = Json.parse(scala.io.Source.fromFile("data/documents.json").mkString)

  private def toDocuments(json: JsValue) = {
    implicit val authorFormat = Json.reads[Author]
    implicit val documentFormat = Json.reads[Document]

    json.validate[List[Document]].getOrElse(List())
  }

  private def withParsedContent(documents: List[Document]) = documents.map(
    document => DocumentWithContent(document, parseMarkdown(document.filename))
  )

  private def parseMarkdown(filename: String): String = {
    (new PegDownProcessor).markdownToHtml(
      scala.io.Source.fromFile("data/" + filename).mkString
    )
  }
}