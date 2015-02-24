package chandu0101.scalajs.facades.examples.pages.components.pouchdb


import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.pouchdb.{PouchDB, PouchDBOptions}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._


/**
 * Created by chandrasekharkode .
 */
object PCreateDB {

  val component = ReactComponentB[Unit]("PCreateDB")

    .render(P => {
    div(
      h3("Create Database"),
      CodeExample(code)(
        p(key := "yeah", "Below code is executed , to verify this go to " +
          "developer tools -> Resources -> IndexedDB/Web SQL check for db names _pouch_db1 , _pouch_db2")
      )
    )

  })
    .componentWillMount(scope => {
    // using db name
     PouchDB.create("db1") // local
    // using options
     PouchDB.create(options = PouchDBOptions(name = "db2"))
  })
    .buildU

  val code =
    """
      |    // using db name
      |     PouchDB.create("db1") // local
      |    // using options
      |     PouchDB.create(options = PouchDBOptions(name = "db2"))
      |
    """.stripMargin

  def apply() = component()
}
