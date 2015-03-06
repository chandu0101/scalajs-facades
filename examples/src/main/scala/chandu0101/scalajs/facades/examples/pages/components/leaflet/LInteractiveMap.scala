package chandu0101.scalajs.facades.examples.pages.components.leaflet

import chandu0101.scalajs.facades.examples.pages.common.CodeExample
import chandu0101.scalajs.facades.leaflet._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}

/**
 * Created by chandrasekharkode on 3/5/15.
 */
object LInteractiveMap {


  val code =
    """
      |   div( id := "map", width := "600px", height := "285px")
      |
      | val map = LMap("map").setView(LLatLng(34.8, -96), 4.0)
      |    map.addLayer(getTileLayer)
      |    LIconDefault.imagePath = "images/" // set images path
      |
      |    def getColor(d: Double) = if (d > 1000) "#800026"
      |    else if (d > 500) "#BD0026"
      |    else if (d > 200) "#E31A1C"
      |    else if (d > 100) "#FC4E2A"
      |    else if (d > 50) "#FD8D3C"
      |    else if (d > 20) "#FEB24C"
      |    else if (d > 10) "#FED976"
      |    else "#FFEDA0"
      |
      |
      |    val styleFunc: js.Function1[js.Dynamic, js.Any] = (feature: js.Dynamic) => {
      |      json("fillColor" -> getColor(feature.properties.density.asInstanceOf[Double]),
      |        "weight" -> 2,
      |        "opacity" -> 1.0,
      |        "color" -> "white",
      |        "dashArray" -> "3",
      |        "fill" -> true,
      |        "fillOpacity" -> "0.7"
      |      )
      |    }
      |
      |    var geojson: LGeoJson = null // define upfront so that we can use nice resetStyle method of LGeoJson
      |
      |    //custom info control
      |    val info = LControl()
      |    val el = LDomUtil.create("div","info")
      |    info.onAdd = (map : LMap) => {
      |      el
      |    }
      |    
      |    info.update = (props : js.UndefOr[js.Dynamic]) => {
      |      el.innerHTML =
      |            <h4> US Population Density </h4>
      |            ${if(js.isUndefined(props)) "Hover over a state" else s"<b> ${props.get.name} </b> <br> ${props.get.density}" }
      |    }
      |    
      |  info.addTo(map)
      |
      |    // adding interactions
      |    def highlightFeature(e: LMouseEvent) = {
      |      val layer = e.target.asInstanceOf[LFeatureGroup]
      |      layer.setStyle(
      |        LPathOptions.weight(5.0).color("#666").dashArray("").fillOpacity(0.7).result)
      |      if (!LBrowser.ie) layer.bringToFront()
      |      info.update(e.target.feature.properties)
      |    }
      |
      |    def resetHighlight(e: LEvent) = {
      |      geojson.resetStyle(e.target.asInstanceOf[LPath])
      |      info.update(js.undefined)
      |    }
      |
      |    def zoomToFeature(e: LMouseEvent) = {
      |      map.fitBounds(e.target.asInstanceOf[LPath].getBounds())
      |    }
      |
      |    val onEachFeature: js.Function2[js.Dynamic, LFeatureGroup, Any] = (feature: js.Dynamic, layer: LFeatureGroup) => {
      |      layer.onMouseOver(highlightFeature _)
      |        .onMouseOut(resetHighlight _)
      |             .onClick(zoomToFeature _)
      |    }
      |
      |    geojson = LGeoJson(js.Dynamic.global.statesData,
      |      LGeoJsonOptions.style(styleFunc).onEachFeature(onEachFeature).result
      |    )
      |      .addTo(map)|
    """.stripMargin

  val component = ReactComponentB[Unit]("GeoJSON pointToLayer option ")

    .render(P => {
    div(
      h3("GeoJSON"),
      CodeExample(code)(
        div(key := "map", id := "map", width := "990px", height := "350px")
      )
    )

  })
    .componentDidMount(scope => {
    // define map
    val map = LMap("map").setView(LLatLng(34.8, -96), 4.0)
    map.addLayer(getTileLayer)
    LIconDefault.imagePath = "images/" // set images path

    def getColor(d: Double) = if (d > 1000) "#800026"
    else if (d > 500) "#BD0026"
    else if (d > 200) "#E31A1C"
    else if (d > 100) "#FC4E2A"
    else if (d > 50) "#FD8D3C"
    else if (d > 20) "#FEB24C"
    else if (d > 10) "#FED976"
    else "#FFEDA0"


    val styleFunc: js.Function1[js.Dynamic, js.Any] = (feature: js.Dynamic) => {
      json("fillColor" -> getColor(feature.properties.density.asInstanceOf[Double]),
        "weight" -> 2,
        "opacity" -> 1.0,
        "color" -> "white",
        "dashArray" -> "3",
        "fill" -> true,
        "fillOpacity" -> "0.7"
      )
    }

    var geojson: LGeoJson = null // define upfront so that we can use nice resetStyle method of LGeoJson

    //custom info control
    val info = LControl()
    val el = LDomUtil.create("div","info")
    info.onAdd = (map : LMap) => {
      info.update(js.undefined)
      el
    }
    info.update = (props : js.UndefOr[js.Dynamic]) => {
      el.innerHTML =
        s"""
           | <h4> US Population Density </h4>
           | ${if(js.isUndefined(props)) "Hover over a state" else s"<b> ${props.get.name} </b> <br> ${props.get.density}" }
         """.stripMargin
    }

    info.addTo(map)
    
    // adding interactions 
    def highlightFeature(e: LMouseEvent) = {
      val layer = e.target.asInstanceOf[LFeatureGroup]
      layer.setStyle(
        LPathOptions.weight(5.0).color("#666").dashArray("").fillOpacity(0.7).result)
      if (!LBrowser.ie) layer.bringToFront()
      info.update(e.target.feature.properties)
    }

    def resetHighlight(e: LEvent) = {
      geojson.resetStyle(e.target.asInstanceOf[LPath])
      info.update(js.undefined)
    }

    def zoomToFeature(e: LMouseEvent) = {
      map.fitBounds(e.target.asInstanceOf[LPath].getBounds())
    }

    val onEachFeature: js.Function2[js.Dynamic, LFeatureGroup, Any] = (feature: js.Dynamic, layer: LFeatureGroup) => {
      layer.onMouseOver(highlightFeature _)
        .onMouseOut(resetHighlight _)
             .onClick(zoomToFeature _)
    }

    geojson = LGeoJson(js.Dynamic.global.statesData,
      LGeoJsonOptions.style(styleFunc).onEachFeature(onEachFeature).result
    )
      .addTo(map)
    
    

  })
    .buildU


  def apply() = component()
}
