package chandu0101.scalajs.facades.examples.pages


import chandu0101.scalajs.facades.examples.pages.common.{ExampleLeftNav, LeftnavPage}
import chandu0101.scalajs.facades.examples.routes.AppRouter.AppPage
import chandu0101.scalajs.facades.examples.routes.AppRouter.AppPage._
import japgolly.scalajs.react._


/**
 * Created by chandrasekharkode .
 */
object PouchDBPage {

  lazy val menu = List(
    ExampleLeftNav.Menu(text = "Info", route = pInfo.path.value),
    ExampleLeftNav.Menu(text = "Create Database", route = pcreateDB.path.value),
    ExampleLeftNav.Menu(text = "Delete Database", route = pdeleteDB.path.value),
    ExampleLeftNav.Menu(text = "Create/Update Doc", route = pcreateupdateDoc.path.value),
    ExampleLeftNav.Menu(text = "Get Document", route = pgetDoc.path.value),
    ExampleLeftNav.Menu(text = "Delete Document", route = pdeleteDoc.path.value),
    ExampleLeftNav.Menu(text = "CUD Bulkdocs", route = pCreateUpdateBulkDocs.path.value),
    ExampleLeftNav.Menu(text = "All Documents", route = pAllDocs.path.value),
    ExampleLeftNav.Menu(text = "Changes", route = pChanges.path.value),
    ExampleLeftNav.Menu(text = "Replicate DB", route = pReplicate.path.value),
    ExampleLeftNav.Menu(text = "Sync DB's", route = pSync.path.value),
    ExampleLeftNav.Menu(text = "DB Info", route = pInfo.path.value),
    ExampleLeftNav.Menu(text = "DB Compact", route = pCompact.path.value),
    ExampleLeftNav.Menu(text = "Debug Mode", route = pDebug.path.value)

  )

  val data: List[ReactNode] = List("Create Database", "Delete Database", "Create/update doc")

  val component = ReactComponentB[ReactNode]("PouchDBPage")
    .render((P) => {
    LeftnavPage(menu, P)
  })
    .build


  def apply(content: ReactNode) = component(content)
}
