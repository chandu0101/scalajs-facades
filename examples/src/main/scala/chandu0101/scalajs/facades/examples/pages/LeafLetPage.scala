package chandu0101.scalajs.facades.examples.pages

import chandu0101.scalajs.facades.examples.pages.common.{LeftnavPage, ExampleLeftNav}
import chandu0101.scalajs.facades.examples.routes.AppRouter.AppPage._
import chandu0101.scalajs.react.components.mixins.AsyncLoad
import japgolly.scalajs.react.{BackendScope, ReactComponentB, ReactNode}

/**
 * Created by chandrasekharkode on 3/3/15.
 */
object LeafLetPage {
  lazy val menu = List(
    ExampleLeftNav.Menu(text = "Info", route = linfo.path.value),
    ExampleLeftNav.Menu(text = "Basic Map", route = lBasicMap.path.value),
    ExampleLeftNav.Menu(text = "Marker", route = lMarker.path.value),
    ExampleLeftNav.Menu(text = "Popup", route = lPopup.path.value),
    ExampleLeftNav.Menu(text = "Marker Options", route = lMarkerOptions.path.value),
    ExampleLeftNav.Menu(text = "Multiple Markers", route = lMarkers.path.value),
    ExampleLeftNav.Menu(text = "Polyline", route = lPolyline.path.value),
    ExampleLeftNav.Menu(text = "Circle", route = lCircle.path.value),
    ExampleLeftNav.Menu(text = "Custom Markers", route = lCustomMarkers.path.value),
    ExampleLeftNav.Menu(text = "GeoJson", route = lGeoJson.path.value),
    ExampleLeftNav.Menu(text = "GeoJson Style", route = lGeoJsonStyle.path.value),
    ExampleLeftNav.Menu(text = "GeoJson PointToLayer", route = lGeoJsonPointToLayer.path.value),
    ExampleLeftNav.Menu(text = "GeoJson onEachFeature", route = lGeoJsonOnEachFeature.path.value),
    ExampleLeftNav.Menu(text = "Map Events", route = lEvents.path.value),
    ExampleLeftNav.Menu(text = "Interactive Map", route = lInteractiveMap.path.value),
    ExampleLeftNav.Menu(text = "Offline Tiles", route = lOfflineTiles.path.value)

  )
  
  class Backend(t: BackendScope[ReactNode,_]) extends AsyncLoad {
    cssResources =  List("styles/leaflet.css")
    
  }
  val component = ReactComponentB[ReactNode]("LeafLetPage")
    .stateless
    .backend(new Backend(_))
    .render((P,S,B) => {
    LeftnavPage(menu, P)
  })
    .configure(AsyncLoad.mixin)
    .build


  def apply(content: ReactNode) = component(content)
}
