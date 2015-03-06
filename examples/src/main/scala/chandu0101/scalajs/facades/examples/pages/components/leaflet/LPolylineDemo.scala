package chandu0101.scalajs.facades.examples.pages.components.leaflet

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.leaflet._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js.Dynamic.{global => g, literal => json}
import scala.scalajs.js.JSConverters.genTravConvertible2JSRichGenTrav

/**
 * Created by chandrasekharkode on 3/3/15.
 */
object LPolylineDemo {
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
      |   val map = LMap("map").setView(MY_LOCATION, 9.0)
      |    map.addLayer(getTileLayer)
      |    LIconDefault.imagePath = "images/" // set images path
      |    LPolyline(RANDOM_LOCATIONS.values.toJSArray,
      |    LPolylineOptions(color = "yellow"))
      |    .addTo(map)
      |
      |    
    """.stripMargin

  val component = ReactComponentB[Unit]("LPolylineDemo")

    .render(P => {
    div(
      h3("Poly Line"),
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
    LPolyline(RANDOM_LOCATIONS.values.toJSArray,
    LPolylineOptions.color("yellow").result)
    .addTo(map)
    
  })
    .buildU


  def apply() = component()
}

