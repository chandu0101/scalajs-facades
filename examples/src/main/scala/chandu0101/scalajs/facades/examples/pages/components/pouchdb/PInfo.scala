package chandu0101.scalajs.facades.examples.pages.components.pouchdb

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.examples.util.Constants._
import chandu0101.scalajs.facades.pouchdb.{AllDocsOptions, PouchDB}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js
import scala.scalajs.js.JSON

/**
 * Created by chandrasekharkode .
 */
object PInfo {

  val code =
    """
      | // create or get db
      |     val db = PouchDB.create("scalajs")
      |     db.info.onSuccess {
      |       case (resp : js.Dynamic) => println(s"DB Info ${JSON.stringify(resp)}")
      |     }
    """.stripMargin
  
  val component = ReactComponentB[Unit]("PInfo")
    .render(P => {
    div(
      h3("All Documents"),
      CodeExample(code)(
        p(key := "yeah", DB_PATH)
      )
    )
  })
    .componentWillMount(scope => {
    // create or get db
     val db = PouchDB.create("scalajs") 
     db.info.onSuccess {
       case (resp : js.Dynamic) => println(s"DB Info ${JSON.stringify(resp)}")
     }
  })
    .buildU



  def apply() = component()
}
