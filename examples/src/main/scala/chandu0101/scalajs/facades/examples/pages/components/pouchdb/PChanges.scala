package chandu0101.scalajs.facades.examples.pages.components.pouchdb

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.examples.util.Constants._
import chandu0101.scalajs.facades.pouchdb.{ChangesOptions, AllDocsOptions, PouchDB}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom

import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js
import scala.scalajs.js.JSON
import scalajs.js.Dynamic.{literal => json}
/**
 * Created by chandrasekharkode .
 */
object PChanges {

  val code =
    """
      |// create or get db
      | val db = PouchDB.create("scalajs")
      | val changes = db.changes(ChangesOptions(since = "now" , live = true))
      |   .onChange((resp : js.Any) => println(s"changes response ${JSON.stringify(resp)} "))
      | db.allDocs()
      | db.post(json("check" -> "changes"))
      | dom.setTimeout(() => changes.cancel(),2000)
    """.stripMargin
  
  val component = ReactComponentB[Unit]("PChanges")
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
     val changes = db.changes(ChangesOptions(since = "now" , live = true))
       .onChange((resp : js.Any) => println(s"changes response ${JSON.stringify(resp)} "))
     db.allDocs()
     db.post(json("check" -> "changes"))
     dom.setTimeout(() => changes.cancel(),2000)
  })
    .buildU



  def apply() = component()
}
