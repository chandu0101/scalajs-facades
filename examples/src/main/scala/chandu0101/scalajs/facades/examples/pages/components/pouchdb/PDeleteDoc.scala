package chandu0101.scalajs.facades.examples.pages.components.pouchdb

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.pouchdb.PouchDB
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.{UndefOr, JSON}
import scala.concurrent.ExecutionContext.Implicits.global
/**
 * Created by chandrasekharkode .
 */
object PDeleteDoc {

  val code =
    """
      |
      |   case class Seed(name : String,category :String,duration : Int) {
      |      def toJson = json("name" -> name,"category" -> category, "duration" -> duration)
      |      def _id = s"$name-$category"
      |    }
      |    //create/get DB
      |    val db =    PouchDB.create("scalajs")
      |    val seed = Seed("t234","tomato",184)
      |    //inserting seed
      |    db.put(doc = seed.toJson ,docId = seed._id).onSuccess {
      |      case (iDoc : js.Dynamic) => db.removeWithId(iDoc.id.toString,iDoc.rev.toString) // delete doc
      |    }
      |
    """.stripMargin

  val component = ReactComponentB[Unit]("PDeleteDoc")
    .render(P => {
    div(
      h3("Create Document"),
      CodeExample(code)(
        p(key := "yeah", "Below code is executed , to verify this go to " +
          "developer tools -> Resources -> IndexedDB/Web SQL check  _pouch_scalajs store to make sure doc we inserted deleted.")
      )
    )

  })
    .componentWillMount(scope => {
    case class Seed(name : String,category :String,duration : Int) {
      def toJson = json("name" -> name,"category" -> category, "duration" -> duration)
      def _id = s"$name-$category"
    }
    //create/get DB
    val db =    PouchDB.create("scalajs")
    val seed = Seed("t234","tomato",184)
    //inserting seed
    db.put(doc = seed.toJson ,docId = seed._id).onSuccess {
      case (iDoc : js.Dynamic) => db.removeWithId(iDoc.id.toString,iDoc.rev.toString) // delete doc
    }
  })
    .buildU

  def apply() = component()
}
