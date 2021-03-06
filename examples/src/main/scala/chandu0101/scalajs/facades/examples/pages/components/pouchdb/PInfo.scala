package chandu0101.scalajs.facades.examples.pages.components.pouchdb

import chandu0101.scalajs.facades.examples.pages.common.InfoTemplate
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

/**
 * Created by chandrasekharkode .
 */
object PInfo {


  val component = ReactComponentB[Unit]("PInfo")
    .render(P => {
    InfoTemplate("pouchdb")(
      p(key := "info", "PouchDB is an open-source JavaScript database inspired by Apache CouchDB that is designed to run well within the browser.")
    )
  })
    .buildU


  def apply() = component()
}
