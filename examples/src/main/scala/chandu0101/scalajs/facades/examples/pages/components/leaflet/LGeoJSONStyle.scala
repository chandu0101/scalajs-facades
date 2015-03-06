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
object LGeoJSONStyle {
  val code =
    """
      |   div( id := "map", width := "600px", height := "285px")
      |  
      |   val geoJsonState =  [{
      |    "type": "Feature",
      |    "properties": {"party": "Republican"},
      |    "geometry": {
      |        "type": "Polygon",
      |        "coordinates": [[
      |            [-104.05, 48.99],
      |            [-97.22,  48.98],
      |            [-96.58,  45.94],
      |            [-104.03, 45.94],
      |            [-104.05, 48.99]
      |        ]]
      |    }
      |}, {
      |    "type": "Feature",
      |    "properties": {"party": "Democrat"},
      |    "geometry": {
      |        "type": "Polygon",
      |        "coordinates": [[
      |            [-109.05, 41.00],
      |            [-102.06, 40.99],
      |            [-102.03, 36.99],
      |            [-109.04, 36.99],
      |            [-109.05, 41.00]
      |        ]]
      |    }
      |}]
      |   // define map
      |    val map = LMap("map").setView(LLatLng(41.8369,-87.6847), 4.0)
      |    map.addLayer(getTileLayer)
      |    LIconDefault.imagePath = "images/" // set images path
      |    val styleFunction : js.Function1[js.Dynamic,js.Any] = (feature : js.Dynamic) => {
      |        if(feature.properties.party.toString == "Republican") json("color" -> "orange")
      |         else json("color" -> "green")
      |      }
      |    LGeoJson(JSON.parse(geoJsonStates),
      |    LGeoJsonOptions(
      |    style = styleFunction
      |    )
      |    ).addTo(map)
      
      |    
    """.stripMargin

  val component = ReactComponentB[Unit]("LGeoJSONStyle")

    .render(P => {
    div(
      h3("GeoJSON Style Option "),
      CodeExample(code)(
        div(key := "map", id := "map", width := "600px", height := "285px")
      )
    )

  })
    .componentDidMount(scope => {
    // define map 
    val map = LMap("map").setView(LLatLng(41.8369,-87.6847), 4.0)
    map.addLayer(getTileLayer)
    LIconDefault.imagePath = "images/" // set images path
    val styleFunction : js.Function1[js.Dynamic,js.Any] = (feature : js.Dynamic) => {
        if(feature.properties.party.toString == "Republican") json("color" -> "orange")
         else json("color" -> "green")
      }
    LGeoJson(JSON.parse(geoJsonStates),
    LGeoJsonOptions.style(styleFunction).result
    ).addTo(map)
    
  })
    .buildU


  def apply() = component()
}

