package chandu0101.scalajs.facades.examples.pages.components.pouchdb

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.examples.util.Constants._
import chandu0101.scalajs.facades.pouchdb.{PouchDB, ReplicateOptions}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.JSON

/**
 * Created by chandrasekharkode .
 */
object PSync {

  val code =
    """
      |  val sync = PouchDB.sync("scalajs","scalajs2",ReplicateOptions(live = true))
      |               .onChange((resp : js.Dynamic) => println(s" Replicate DB Chnages ${JSON.stringify(resp)}"))
      |  val db = PouchDB.create("scalajs")
      |  val db2 =x PouchDB.create("scalajs2")
      |  db.post(json("sync1" -> "fromdb1"))
      |  db2.post(json("sync2" -> "fromdb2"))
      |  dom.setTimeout(() => sync.cancel(),2000)
    """.stripMargin
  
  val component = ReactComponentB[Unit]("PReplicate")
    .render(P => {
    div(
      h3("Replicate a Database"),
      CodeExample(code)(
        p(key := "yeah", DB_PATH)
      )
    )

  })
    .componentWillMount(scope => {
    val sync = PouchDB.sync("scalajs","scalajs2",ReplicateOptions(live = true))
               .onChange((resp : js.Dynamic) => println(s" Replicate DB Chnages ${JSON.stringify(resp)}"))
     val db = PouchDB.create("scalajs")
     val db2 = PouchDB.create("scalajs2")
     db.post(json("sync1" -> "fromdb1"))
     db2.post(json("sync2" -> "fromdb2"))
     dom.setTimeout(() => sync.cancel(),2000)
  })
    .buildU



  def apply() = component()
}
