package com.panuleppaniemi.models

case class Document (title: String, author: Author, filename: String)
case class DocumentWithContent (document: Document, content: String)
case class Author (name: String)
