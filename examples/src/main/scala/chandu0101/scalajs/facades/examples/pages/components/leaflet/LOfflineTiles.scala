package chandu0101.scalajs.facades.examples.pages.components.leaflet

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.leaflet.plugins.LTileLayerPouchDB
import chandu0101.scalajs.facades.leaflet.{LLatLng, LMap, LTileLayerOptions}
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._

/**
 * Created by chandrasekharkode on 3/6/15.
 */
object LOfflineTiles {

  val code =
    """
      |   div( id := "map", width := "600px", height := "285px")
      |
      |      val map = LMap("map").setView(LLatLng(16.1833, 80.8000), 8.0)
      |    val mapId = "chandu0101.lbkd0e8e"
      |    val token = "pk.eyJ1IjoiY2hhbmR1MDEwMSIsImEiOiJfTWJXQWdVIn0.P_YR-BkVn3AkUdsPgNh0Gw"
      |    // use LTileLayerPouchDB instead of LTileLayer which will store tiles in browser storage
      |    LTileLayerPouchDB("https://{s}.tiles.mapbox.com/v4/{mapId}/{z}/{x}/{y}.png?access_token={token}",
      |      LTileLayerOptions(maxZoom = 18.0,
      |        token = token,
      |        mapId = mapId,
      |        attribution = "Map data &copy;<a href=\"http://openstreetmap.org\">OpenStreetMap</a> contributors, <a href=\"http://creativecommons.org/licenses/by-sa/2.0/\">CC-BY-SA</a>, Imagery © <a href=\"http://mapbox.com\">Mapbox</a>',")
      |    ).addTo(map) // add tiles to MAP
      
      |    
    """.stripMargin

  val component = ReactComponentB[Unit]("LOfflineTiles")

    .render(P => {
    div(
      h3("Offline Tiles"),
      CodeExample(code)(
        div(key := "map", id := "map", width := "600px", height := "285px")
      )
    )

  })
    .componentDidMount(scope => {
    val map = LMap("map").setView(LLatLng(16.1833, 80.8000), 8.0)
    val mapId = "chandu0101.lbkd0e8e"
    val token = "pk.eyJ1IjoiY2hhbmR1MDEwMSIsImEiOiJfTWJXQWdVIn0.P_YR-BkVn3AkUdsPgNh0Gw"
    // use LTileLayerPouchDB instead of LTileLayer which will store tiles in browser storage
    LTileLayerPouchDB("https://{s}.tiles.mapbox.com/v4/{mapId}/{z}/{x}/{y}.png?access_token={token}",
      LTileLayerOptions.maxZoom (18.0)
        .token(token)
        .mapId(mapId)
        .attribution("Map data &copy;<a href=\"http://openstreetmap.org\">OpenStreetMap</a> contributors, <a href=\"http://creativecommons.org/licenses/by-sa/2.0/\">CC-BY-SA</a>, Imagery © <a href=\"http://mapbox.com\">Mapbox</a>',").result
    ).addTo(map) // add tiles to MAP
  })
    .buildU


  def apply() = component()
}
