package chandu0101.scalajs.facades.examples.pages.components.leaflet

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.leaflet._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js.Dynamic.{global => g, literal => json}

/**
 * Created by chandrasekharkode on 3/3/15.
 */
object LCustomMarkersDemo {
  val code =
    """
      |   div( id := "map", width := "600px", height := "285px")
      |
      |     // define map
      |    val map = LMap("map").setView(MY_LOCATION, 9.0)
      |    map.addLayer(getTileLayer)
      |    LIconDefault.imagePath = "images/" // set images path
      |    def getLeafIconOptions( icon : String) = LIconOptions(
      |        iconUrl = icon,
      |        shadowUrl = "images/leaf-shadow.png",
      |        shadowSize = LPoint(50,64),
      |        iconAnchor = LPoint(22,94),
      |        shadowAnchor = LPoint(4,62),
      |        popupAnchor = LPoint(-3,-76)
      |    )
      |
      |    val greenIcon = LIcon(getLeafIconOptions("images/leaf-green.png"))
      |    val redIcon = LIcon(getLeafIconOptions("images/leaf-red.png"))
      |    val orangeIcon = LIcon(getLeafIconOptions("images/leaf-orange.png"))
      |
      |
      |    LMarker(LLatLng(16.2428, 80.6400),LMarkerOptions(icon = greenIcon)).bindPopup("I am a green leaf").addTo(map)
      |    LMarker(LLatLng(16.5083, 80.6417),LMarkerOptions(icon = redIcon)).bindPopup("I am a red leaf").addTo(map)
      |    LMarker(LLatLng(16.3008, 80.4428),LMarkerOptions(icon = orangeIcon)).bindPopup("I am a orange leaf").addTo(map)
      |
      |    
    """.stripMargin

  val component = ReactComponentB[Unit]("LCustomMarkersDemo")

    .render(P => {
    div(
      h3("Custom Markers"),
      CodeExample(code)(
        div(key := "map", id := "map", width := "600px", height := "285px")
      )
    )

  })
    .componentDidMount(scope => {
    // define map 
    val map = LMap("map").setView(MY_LOCATION, 9.0)
    map.addLayer(getTileLayer)
    LIconDefault.imagePath = "images/" // set images path
    def getLeafIconOptions( icon : String) = LIconOptions.iconUrl(icon)
        .shadowUrl("images/leaf-shadow.png")
        .shadowSize(LPoint(50,64))
        .iconAnchor(LPoint(22,94))
        .shadowAnchor(LPoint(4,62))
        .popupAnchor(LPoint(-3,-76)).result

    val greenIcon = LIcon(getLeafIconOptions("images/leaf-green.png"))
    val redIcon = LIcon(getLeafIconOptions("images/leaf-red.png"))
    val orangeIcon = LIcon(getLeafIconOptions("images/leaf-orange.png"))

    
    LMarker(LLatLng(16.2428, 80.6400),LMarkerOptions.icon(greenIcon).result).bindPopup("I am a green leaf").addTo(map)
    LMarker(LLatLng(16.5083, 80.6417),LMarkerOptions.icon(redIcon).result).bindPopup("I am a red leaf").addTo(map)
    LMarker(LLatLng(16.3008, 80.4428),LMarkerOptions.icon(orangeIcon).result).bindPopup("I am a orange leaf").addTo(map)

    
  })
    .buildU


  def apply() = component()
}

