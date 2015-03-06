package chandu0101.scalajs.facades.examples.pages.components.leaflet

import chandu0101.scalajs.facades.examples.pages.common.InfoTemplate
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._


/**
 * Created by chandrasekharkode on 3/3/15.
 */
object LInfo {


  val component = ReactComponentB[Unit]("LInfo")
    .render(P => {
       InfoTemplate("leaflet")(
        p(key := "info", "Leaflet.js is an Open Source JavaScript library that makes deploying maps on a web page easy")
       )
  }).buildU

  def apply() = component()
}
