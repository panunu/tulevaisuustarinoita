package com.panuleppaniemi.models

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Document (title: String, author: String, filename: String)
case class DocumentWithContent (document: Document, content: String)

object Document {
  implicit val documentReader: Reads[Document] = (
    (__ \ "title").read[String] and
    (__ \ "author").read[String] and
    (__ \ "filename").read[String]
  )(Document.apply _)
}
