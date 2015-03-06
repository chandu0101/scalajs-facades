package chandu0101.scalajs.facades.examples.pages.components.leaflet

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.leaflet._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js.Dynamic.{global => g, literal => json}

/**
 * Created by chandrasekharkode on 3/3/15.
 */
object LBasicMap {
  val code =
    """
      |   div( id := "map", width := "600px", height := "285px")
      |
      |      // define map 
      |    val map = LMap("map").setView(LLatLng(16.1833, 80.8000), 8.0)
      |    //    val map = LeafLeft.map("map").setView(LLatLng(16.1833, 80.8000), 8.0) // defining map using Factory LeafLet
      |    // get tiles from mapbox /openstreet/..
      |    val mapId = "chandu0101.lbkd0e8e"
      |    val token = "pk.eyJ1IjoiY2hhbmR1MDEwMSIsImEiOiJfTWJXQWdVIn0.P_YR-BkVn3AkUdsPgNh0Gw"
      |    LTileLayer("https://{s}.tiles.mapbox.com/v4/{mapId}/{z}/{x}/{y}.png?access_token={token}",
      |      LTileLayerOptions(maxZoom = 18.0,
      |        token = token,
      |        mapId = mapId,
      |        attribution = "Map data &copy;<a href=\"http://openstreetmap.org\">OpenStreetMap</a> contributors, <a href=\"http://creativecommons.org/licenses/by-sa/2.0/\">CC-BY-SA</a>, Imagery © <a href=\"http://mapbox.com\">Mapbox</a>',")
      |    ).addTo(map) // add tiles to MAP
      
      |    
    """.stripMargin

  val component = ReactComponentB[Unit]("LBasicMap")

    .render(P => {
    div(
      h3("Basic Map"),
      CodeExample(code)(
        div(key := "map", id := "map", width := "600px", height := "285px")
      )
    )

  })
    .componentDidMount(scope => {
    // define map 
    val map = LMap("map").setView(LLatLng(16.1833, 80.8000), 8.0)
    //    val map = LeafLeft.map("map").setView(LLatLng(16.1833, 80.8000), 8.0) // defining map using Factory LeafLet
    // get tiles from mapbox /openstreet/..
    val mapId = "chandu0101.lbkd0e8e"
    val token = "pk.eyJ1IjoiY2hhbmR1MDEwMSIsImEiOiJfTWJXQWdVIn0.P_YR-BkVn3AkUdsPgNh0Gw"
    LTileLayer("https://{s}.tiles.mapbox.com/v4/{mapId}/{z}/{x}/{y}.png?access_token={token}",
      LTileLayerOptions.maxZoom (18.0)
        .token(token)
        .mapId(mapId)
        .attribution("Map data &copy;<a href=\"http://openstreetmap.org\">OpenStreetMap</a> contributors, <a href=\"http://creativecommons.org/licenses/by-sa/2.0/\">CC-BY-SA</a>, Imagery © <a href=\"http://mapbox.com\">Mapbox</a>',").result
    ).addTo(map) // add tiles to MAP
  })
    .buildU


  def apply() = component()
}

