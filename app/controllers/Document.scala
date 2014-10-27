package controllers

import play.api.mvc._
import com.panuleppaniemi.services.DocumentService
import com.google.inject.{Singleton, Inject}

@Singleton
class Document @Inject() (documentService: DocumentService) extends Controller {
  def all = Action {
    Ok(
      views.html.document.index(
        documentService.all
      )
    )
  }
}
