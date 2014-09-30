package com.panuleppaniemi.models

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Document (title: String, author: String)

object Document {
  implicit val documentReader: Reads[Document] = (
    (__ \ "title").read[String] and
    (__ \ "author").read[String]
  )(Document.apply _)
}
