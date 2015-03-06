package chandu0101.scalajs.facades.examples.pages.components

import chandu0101.scalajs.facades.leaflet.plugins.LTileLayerPouchDB
import chandu0101.scalajs.facades.leaflet.{LLatLng, LTileLayerOptions}

package object leaflet {
  
  val MAP_ID = "chandu0101.lbkd0e8e"
  
  val ACCESS_TOKEN = "pk.eyJ1IjoiY2hhbmR1MDEwMSIsImEiOiJfTWJXQWdVIn0.P_YR-BkVn3AkUdsPgNh0Gw"
  
  val ATTRIBUTION_MAPBOX = "Map data &copy;<a href=\"http://openstreetmap.org\">OpenStreetMap</a> contributors, <a href=\"http://creativecommons.org/licenses/by-sa/2.0/\">CC-BY-SA</a>, Imagery © <a href=\"http://mapbox.com\">Mapbox</a>',"
  
  val MY_LOCATION = LLatLng(16.2428, 80.6400)
  
  def getTileLayer = LTileLayerPouchDB("https://{s}.tiles.mapbox.com/v4/{mapId}/{z}/{x}/{y}.png?access_token={token}",
    LTileLayerOptions.maxZoom(18.0)
      .token(ACCESS_TOKEN)
      .mapId(MAP_ID)
      .attribution(ATTRIBUTION_MAPBOX).result
  )
  
  
  val RANDOM_LOCATIONS =  Map(
   "Tenali" ->  LLatLng(16.2428, 80.6400),
   "Vijayawada" -> LLatLng(16.5083, 80.6417),
   "Machilipatnam" -> LLatLng(16.1700, 81.1300),
   "Amaravati" -> LLatLng(16.5728, 80.3575),
   "Guntur" -> LLatLng(16.3008, 80.4428)

  )
  
  
  val geoJSONPointFeature = """{
                              |    "type": "Feature",
                              |    "properties": {
                              |        "name": "Tenali",
                              |        "amenity": "Andhra Paris",
                              |        "popupContent": "Cool town!"
                              |    },
                              |    "geometry": {
                              |        "type": "Point",
                              |        "coordinates": [80.6400 ,16.2428]
                              |    }
                              |}""".stripMargin
  
  val geoJsonStates =
    """
      |[{
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
    """.stripMargin

}