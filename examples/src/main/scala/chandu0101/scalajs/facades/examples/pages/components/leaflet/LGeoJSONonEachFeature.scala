package chandu0101.scalajs.facades.examples.pages.components.leaflet

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.leaflet._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g, literal => json}
import scala.scalajs.js.JSON

/**
 * Created by chandrasekharkode on 3/3/15.
 */
object LGeoJSONonEachFeature {
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
      |    //The onEachFeature option is a function that gets called on each feature before adding it to a GeoJSON layer.
      |    // A common reason to use this option is to attach a popup to features when they are clicked.
      |    val onEachFeatureFunc : OnEachFeatureType = (feature : js.Dynamic,layer : LFeatureGroup) => {
      |        layer.bindPopup(feature.properties.popupContent.toString)
      |
      |      }
      |    LGeoJson(JSON.parse(geoJSONPointFeature),
      |     LGeoJsonOptions(onEachFeature = onEachFeatureFunc)) //use onEachFeature func to set pop content for marker
      |      .addTo(map)
      |    
    """.stripMargin

  val component = ReactComponentB[Unit]("GeoJSON onEachFeature Option option ")

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
    LIconDefault.imagePath = "images/" // set images path
    //The onEachFeature option is a function that gets called on each feature before adding it to a GeoJSON layer. 
    // A common reason to use this option is to attach a popup to features when they are clicked.
    val onEachFeatureFunc: js.Function2[js.Dynamic, LFeatureGroup, Any] = (feature: js.Dynamic, layer: LFeatureGroup) => {
        layer.bindPopup(feature.properties.popupContent.toString)

      }
    LGeoJson(JSON.parse(geoJSONPointFeature),
      LGeoJsonOptions.onEachFeature(onEachFeatureFunc).result) //use onEachFeature func to set pop content for marker
      .addTo(map)
  })
    .buildU


  def apply() = component()
}

