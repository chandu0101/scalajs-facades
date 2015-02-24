package chandu0101.scalajs.facades.examples.pages.components.pouchdb

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.pouchdb.{PouchDBOptions, PouchDB}
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js

/**
 * Created by chandrasekharkode .
 */
object PDeleteDB {
    

  val code =
    """
      | //create DB
      | val db1 =    PouchDB.create("db1")
      | //delete it
      | db1.destroy()
      | val db2 =    PouchDB.create("db2")
      |  db2.destroy()
      |
    """.stripMargin

  val component = ReactComponentB[Unit]("PDeleteDB")

    .render(P => {
    div(
      h3("Delete Database"),
      CodeExample(code)(
        p(key := "yeah", "Below code is executed , to verify this go to " +
          "developer tools -> Resources -> IndexedDB/Web SQL check that db names _pouch_db1 , _pouch_db2 doesn't exist")
      )
    )

  })
    .componentWillMount(scope => {
      //create DB
      val db1 =    PouchDB.create("db1")
      //delete it
      db1.destroy()
      val db2 =    PouchDB.create("db2")
       db2.destroy()
  })
    .buildU

    def apply() = component()
  }

