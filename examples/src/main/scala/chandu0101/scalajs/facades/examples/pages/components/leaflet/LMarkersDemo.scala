package chandu0101.scalajs.facades.examples.pages.components.leaflet

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.leaflet._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js.Dynamic.{global => g, literal => json}

/**
 * Created by chandrasekharkode on 3/3/15.
 */
object LMarkersDemo {
  val code =
    """
      |   div( id := "map", width := "600px", height := "285px")
      |
      |  val RANDOM_LOCATIONS =  Map(
      |    "Tenali" ->  LLatLng(16.2428, 80.6400),
      |    "Vijayawada" -> LLatLng(16.5083, 80.6417),
      |    "Machilipatnam" -> LLatLng(16.1700, 81.1300),
      |    "Amaravati" -> LLatLng(16.5728, 80.3575),
      |    "Guntur" -> LLatLng(16.3008, 80.4428)
      |    )
      |    
      | // define map 
      |    val map = LMap("map").setView(MY_LOCATION, 8.0)
      |    map.addLayer(getTileLayer)
      |    LIconDefault.imagePath = "images/" // set images path
      |    RANDOM_LOCATIONS.map {
      |      case (place,latlng) => LMarker(latlng).bindPopup(place).addTo(map)
      |    }
      |    
    """.stripMargin

  val component = ReactComponentB[Unit]("LMarkersDemo")

    .render(P => {
    div(
      h3("Multiple Markers"),
      CodeExample(code)(
        div(key := "map", id := "map", width := "600px", height := "285px")
      )
    )

  })
    .componentDidMount(scope => {
    // define map 
    val map = LMap("map").setView(MY_LOCATION, 9.0)
    map.addLayer(getTileLayer)
    LIconDefault.imagePath = "images" // set images path
    RANDOM_LOCATIONS.map {
      case (place,latlng) => LMarker(latlng).bindPopup(place).addTo(map)
    }
    
  })
    .buildU


  def apply() = component()
}

