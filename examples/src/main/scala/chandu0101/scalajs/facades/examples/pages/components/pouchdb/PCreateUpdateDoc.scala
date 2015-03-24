package chandu0101.scalajs.facades.examples.pages.components.pouchdb

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.pouchdb.PouchDB
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.JSON

/**
 * Created by chandrasekharkode .
 */
object PCreateUpdateDoc {

  val code =
    """
      |
      | case class Seed(name : String,category :String,duration : Int) {
      |      def toJson = json("name" -> name,"category" -> category, "duration" -> duration)
      |      def _id = s"$name-$category"
      |    }
      |
      |    //create DB
      |    val db =   PouchDB.create("scalajs")
      |    var rev = ""
      |    val seed1 = Seed("sonamsuri","rice",120)
      |    //inserting seed1
      |    db.put(doc = seed1.toJson,docId = seed1._id).onSuccess {
      |      case (response : js.Dynamic) => println(s"seed1 put response ${JSON.stringify(response)}")
      |        rev = response.rev.toString
      |    }
      |    val seed2 = Seed("bpt","rice",117)
      |    //inserting seed2
      |    db.put(doc = seed2.toJson , docId = seed2._id)
      |
      |    // updating seed1 you must specify its revision _rev, otherwise a conflict will occur.
      |    db.put(doc = seed1.copy(duration = 125).toJson,docId = seed1._id, docRev = rev)
      |
      |    val seed3 = Seed("bt","cotton",180)
      |    //insert new doc without an id using post , its not recommended way for prod
      |    db.post(doc = seed3.toJson)
      |    
    """.stripMargin

  val component = ReactComponentB[Unit]("PCreateUpdateDoc")
    .render(P => {
    div(
      h3("Create Document"),
      CodeExample(code)(
        p(key := "yeah", "Below code is executed , to verify this go to " +
          "developer tools -> Resources -> IndexedDB/Web SQL check  _pouch_scalajs store for real data."),
       p(key := "yeah2" , "The basic rule of thumb is: put() new documents with an _id, post() new documents without an _id. ")
      )
    )

  })
    .componentWillMount(scope => {

    case class Seed(name : String,category :String,duration : Int) {
      def toJson = json("name" -> name,"category" -> category, "duration" -> duration)
      def _id = s"$name-$category"
    }
    
    //create DB
    val db =   PouchDB.create("scalajs")
    var rev = ""
    val seed1 = Seed("sonamsuri","rice",120)
    //inserting seed1
    db.put(doc = seed1.toJson,docId = seed1._id).onSuccess {
      case (response : js.Dynamic) => println(s"seed1 put response ${JSON.stringify(response)}")
        rev = response.rev.toString
    }
    val seed2 = Seed("bpt","rice",117)
    //inserting seed2
    db.put(doc = seed2.toJson , docId = seed2._id)
    
    // updating seed1 you must specify its revision _rev, otherwise a conflict will occur.
    db.put(doc = seed1.copy(duration = 125).toJson,docId = seed1._id, docRev = rev)
    
    val seed3 = Seed("bt","cotton",180)
    //insert new doc without an id using post , its not recommended way for prod
    db.post(doc = seed3.toJson)
    
  })
    .buildU

  def apply() = component()
}
