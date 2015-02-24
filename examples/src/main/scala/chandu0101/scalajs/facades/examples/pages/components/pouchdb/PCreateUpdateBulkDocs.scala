package chandu0101.scalajs.facades.examples.pages.components.pouchdb

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.pouchdb.{PouchDBException, GetOptions, PouchDB}
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.JSConverters.genTravConvertible2JSRichGenTrav
import scala.scalajs.js.JSON
import scala.util.{Failure, Success}

/**
 * Created by chandrasekharkode .
 */
object PCreateUpdateBulkDocs {

  val code =
    """
      |    val db =  PouchDB.create("scalajs")
      |    // insert bulk docs
      |    val docs = js.Array(json("title" -> "Lisa Says"),
      |      json("title" -> "Space Oddity"),
      |      json("title" ->"Space Oddity2"))
      |    db.bulkDocs(docs).onSuccess {
      |      case (resp : js.Dynamic) => {
      |        println(s"inserted docs : ${JSON.stringify(resp)}")
      |        val insertedDocs = resp.asInstanceOf[js.Array[js.Dynamic]]
      |
      |        //add id ,rev and new field to our docs for update
      |        docs.zipWithIndex.foreach{
      |          case (d,i) => {
      |            d.updateDynamic("_id")(insertedDocs(i).id)
      |            d.updateDynamic("_rev")(insertedDocs(i).rev)
      |            d.updateDynamic("artist")(s"artistfor${d.title}")
      |          }
      |        }
      |        //update docs in db using bulkdocs
      |        db.bulkDocs(docs).onSuccess {
      |          case (resp : js.Dynamic) => {
      |           println(s"updated docs ${JSON.stringify(resp)}")
      |            val updatedDocs = resp.asInstanceOf[js.Array[js.Dynamic]]
      |            //add new rev and _deleted property to delete our docs
      |            docs.zipWithIndex.foreach {
      |              case (d, i) => {
      |                d.updateDynamic("_rev")(updatedDocs(i).rev)
      |                d.updateDynamic("_deleted")(true)
      |              }
      |            }
      |            // use bulkdocs to delete docs from DB
      |            db.bulkDocs(docs).onSuccess {
      |              case (resp : js.Dynamic) => {
      |                println(s"Deleted docs ${JSON.stringify(resp)}")
      |              }
      |            }
      |          }
      |        }
      |      }
      |    }
      |
    """.stripMargin

  val component = ReactComponentB[Unit]("PCreateUpdateBulkDocs")
    .render(P => {
    div(
      h3("Create/Update/Delete Bulk Docs"),
      CodeExample(code)(
        p(key := "yeah", "Below code is executed , to verify this go to " +
          "developer tools -> Resources -> IndexedDB/Web SQL check _pouch_scaljs")
      )
    )

  })
    .componentWillMount(scope => {
    val db =  PouchDB.create("scalajs")
    // insert bulk docs
    val docs = js.Array(json("title" -> "Lisa Says"),
      json("title" -> "Space Oddity"),
      json("title" ->"Space Oddity2"))
    db.bulkDocs(docs).onSuccess {
      case (resp : js.Dynamic) => {
        println(s"inserted docs : ${JSON.stringify(resp)}")
        val insertedDocs = resp.asInstanceOf[js.Array[js.Dynamic]]
        
        //add id ,rev and new field to our docs for update
        docs.zipWithIndex.foreach{
          case (d,i) => {
            d.updateDynamic("_id")(insertedDocs(i).id)
            d.updateDynamic("_rev")(insertedDocs(i).rev)
            d.updateDynamic("artist")(s"artistfor${d.title}")
          }
        }
        //update docs in db using bulkdocs
        db.bulkDocs(docs).onSuccess {
          case (resp : js.Dynamic) => {
           println(s"updated docs ${JSON.stringify(resp)}")
            val updatedDocs = resp.asInstanceOf[js.Array[js.Dynamic]]
            //add new rev and _deleted property to delete our docs
            docs.zipWithIndex.foreach {
              case (d, i) => {
                d.updateDynamic("_rev")(updatedDocs(i).rev)
                d.updateDynamic("_deleted")(true)
              }
            }
            // use bulkdocs to delete docs from DB
            db.bulkDocs(docs).onSuccess {
              case (resp : js.Dynamic) => {
                println(s"Deleted docs ${JSON.stringify(resp)}")
              }
            }
          }
        }
      }
    }
    

  })
    .buildU



  def apply() = component()
}
