package chandu0101.scalajs.facades.examples.pages.components.leaflet

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.leaflet._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js.Dynamic.{global => g, literal => json}

/**
 * Created by chandrasekharkode on 3/3/15.
 */
object LCircleDemo {
  val code =
    """
      |   div( id := "map", width := "600px", height := "285px")
      |
      | // define map
      |    val map = LMap("map").setView(MY_LOCATION, 13.0)
      |    map.addLayer(getTileLayer)
      |    LCircle(MY_LOCATION,500.0,
      |            LPathOptions(color = "gold",
      |            fillColor = "yellow",
      |            fill = true,
      |            fillOpacity = 0.5))
      |    .addTo(map).bindPopup("I am a circle")
      |    
      |    
    """.stripMargin

  val component = ReactComponentB[Unit]("LCircleDemo")
    .render(P => {
    div(
      h3("Circle"),
      CodeExample(code)(
        div(key := "map", id := "map", width := "600px", height := "285px")
      )
    )

  })
    .componentDidMount(scope => {
    // define map 
    val map = LMap("map").setView(MY_LOCATION, 13.0)
    map.addLayer(getTileLayer)
    LCircle(MY_LOCATION,500.0,
            LPathOptions.color("gold")
              .fillColor("yellow")
              .fill(true)
              .fillOpacity(0.5).result
            )
    .addTo(map).bindPopup("I am a circle")
    
  })
    .buildU


  def apply() = component()
}

