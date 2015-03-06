package chandu0101.scalajs.facades.examples.pages.components.leaflet

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.leaflet._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js.Dynamic.{global => g, literal => json}

/**
 * Created by chandrasekharkode on 3/3/15.
 */
object LMarkerOptionsDemo {
  val code =
    """
      |   div( id := "map", width := "600px", height := "285px")
      |
      |  // define map
      |    val map = LMap("map").setView(MY_LOCATION, 10.0)
      |    map.addLayer(getTileLayer)
      |    LIconDefault.imagePath = "images/"
      |    LMarker(MY_LOCATION,
      |      LMarkerOptions(draggable = true, // make marker icon draggable
      |        title = "Hover Text" ,   // text to display when hovered
      |        opacity = 0.8)) // opacity of marker icon
      |      .addTo(map) 
      |      
    """.stripMargin

  val component = ReactComponentB[Unit]("LMarkerOptionsDemo")

    .render(P => {
    div(
      h3("Marker Options"),
      CodeExample(code)(
        div(key := "map", id := "map", width := "600px", height := "285px")
      )
    )

  })
    .componentDidMount(scope => {
    // define map 
    val map = LMap("map").setView(MY_LOCATION, 10.0)
    map.addLayer(getTileLayer)
    LIconDefault.imagePath = "images/"
    LMarker(MY_LOCATION,
      LMarkerOptions.draggable(true) // make marker icon draggable
        .title("Hover Text")   // text to display when hovered
        .opacity(0.8).result) // opacity of marker icon
      .addTo(map) 
  })
    .buildU


  def apply() = component()
}

