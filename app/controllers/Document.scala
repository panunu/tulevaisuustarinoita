package controllers

import play.api._
import play.api.mvc._

import play.api.libs.json._
import play.api.libs.functional.syntax._

import com.panuleppaniemi.models._

object Document extends Controller {
  def all = Action {
    val documents = Json.parse(scala.io.Source.fromFile("data/documents.json").mkString).validate[List[Document]].get

    Ok(views.html.document.index(documents))
  }
}

