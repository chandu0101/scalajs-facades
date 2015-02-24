package chandu0101.scalajs.facades.examples.pages.components.pouchdb

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.pouchdb.{PouchDBException, GetOptions, PouchDBOptions, PouchDB}
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Promise, Future}

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.JSON
import scala.util.{Failure, Success}

/**
 * Created by chandrasekharkode .
 */
object PGetDoc {

  val code =
    """
      |    val db =  PouchDB.create("scalajs")
      |     db.get("bpt-rice").onComplete {
      |       case Success(resp : js.Dynamic) => println(s"doc with id bpt-rice is : ${JSON.stringify(resp)}")
      |       case Failure(ex) => println(s"Error while fetching doc with id bpt-rice : ${ex.asInstanceOf[PouchDBException].err}")
      |     }
    """.stripMargin

  val component = ReactComponentB[Unit]("PGetDoc")

    .render(P => {
    div(
      h3("Get Documents"),
      CodeExample(code)(
        p(key := "yeah", "Below code is executed , to verify this go to " +
          "developer tools -> Resources -> IndexedDB/Web SQL check _pouch_scaljs")
      )
    )

  })
    .componentWillMount(scope => {

     val db =  PouchDB.create("scalajs")
     db.get("bpt-rice").onComplete {
       case Success(resp : js.Dynamic) => println(s"doc with id bpt-rice is : ${JSON.stringify(resp)}")
       case Failure(ex) => println(s"Error while fetching doc with id bpt-rice : ${ex.asInstanceOf[PouchDBException].err}")
     }

  })
    .buildU

  

  def apply() = component()
}
