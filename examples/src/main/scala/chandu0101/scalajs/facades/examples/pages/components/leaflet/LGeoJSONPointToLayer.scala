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
object LGeoJSONPointToLayer {
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
      |
      |    //Points are handled differently than polylines and polygons. By default simple markers are drawn for GeoJSON Points. We can alter this by passing a pointToLayer function in a GeoJSON options object when creating the GeoJSON layer.
      |    val pointToLayerFunc : js.Function2[js.Dynamic,LLatLng,js.Any]   = (feature : js.Dynamic,latlng : LLatLng) => {
      |         LCircleMarker(latlng,LCircleMarkerOptions(
      |         radius = 8.0,
      |          fillColor = "yellow",
      |          fill = true,
      |          weight = 1.0,
      |         opacity = 1.0,
      |         fillOpacity = 0.8,
      |         color = "orange"
      |         ))
      |      }
      |    LGeoJson(JSON.parse(geoJSONPointFeature),
      |     LGeoJsonOptions(pointToLayer = pointToLayerFunc)) //use pointToLayer func to set marker for geojson point
      |      .addTo(map)
      |    
    """.stripMargin

  val component = ReactComponentB[Unit]("GeoJSON pointToLayer option ")

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

    //Points are handled differently than polylines and polygons. By default simple markers are drawn for GeoJSON Points. We can alter this by passing a pointToLayer function in a GeoJSON options object when creating the GeoJSON layer.
    val pointToLayerFunc: js.Function2[js.Dynamic, LLatLng, js.Any] = (feature: js.Dynamic, latlng: LLatLng) => {
      LCircleMarker(latlng, LCircleMarkerOptions
        .radius(8.0)
        .fillColor("yellow")
        .fill(true)
        .weight(1.0)
        .opacity(1.0)
        .fillOpacity(0.8)
        .color("orange").result
      )
    }
    LGeoJson(JSON.parse(geoJSONPointFeature),
      LGeoJsonOptions.pointToLayer(pointToLayerFunc).result) //use pointToLayer func to set marker for geojson point
      .addTo(map)

  })
    .buildU


  def apply() = component()
}

