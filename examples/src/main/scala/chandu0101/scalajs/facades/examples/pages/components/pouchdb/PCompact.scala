package chandu0101.scalajs.facades.examples.pages.components.pouchdb

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.examples.util.Constants._
import chandu0101.scalajs.facades.pouchdb.PouchDB
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js
import scala.scalajs.js.JSON

/**
 * Created by chandrasekharkode .
 */
object PCompact {

  val code =
    """
      |  // create or get db
      |     val db = PouchDB.create("scalajs")
      |     db.compact().onSuccess {
      |       case (resp : js.Dynamic) => println(s"Compact Success :  ${JSON.stringify(resp)}")
      |     }
    """.stripMargin
  
  val component = ReactComponentB[Unit]("PCompact")

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
     db.compact().onSuccess {
       case (resp : js.Dynamic) => println(s"Compact Success :  ${JSON.stringify(resp)}")
     }
  })
    .buildU



  def apply() = component()
}
