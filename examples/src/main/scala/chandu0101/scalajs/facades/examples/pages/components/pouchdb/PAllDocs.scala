package chandu0101.scalajs.facades.examples.pages.components.pouchdb

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.examples.util.Constants
import chandu0101.scalajs.facades.examples.util.Constants._
import chandu0101.scalajs.facades.pouchdb.{AllDocsOptions, PouchDB, PouchDBOptions}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js
import scala.scalajs.js.JSON
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by chandrasekharkode .
 */
object PAllDocs {

  val code =
    """
      |   // create or get db
      |     val db = PouchDB.create("scalajs") 
      |     // getting all docs (by default we'll only get id and rev of each doc
      |     db.allDocs().onSuccess {
      |      case (resp : js.Dynamic) => println(s"All Docs from without any options ${JSON.stringify(resp)}")
      |     }
      |     // to get doc fields included in results we must pass AllDocsOptions
      |    db.allDocs(AllDocsOptions(include_docs = true)).onSuccess {
      |      case (resp : js.Dynamic) => println(s"All Docs with doc content included ${JSON.stringify(resp)}")
      |    }
      |    
    """.stripMargin
  
  val component = ReactComponentB[Unit]("PAllDocs")

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
     // getting all docs (by default we'll only get id and rev of each doc
     db.allDocs().onSuccess {
      case (resp : js.Dynamic) => println(s"All Docs from without any options ${JSON.stringify(resp)}")
     }
     // to get doc fields included in results we must pass AllDocsOptions
    db.allDocs(AllDocsOptions(include_docs = true)).onSuccess {
      case (resp : js.Dynamic) => println(s"All Docs with doc content included ${JSON.stringify(resp)}")
    }
  })
    .buildU



  def apply() = component()
}
