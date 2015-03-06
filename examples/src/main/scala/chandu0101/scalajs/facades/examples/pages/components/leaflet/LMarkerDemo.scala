package chandu0101.scalajs.facades.examples.pages.components.leaflet

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.leaflet._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js.Dynamic.{global => g, literal => json}

/**
 * Created by chandrasekharkode on 3/3/15.
 */
object LMarkerDemo {
  val code =
    """
      |   div( id := "map", width := "600px", height := "285px")
      |
      |  // define map
      |    val map = LMap("map").setView(MY_LOCATION, 8.0)
      |    map.addLayer(getTileLayer)
      |    LIconDefault.imagePath = "images/" // set images path
      |    LMarker(MY_LOCATION).addTo(map) // marker to location
      |    
    """.stripMargin

  val component = ReactComponentB[Unit]("LMarker")

    .render(P => {
    div(
      h3("Marker"),
      CodeExample(code)(
        div(key := "map", id := "map", width := "600px", height := "285px")
      )
    )

  })
    .componentDidMount(scope => {
    // define map 
    val map = LMap("map").setView(MY_LOCATION, 10.0)
    map.addLayer(getTileLayer)
    LIconDefault.imagePath = "images" // set images path
    LMarker(MY_LOCATION).addTo(map) // marker to location
  })
    .buildU


  def apply() = component()
}

