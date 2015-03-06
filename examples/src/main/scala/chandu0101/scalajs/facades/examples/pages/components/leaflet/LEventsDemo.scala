package chandu0101.scalajs.facades.examples.pages.components.leaflet

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.leaflet._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._

/**
 * Created by chandrasekharkode on 3/6/15.
 */
object LEventsDemo {
  val code =
    """
      |   div( id := "map", width := "600px", height := "285px")
      |
      | // define map
      |    val map = LMap("map").setView(MY_LOCATION, 10.0)
      |    map.addLayer(getTileLayer)
      |    LIconDefault.imagePath = "images/" // set images path
      |    LMarker(MY_LOCATION).addTo(map) // marker to location
      |    val popup = LPopup()
      |    map.onClick((e : LMouseEvent) => {
      |      popup.setLatLng(e.latlng)
      |           .setContent("You clicked the map at :" + e.latlng)
      |           .openOn(map)
      |    })
    """.stripMargin

  val component = ReactComponentB[Unit]("LEventsDemo")

    .render(P => {
    div(
      h3("Events Demo"),
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
    val popup = LPopup()
    map.onClick((e : LMouseEvent) => {
      popup.setLatLng(e.latlng)
           .setContent("You clicked the map at :" + e.latlng)
           .openOn(map)
    })
  })
    .buildU


  def apply() = component()
}
