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
object PDebug {

  val code =
    """
      | PouchDB.enableDebug() // enable
      |    val db = PouchDB.create("scalajs")
      |    db.info
      |    PouchDB.disableDebug // disable
      |    
    """.stripMargin
  
  val component = ReactComponentB[Unit]("PDebug")
    .render(P => {
    div(
      h3("Debug Modes"),
      CodeExample(code)(
        p(key := "yeah", DB_PATH)
      )
    )
  })
    .componentWillMount(scope => {
    
    PouchDB.enableDebug() // enable
    val db = PouchDB.create("scalajs")
    db.info
    PouchDB.disableDebug // disable
  })
    .buildU



  def apply() = component()
}
