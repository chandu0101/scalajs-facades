package chandu0101.scalajs.facades.examples.pages.components.leaflet

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.leaflet._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js.Dynamic.{global => g, literal => json}
import scala.scalajs.js.JSON

/**
 * Created by chandrasekharkode on 3/3/15.
 */
object LGeoJSONDemo {
  val code =
    """
      |   div( id := "map", width := "600px", height := "285px")
      |  
      |  val geoJSONPointFeature = { "type": "Feature",
      |    "properties": {
      |        "name": "Tenali",
      |        "amenity": "Andhra Paris",
      |        "popupContent": "Cool town!"
      |    },
      |    "geometry": {
      |        "type": "Point",
      |        "coordinates": [80.6400 ,16.2428]
      |    }
      |    
      |   // define map
      |    val map = LMap("map").setView(MY_LOCATION, 10.0)
      |    map.addLayer(getTileLayer)
      |    LIconDefault.imagePath = "images/" // set images path
      |    LGeoJson(JSON.parse(geoJSONPointFeature)).addTo(map)
      |    
    """.stripMargin

  val component = ReactComponentB[Unit]("LGeoJSONDemo")

    .render(P => {
    div(
      h3("GeoJSON"),
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
    LGeoJson(JSON.parse(geoJSONPointFeature)).addTo(map)
    
  })
    .buildU


  def apply() = component()
}

