package chandu0101.scalajs.facades.leaflet

import chandu0101.scalajs.facades._
import org.scalajs.dom.raw.{HTMLElement, MouseEvent}

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.{UndefOr, undefined}

/**
 * Created by chandrasekharkode on 3/1/15.
 */


@JSName("L.LatLng")
class LLatLng(val lat: Double, val lng: Double, alt: UndefOr[Double]) extends js.Object {
  def this(lat: Double, lng: Double) = this(lat, lng, undefined)

  def distanceTo(other: LLatLng): Double = js.native

  def equals(other: LLatLng): Boolean = js.native

  def wrap(left: Double, right: Double): LLatLng = js.native

}

object LLatLng {
  def apply(lat: Double, lng: Double, alt: UndefOr[Double] = undefined) = new LLatLng(lat, lng, alt)
}


@JSName("L.Point")
class LPoint(val x: Double, val y: Double, val roundB: UndefOr[Boolean]) extends js.Object {
  def this(x: Double, y: Double) = this(x, y, undefined)

  def add(other: LPoint): LPoint = js.native

  def subtract(other: LPoint): LPoint = js.native

  def multiplyBy(number: Double): LPoint = js.native

  def divideBy(other: LPoint): LPoint = js.native

  def equals(other: LPoint): LPoint = js.native

  def contains(other: LPoint): Boolean = js.native

  def distanceTo(other: LPoint): Double = js.native

  def round(): LPoint = js.native

  def floor(): LPoint = js.native
}

object LPoint {
  def apply(x: Double, y: Double, round: UndefOr[Boolean] = undefined) = new LPoint(x, y, round)
}

@JSName("L.Transformation")
class LTransformation(a: Double, b: Double, c: Double, d: Double) extends js.Object {
  def transform(point: LPoint, scale: UndefOr[Double] = undefined): LPoint = js.native

  def untransform(point: LPoint, scale: UndefOr[Double] = undefined): LPoint = js.native

}

object LTransformation {
  def apply(a: Double, b: Double, c: Double, d: Double): LTransformation = new LTransformation(a, b, c, d)
}

trait LIProjection extends js.Object {
  def project(latlng: LLatLng): LPoint = js.native

  def unproject(point: LPoint): LLatLng = js.native

  val SphericalMercator: LIProjection = js.native
  val Mercator: LIProjection = js.native
  val LonLat: LIProjection = js.native
}

trait LILayer extends LEventEmitter {
  def onAdd(map: LMap): Unit = js.native

  def onRemove(map: LMap): Unit = js.native
}

trait LICRS extends js.Object {
  def latLngToPoint(latlng: LLatLng, zoom: Double): LPoint = js.native

  def pointToLatLng(point: LPoint, zoom: Double): LLatLng = js.native

  def project(latlng: LLatLng): LPoint = js.native

  def scale(zoom: Double): Double = js.native

  def getSize(zoom: Double): LPoint = js.native

  val projection: LIProjection = js.native
  val transformation: LTransformation = js.native
  val code: String = js.native
  val EPSG3857: LICRS = js.native
  val EPSG4326: LICRS = js.native
  val EPSG3395: LICRS = js.native
  val Simple: LICRS = js.native
}

@JSName("L.LatLngBounds")
class LLatLngBounds(southWest: LLatLng, northEast: LLatLng) extends js.Object {

  def extend(latlng: LLatLng): LLatLngBounds = js.native

  @JSName("extend")
  def extendWithBounds(latlngBounds: LLatLngBounds): LLatLngBounds = js.native

  def getSouthWest(): LLatLng = js.native

  def getNorthEast(): LLatLng = js.native

  def getNorthWest(): LLatLng = js.native

  def getSouthEast(): LLatLng = js.native

  def getWest(): Double = js.native

  def getSouth(): Double = js.native

  def getEast(): Double = js.native

  def getNorth(): Double = js.native

  def getCenter(): Double = js.native

  def contains(other: LLatLngBounds): Boolean = js.native

  def intersects(other: LLatLngBounds): Boolean = js.native

  def equals(other: LLatLngBounds): Boolean = js.native

  def toBBoxString(): String = js.native

  def pad(bufferRatio: Double): LLatLngBounds = js.native

  def isValid(): Boolean = js.native
}

object LLatLngBounds {
  def apply(southWest: LLatLng, northEast: LLatLng) = new LLatLngBounds(northEast, southWest)
}

trait LEvent extends js.Object {

  @JSName("type") // TODO  not working - check it
  val tpe: String = js.native
  @JSName("type") val eventType: String = js.native
  val target: js.Dynamic = js.native
}

trait LMouseEvent extends LEvent {
  val latlng: LLatLng = js.native
  val layerPoint: LPoint = js.native
  val containerPoint: LPoint = js.native
  val originalEvent: MouseEvent = js.native
}

trait LLocationEvent extends LEvent {
  val latlng: LLatLng = js.native
  val bounds: LLatLngBounds = js.native
  val accuracy: Double = js.native
  val altitude: Double = js.native
  val altitudeAccuracy: Double = js.native
  val heading: Double = js.native
  val speed: Double = js.native
  val timestamp: Double = js.native
}


trait LErrorEvent extends LEvent {
  val message: String = js.native
  val code: Double = js.native
}

trait LLayerEvent extends LEvent {
  val layer: LILayer = js.native

}

trait LLayersControlEvent extends LEvent {

  val layer: LLayersControlEvent = js.native
  val name: String = js.native
}

trait LTileEvent extends LEvent {
  val tile: HTMLElement = js.native
  val url: String = js.native
}

trait LResizeEvent extends LEvent {
  val oldSize: LPoint = js.native
  val newSize: LPoint = js.native
}

trait LGeoJSONEvent extends LEvent {
  val layer: LILayer = js.native
  val properties: js.Dynamic = js.native
  val geometryType: String = js.native
  val id: String = js.native

}

trait LPopupEvent extends LEvent {
  val popup: LPopup = js.native
}

trait LDragEndEvent extends LEvent {
  val distance: Double = js.native
}

trait LEventEmitter extends js.Object {
  //TODO check this variance later!
  def on[LEventType <: LEvent](name: String, listener: js.Function1[LEventType, Any], context: UndefOr[js.Object] = undefined): this.type = js.native

  def off[LEventType <: LEvent](name: String, listener: js.Function1[LEventType, Any], context: UndefOr[js.Object] = undefined): this.type = js.native

  def once[LEventType <: LEvent](name: String, listener: js.Function1[LEventType, Any], context: UndefOr[js.Object] = undefined): this.type = js.native

  def fire(name: String, data: UndefOr[js.Object] = undefined): this.type = js.native

  def removeEventListener(): this.type = js.native

  def clearAllEventListeners(): this.type = js.native

  def hasEventListeners(tpe: String): Boolean = js.native

}


object LEventEmitter {

  implicit class LEventEmitterEvents(val self: LEventEmitter) extends AnyVal {

    def onClick(listener: js.Function1[LMouseEvent, Any]): self.type = self.on("click", listener)

    def onDblclick(listener: js.Function1[LMouseEvent, Any]): self.type = self.on("dblclick", listener)

    def onMouseDown(listener: js.Function1[LMouseEvent, Any]): self.type = self.on("mousedown", listener)

    def onMouseUp(listener: js.Function1[LMouseEvent, Any]): self.type = self.on("mouseup", listener)

    def onMouseOver(listener: js.Function1[LMouseEvent, Any]): self.type = self.on("mouseover", listener)

    def onMouseOut(listener: js.Function1[LMouseEvent, Any]): self.type = self.on("mouseout", listener)

    def onMouseMove(listener: js.Function1[LMouseEvent, Any]): self.type = self.on("mousemove", listener)

    def onContextmenu(listener: js.Function1[LMouseEvent, Any]): self.type = self.on("contextmenu", listener)

    def onFocus(listener: js.Function1[LEvent, Any]): self.type = self.on("focus", listener)

    def onBlur(listener: js.Function1[LEvent, Any]): self.type = self.on("blur", listener)

    def onPreclick(listener: js.Function1[LMouseEvent, Any]): self.type = self.on("preclick", listener)

    def onLoad(listener: js.Function1[LEvent, Any]): self.type = self.on("load", listener)

    def onUnload(listener: js.Function1[LEvent, Any]): self.type = self.on("unload", listener)

    def onViewreset(listener: js.Function1[LEvent, Any]): self.type = self.on("viewreset", listener)

    def onMovestart(listener: js.Function1[LEvent, Any]): self.type = self.on("movestart", listener)

    def onMove(listener: js.Function1[LEvent, Any]): self.type = self.on("move", listener)

    def onMoveend(listener: js.Function1[LEvent, Any]): self.type = self.on("moveend", listener)

    def onDragstart(listener: js.Function1[LEvent, Any]): self.type = self.on("dragstart", listener)

    def onDrag(listener: js.Function1[LEvent, Any]): self.type = self.on("drag", listener)

    def onDragend(listener: js.Function1[LDragEndEvent, Any]): self.type = self.on("dragend", listener)

    def onZoomend(listener: js.Function1[LDragEndEvent, Any]): self.type = self.on("zoomend", listener)

    def onZoomlevelschange(listener: js.Function1[LEvent, Any]): self.type = self.on("zoomlevelschange", listener)

    def onResize(listener: js.Function1[LResizeEvent, Any]): self.type = self.on("resize", listener)

    def onAutopanstart(listener: js.Function1[LEvent, Any]): self.type = self.on("autopanstart", listener)

    def onLayeradd(listener: js.Function1[LLayerEvent, Any]): self.type = self.on("layeradd", listener)

    def onLayerremove(listener: js.Function1[LLayerEvent, Any]): self.type = self.on("layerremove", listener)

    def onBaselayerchange(listener: js.Function1[LLayerEvent, Any]): self.type = self.on("baselayerchange", listener)

    def onOverlayadd(listener: js.Function1[LLayerEvent, Any]): self.type = self.on("overlayadd", listener)

    def onOverlayremove(listener: js.Function1[LLayerEvent, Any]): self.type = self.on("overlayremove", listener)

    def onLocationfound(listener: js.Function1[LLocationEvent, Any]): self.type = self.on("locationfound", listener)

    def onLocationerror(listener: js.Function1[LErrorEvent, Any]): self.type = self.on("locationerror", listener)

    def onPopupopen(listener: js.Function1[LPopupEvent, Any]): self.type = self.on("popupopen", listener)

    def onPopupclose(listener: js.Function1[LPopupEvent, Any]): self.type = self.on("popupclose", listener)

    def onAdd(listener: js.Function1[LEvent, Any]): self.type = self.on("add", listener)

    def onRemove(listener: js.Function1[LEvent, Any]): self.type = self.on("remove", listener)

    def onLoading(listener: js.Function1[LEvent, Any]): self.type = self.on("loading", listener)

    def onTileloadstart(listener: js.Function1[LTileEvent, Any]): self.type = self.on("tileloadstart", listener)

    def onTileload(listener: js.Function1[LTileEvent, Any]): self.type = self.on("tileload", listener)

    def onTileunload(listener: js.Function1[LTileEvent, Any]): self.type = self.on("tileunload", listener)


  }

}

trait LMapOptions extends js.Object

object LMapOptions extends LMapOptionsBuilder(noOpts)

class LMapOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[LMapOptions, LMapOptionsBuilder](new LMapOptionsBuilder(_)) {

  def keyboardZoomOffset(v: Int) = jsOpt("keyboardZoomOffset", v)

  def bounceAtZoomLimits(v: Boolean) = jsOpt("bounceAtZoomLimits", v)

  def fadeAnimation(v: Boolean) = jsOpt("fadeAnimation", v)

  def maxZoom(v: Int) = jsOpt("maxZoom", v)

  def keyboardPanOffset(v: Int) = jsOpt("keyboardPanOffset", v)

  def zoomControl(v: Boolean) = jsOpt("zoomControl", v)

  def inertiaMaxSpeed(v: Int) = jsOpt("inertiaMaxSpeed", v)

  def zoomAnimationThreshold(v: Int) = jsOpt("zoomAnimationThreshold", v)

  def zoom(v: Int) = jsOpt("zoom", v)

  def tapTolerance(v: Int) = jsOpt("tapTolerance", v)

  def layers(v: js.Array[LILayer]) = jsOpt("layers", v)

  def worldCopyJump(v: Boolean) = jsOpt("worldCopyJump", v)

  def trackResize(v: Boolean) = jsOpt("trackResize", v)

  def touchZoom(v: Boolean) = jsOpt("touchZoom", v)

  def tap(v: Boolean) = jsOpt("tap", v)

  def dragging(v: Boolean) = jsOpt("dragging", v)

  def scrollWheelZoom(v: Boolean) = jsOpt("scrollWheelZoom", v)

  def boxZoom(v: Boolean) = jsOpt("boxZoom", v)

  def inertia(v: Boolean) = jsOpt("inertia", v)

  def attributionControl(v: Boolean) = jsOpt("attributionControl", v)

  def doubleClickZoom(v: Boolean) = jsOpt("doubleClickZoom", v)

  def crs(v: LICRS) = jsOpt("crs", v)

  def inertiaDeceleration(v: Int) = jsOpt("inertiaDeceleration", v)

  def zoomAnimation(v: Boolean) = jsOpt("zoomAnimation", v)

  def center(v: LLatLng) = jsOpt("center", v)

  def closePopupOnClick(v: Boolean) = jsOpt("closePopupOnClick", v)

  def markerZoomAnimation(v: Boolean) = jsOpt("markerZoomAnimation", v)

  def minZoom(v: Int) = jsOpt("minZoom", v)

  def maxBounds(v: LLatLngBounds) = jsOpt("maxBounds", v)

  def inertiaThreshold(v: Int) = jsOpt("inertiaThreshold", v)

  def keyboard(v: Boolean) = jsOpt("keyboard", v)

}


trait LZoomOptions extends js.Object

object LZoomOptions extends LZoomOptionsBuilder(noOpts)

class LZoomOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[LZoomOptions, LZoomOptionsBuilder](new LZoomOptionsBuilder(_)) {

  def animate(v: Boolean) = jsOpt("animate", v)

}

trait LPanOptions extends js.Object

object LPanOptions extends LPanOptionsBuilder(noOpts)

class LPanOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[LPanOptions, LPanOptionsBuilder](new LPanOptionsBuilder(_)) {

  def duration(v: Double) = jsOpt("duration", v)

  def animate(v: Boolean) = jsOpt("animate", v)

  def noMoveStart(v: Boolean) = jsOpt("noMoveStart", v)

  def easeLinearity(v: Double) = jsOpt("easeLinearity", v)

}


trait LZoomPanOptions extends js.Object

object LZoomPanOptions extends LZoomPanOptionsBuilder(noOpts)

class LZoomPanOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[LZoomPanOptions, LZoomPanOptionsBuilder](new LZoomPanOptionsBuilder(_)) {

  def animate(v: Boolean) = jsOpt("animate", v)

  def pan(v: LPanOptions) = jsOpt("pan", v)

  def reset(v: Boolean) = jsOpt("reset", v)

  def zoom(v: LZoomOptions) = jsOpt("zoom", v)

}


trait LFitBoundsOptions extends LZoomPanOptions

object LFitBoundsOptions extends LFitBoundsOptionsBuilder(noOpts)

class LFitBoundsOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[LFitBoundsOptions, LFitBoundsOptionsBuilder](new LFitBoundsOptionsBuilder(_)) {

  def paddingTopLeft(v: LPoint) = jsOpt("paddingTopLeft", v)

  def paddingBottomRight(v: LPoint) = jsOpt("paddingBottomRight", v)

  def padding(v: LPoint) = jsOpt("padding", v)

  def maxZoom(v: Double) = jsOpt("maxZoom", v)

}


trait LocateOptions extends js.Object

object LocateOptions extends LocateOptionsBuilder(noOpts)

class LocateOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[LocateOptions, LocateOptionsBuilder](new LocateOptionsBuilder(_)) {

  def timeout(v: Double) = jsOpt("timeout", v)

  def maximumAge(v: Double) = jsOpt("maximumAge", v)

  def enableHighAccuracy(v: Boolean) = jsOpt("enableHighAccuracy", v)

  def maxZoom(v: Double) = jsOpt("maxZoom", v)

  def setView(v: Boolean) = jsOpt("setView", v)

  def watch(v: Boolean) = jsOpt("watch", v)

}


@JSName("L.Bounds")
class LBounds(topLeft: LPoint, bottomRight: LPoint) extends js.Object {

  val min: LPoint = js.native
  val max: LPoint = js.native

  def extend(point: LPoint): Unit = js.native

  def getCenter(): LPoint = js.native

  def contains(other: LBounds): Boolean = js.native

  def contains(other: LPoint): Boolean = js.native

  def intersects(other: LBounds): Boolean = js.native

  def isValid(): Boolean = js.native

  def getSize(): LPoint = js.native

}

object LBounds {

  def apply(topLeft: LPoint, bottomRight: LPoint) = new LBounds(topLeft, bottomRight)

}


trait LPopupOptions extends js.Object

object LPopupOptions extends LPopupOptionsBuilder(noOpts)

class LPopupOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[LPopupOptions, LPopupOptionsBuilder](new LPopupOptionsBuilder(_)) {

  def offset(v: LPoint) = jsOpt("offset", v)

  def keepInView(v: Boolean) = jsOpt("keepInView", v)

  def minWidth(v: Double) = jsOpt("minWidth", v)

  def autoPan(v: Boolean) = jsOpt("autoPan", v)

  def maxWidth(v: Double) = jsOpt("maxWidth", v)

  def autoPanPaddingTopLeft(v: LPoint) = jsOpt("autoPanPaddingTopLeft", v)

  def closeOnClick(v: Boolean) = jsOpt("closeOnClick", v)

  def zoomAnimation(v: Boolean) = jsOpt("zoomAnimation", v)

  def closeButton(v: Boolean) = jsOpt("closeButton", v)

  def autoPanPaddingBottomRight(v: LPoint) = jsOpt("autoPanPaddingBottomRight", v)

  def autoPanPadding(v: LPoint) = jsOpt("autoPanPadding", v)

  def maxHeight(v: Double) = jsOpt("maxHeight", v)

  def className(v: String) = jsOpt("className", v)
}


@JSName("L.Popup")
class LPopup extends js.Object {
  def this(options: UndefOr[LPopupOptions] = undefined, source: UndefOr[LILayer] = undefined) = this()

  def addTo(map: LMap): LPopup = js.native

  def openOn(map: LMap): LPopup = js.native

  def setLatLng(latlng: LLatLng): LPopup = js.native

  def getLatLng(): LLatLng = js.native

  def setContent(htmlContent: String): LPopup = js.native

  def setContent(htmlContent: HTMLElement): LPopup = js.native

  def getContent(): String = js.native

  @JSName("getContent")
  def getContentElement(): HTMLElement = js.native

  def update(): LPopup = js.native

}

object LPopup {
  def apply(options: UndefOr[LPopupOptions] = undefined, source: UndefOr[LILayer] = undefined) = new LPopup(options, source)
}


trait LIControl extends js.Object {

//  def onAdd(map: LMap): HTMLElement = js.native

  var onAdd :js.Function1[LMap,HTMLElement] = js.native

  var onRemove : js.Function1[LMap,Any] = js.native

  var update : js.Function1[UndefOr[js.Dynamic],Any] = js.native
//  def onRemove(map: LMap): Unit = js.native

}

trait LMapPanes extends js.Object {

  def mapPane: HTMLElement = js.native

  def tilePane: HTMLElement = js.native

  def objectsPane: HTMLElement = js.native

  def shadowPane: HTMLElement = js.native

  def overlayPane: HTMLElement = js.native

  def markerPane: HTMLElement = js.native

  def popupPane: HTMLElement = js.native

}


trait LIconOptions extends js.Object

object LIconOptions extends LIconOptionsBuilder(noOpts)

class LIconOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[LIconOptions, LIconOptionsBuilder](new LIconOptionsBuilder(_)) {

  def iconRetinaUrl(v: String) = jsOpt("iconRetinaUrl", v)

  def iconUrl(v: String) = jsOpt("iconUrl", v)

  def shadowUrl(v: String) = jsOpt("shadowUrl", v)

  def iconAnchor(v: LPoint) = jsOpt("iconAnchor", v)

  def iconSize(v: LPoint) = jsOpt("iconSize", v)

  def shadowAnchor(v: LPoint) = jsOpt("shadowAnchor", v)

  def shadowSize(v: LPoint) = jsOpt("shadowSize", v)

  def shadowRetinaUrl(v: String) = jsOpt("shadowRetinaUrl", v)

  def popupAnchor(v: LPoint) = jsOpt("popupAnchor", v)

  def className(v: String) = jsOpt("className", v)

}


@JSName("L.Icon")
class LIcon extends js.Object {

  def this(options: LIconOptions) = this()

}

object LIcon {
  def apply(options: LIconOptions) = new LIcon(options)
}

@JSName("L.Icon.Default")
class LIconDefault extends LIcon

@JSName("L.Icon.Default")
object LIconDefault extends LIcon {
  var imagePath: String = js.native
}


trait LMarkerOptions extends js.Object

object LMarkerOptions extends LMarkerOptionsBuilder(noOpts)

class LMarkerOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[LMarkerOptions, LMarkerOptionsBuilder](new LMarkerOptionsBuilder(_)) {

  def opacity(v: Double) = jsOpt("opacity", v)

  def riseOnHover(v: Boolean) = jsOpt("riseOnHover", v)

  def draggable(v: Boolean) = jsOpt("draggable", v)

  def title(v: String) = jsOpt("title", v)

  def clickable(v: Boolean) = jsOpt("clickable", v)

  def icon(v: LIcon) = jsOpt("icon", v)

  def zIndexOffset(v: Double) = jsOpt("zIndexOffset", v)

  def riseOffset(v: Double) = jsOpt("riseOffset", v)

  def keyboard(v: Boolean) = jsOpt("keyboard", v)

  def alt(v: String) = jsOpt("alt", v)

}


trait LIHandler extends js.Object {

  def enable(): Unit = js.native

  def disable(): Unit = js.native

  def enabled(): Boolean = js.native
}


@JSName("L.Marker")
class LMarker extends LILayer {
  def this(latlng: LLatLng, options: UndefOr[LMarkerOptions] = undefined) = this()

  val dragging: LIHandler = js.native

  def addTo(map: LMap): LMarker = js.native

  def getLatLng(): LLatLng = js.native

  def setLatLng(latlng: LLatLng): LMarker = js.native

  def setIcon(icon: LIcon): LMarker = js.native

  def setZIndexOffset(offset: Double): LMarker = js.native

  def setOpacity(opacity: Double): LMarker = js.native

  def update(): LMarker = js.native

  def bindPopup(html: String, options: UndefOr[LPopupOptions] = undefined): LMarker = js.native

  @JSName("bindPopup")
  def bindPopupWithElement(el: HTMLElement, popup: LPopup, options: UndefOr[LPopupOptions] = undefined): LMarker = js.native

  @JSName("bindPopup")
  def bindPopupWithPopup(popup: LPopup, options: UndefOr[LPopupOptions] = undefined): LMarker = js.native

  def unbindPopup(): LMarker = js.native

  def openPopup(): LMarker = js.native

  def getPopup(): LMarker = js.native

  def closePopup(): LMarker = js.native

  def togglePopup(): LMarker = js.native

  def setPopupContent(html: String): LMarker = js.native

  def setPopupContent(el: HTMLElement): LMarker = js.native

  def toGeoJSON(): js.Dynamic = js.native

}


object LMarker {

  def apply(latlng: LLatLng, options: UndefOr[LMarkerOptions] = undefined) = new LMarker(latlng, options)

}


trait LTileLayerWMSOptions extends js.Object {

  val layers: UndefOr[String] = js.native
  val styles: UndefOr[String] = js.native
  val format: UndefOr[String] = js.native
  val transparent: UndefOr[Boolean] = js.native
  val version: UndefOr[String] = js.native
  val crs: UndefOr[LICRS] = js.native

}

object LTileLayerWMSOptions {

  def apply(crs: UndefOr[LICRS] = null,
            transparent: UndefOr[Boolean] = false,
            version: UndefOr[String] = "1.1.1",
            format: UndefOr[String] = "image/jpeg",
            layers: UndefOr[String] = "",
            styles: UndefOr[String] = "") =
    json("layers" -> layers, "styles" -> styles, "crs" -> crs, "format" -> format, "version" -> version, "transparent" -> transparent).asInstanceOf[LTileLayerWMSOptions]


}

@JSName("L.TileLayer.WMS")
class LTileLayerWMS extends LTileLayer {

  def this(baseurl: String, options: LTileLayerWMSOptions) = this()

  //  def setParams()
}


trait LTileLayerOptions extends js.Object

object LTileLayerOptions extends LTileLayerOptionsBuilder(noOpts)

class LTileLayerOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[LTileLayerOptions, LTileLayerOptionsBuilder](new LTileLayerOptionsBuilder(_)) {

  def unloadInvisibleTiles(v: Boolean) = jsOpt("unloadInvisibleTiles", v)

  def mapId(v: String) = jsOpt("mapId", v)

  def opacity(v: Double) = jsOpt("opacity", v)

  def maxNativeZoom(v: Double) = jsOpt("maxNativeZoom", v)

  def minZoom(v: Double) = jsOpt("minZoom", v)

  def zoomOffset(v: Double) = jsOpt("zoomOffset", v)

  def updateWhenIdle(v: Boolean) = jsOpt("updateWhenIdle", v)

  def noWrap(v: Boolean) = jsOpt("noWrap", v)

  def errorTileUrl(v: String) = jsOpt("errorTileUrl", v)

  def maxZoom(v: Double) = jsOpt("maxZoom", v)

  def continuousWorld(v: Boolean) = jsOpt("continuousWorld", v)

  def subdomains(v: String) = jsOpt("subdomains", v)

  def attribution(v: String) = jsOpt("attribution", v)

  def tileSize(v: Double) = jsOpt("tileSize", v)

  def zoomReverse(v: Boolean) = jsOpt("zoomReverse", v)

  def detectRetina(v: Boolean) = jsOpt("detectRetina", v)

  def token(v: String) = jsOpt("token", v)

  def tms(v: Boolean) = jsOpt("tms", v)

  def bounds(v: LLatLngBounds) = jsOpt("bounds", v)

  def reuseTiles(v: Boolean) = jsOpt("reuseTiles", v)

  def zIndex(v: Double) = jsOpt("zIndex", v)

}


@JSName("L.TileLayer")
class LTileLayer extends LILayer {

  def this(urlTemplate: String, options: UndefOr[LTileLayerOptions] = undefined) = this()

  def addTo(map: LMap): LTileLayer = js.native

  def bringToFront(): LTileLayer = js.native

  def bringToBack(): LTileLayer = js.native

  def setOpacity(opacity: Double): LTileLayer = js.native

  def setZIndex(zIndex: Double): LTileLayer = js.native

  def redraw(): LTileLayer = js.native

  def setUrl(urlTemplate: String): LTileLayer = js.native

  def getContainer(): HTMLElement = js.native

  def wms(baseurl: String, options: LTileLayerWMSOptions): LTileLayerWMS = js.native
}

object LTileLayer {

  def apply(urlTemplate: String, options: UndefOr[LTileLayerOptions] = undefined) = new LTileLayer(urlTemplate, options)

}


trait LImageOverlayOptions extends js.Object

object LImageOverlayOptions extends LImageOverlayOptionsBuilder(noOpts)

class LImageOverlayOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[LImageOverlayOptions, LImageOverlayOptionsBuilder](new LImageOverlayOptionsBuilder(_)) {

  def opacity(v: Double) = jsOpt("opacity", v)

  def attribution(v: String) = jsOpt("attribution", v)

}


@JSName("L.ImageOverlay")
class LImageOverlay extends js.Object {
  def this(imageUrl: String, bounds: LLatLngBounds, options: UndefOr[LImageOverlayOptions] = undefined) = this()

  def addTo(map: LMap): LImageOverlay = js.native

  def setOpacity(opacity: Double): LImageOverlay = js.native

  def setUrl(imageUrl: String): LImageOverlay = js.native

  def bringToFront(): LImageOverlay = js.native

  def bringToBack(): LImageOverlay = js.native

}

object LImageOverlay {

  def apply(imageUrl: String, bounds: LLatLngBounds, options: UndefOr[LImageOverlayOptions] = undefined) = new LImageOverlay(imageUrl, bounds, options)

}


trait LPathOptions extends js.Object {

  val stroke: UndefOr[Boolean] = js.native
  val color: UndefOr[String] = js.native
  val weight: UndefOr[Double] = js.native
  val opacity: UndefOr[Double] = js.native
  val fill: UndefOr[Boolean] = js.native
  val fillColor: UndefOr[String] = js.native
  val fillOpacity: UndefOr[Double] = js.native
  val dashArray: UndefOr[String] = js.native
  val lineCap: UndefOr[String] = js.native
  val lineJoin: UndefOr[String] = js.native
  val clickable: UndefOr[Boolean] = js.native
  val pointerEvents: UndefOr[String] = js.native
  val className: UndefOr[String] = js.native

}

object LPathOptions extends LPathOptionsBuilder(noOpts)


class LPathOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[LPathOptions, LPathOptionsBuilder](new LPathOptionsBuilder(_)) {

  def stroke(v: Boolean) = jsOpt("stroke", v)

  def color(v: String) = jsOpt("color", v)

  def weight(v: Double) = jsOpt("weight", v)

  def opacity(v: Double) = jsOpt("opacity", v)

  def fill(v: Boolean) = jsOpt("fill", v)

  def fillColor(v: String) = jsOpt("fillColor", v)

  def fillOpacity(v: Double) = jsOpt("fillOpacity", v)

  def dashArray(v: String) = jsOpt("dashArray", v)

  def lineCap(v: String) = jsOpt("lineCap", v)

  def lineJoin(v: String) = jsOpt("lineJoin", v)

  def clickable(v: Boolean) = jsOpt("clickable", v)

  def pointerEvents(v: String) = jsOpt("pointerEvents", v)

  def className(v: String) = jsOpt("className", v)
}

@JSName("L.Path")
trait LPath extends LILayer {

  def addTo(map: LMap): this.type = js.native

  def bindPopup(html: String, options: UndefOr[LPopupOptions] = undefined): this.type = js.native

  @JSName("bindPopup")
  def bindPopupWithElement(el: HTMLElement, options: UndefOr[LPopupOptions] = undefined): this.type = js.native

  @JSName("bindPopup")
  def bindPopupWithPopup(popup: LPopup, options: UndefOr[LPopupOptions] = undefined): this.type = js.native

  def unbindPopup(): this.type = js.native

  def openPopup(latlng: UndefOr[LLatLng] = undefined): this.type = js.native

  def closePopup(): this.type = js.native

  def setStyle(obj: LPathOptions): this.type = js.native

  def getBounds(): LLatLngBounds = js.native

  def bringToFront(): this.type = js.native

  def bringToBack(): this.type = js.native

  def redraw(): this.type = js.native

  val SVG: Boolean = js.native
  val VML: Boolean = js.native
  val CANVAS: Boolean = js.native
  val CLIP_PADDING: Double = js.native

}


trait LPolylineOptions extends LPathOptions

object LPolylineOptions extends LPolylineOptionsBuilder(noOpts)

class LPolylineOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[LPolylineOptions, LPolylineOptionsBuilder](new LPolylineOptionsBuilder(_)) {

  def fill(v: Boolean) = jsOpt("fill", v)

  def lineCap(v: String) = jsOpt("lineCap", v)

  def opacity(v: Double) = jsOpt("opacity", v)

  def color(v: String) = jsOpt("color", v)

  def fillColor(v: String) = jsOpt("fillColor", v)

  def pointerEvents(v: String) = jsOpt("pointerEvents", v)

  def lineJoin(v: String) = jsOpt("lineJoin", v)

  def clickable(v: Boolean) = jsOpt("clickable", v)

  def stroke(v: Boolean) = jsOpt("stroke", v)

  def dashArray(v: String) = jsOpt("dashArray", v)

  def smoothFactor(v: Double) = jsOpt("smoothFactor", v)

  def className(v: String) = jsOpt("className", v)

  def weight(v: Double) = jsOpt("weight", v)

  def noClip(v: Boolean) = jsOpt("noClip", v)

  def fillOpacity(v: Double) = jsOpt("fillOpacity", v)

}


@JSName("L.Polyline")
class LPolyline extends LPath {

  def this(latlngs: js.Array[LLatLng], options: UndefOr[LPolylineOptions] = undefined) = this()

  def addLatLng(latlng: LLatLng): LPolyline = js.native

  def setLatLngs(latlngs: js.Array[LLatLng]): LPolyline = js.native

  def getLatLngs(): js.Array[LLatLng] = js.native

  def spliceLatLngs(index: Int, pointsToRemove: Int, latlng: UndefOr[LLatLng] = undefined): js.Array[LLatLng] = js.native

  override def getBounds(): LLatLngBounds = js.native

  def toGeoJSON(): js.Dynamic = js.native

}

object LPolyline {

  def apply(latlngs: js.Array[LLatLng], options: UndefOr[LPolylineOptions] = undefined) = new LPolyline(latlngs, options)

}

@JSName("L.Polygon")
class LPolygon extends LPolyline {

  def this(latlngs: js.Array[LLatLng], options: UndefOr[LPolylineOptions] = undefined) = this()

  override def toGeoJSON(): js.Dynamic = js.native
}

object LPolygon {

  def apply(latlngs: js.Array[LLatLng], options: UndefOr[LPolylineOptions] = undefined) = new LPolygon(latlngs, options)

}


@JSName("L.LayerGroup")
class LLayerGroup extends LILayer {

  def this(layers: UndefOr[LILayer] = undefined) = this()

  def addTo(map: LMap): this.type = js.native

  def addLayer(layer: LILayer): this.type = js.native

  def removeLayer(layer: LILayer): this.type = js.native

  def removeLayer(id: String): this.type = js.native

  def hasLayer(layer: LILayer): Boolean = js.native

  def getLayer(id: String): LILayer = js.native

  def getLayers(): js.Array[LILayer] = js.native

  def clearLayers(): this.type = js.native

  def eachLayer(fn: js.Function, context: UndefOr[js.Object] = undefined): this.type = js.native

  def toGeoJSON(): js.Dynamic = js.native

}

object LLayerGroup {

  def apply(layers: UndefOr[LILayer] = undefined) = new LLayerGroup(layers)

}

@JSName("L.FeatureGroup")
class LFeatureGroup extends LLayerGroup with LEventEmitter {

  def this(layers: UndefOr[LILayer] = undefined) = this()

  def bindPopup(htmlContent: String, options: UndefOr[LPopupOptions] = undefined): this.type = js.native

  def setStyle(style: LPathOptions): this.type = js.native

  def bringToFront(): this.type = js.native

  def bringToBack(): this.type = js.native

  def getBounds(): LLatLngBounds = js.native

}

object LFeatureGroup {

  def apply(layers: UndefOr[LILayer] = undefined) = new LFeatureGroup(layers)

}


trait LGeoJsonOptions extends LPathOptions

object LGeoJsonOptions extends LGeoJsonOptionsBuilder(noOpts) {}

class LGeoJsonOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[LGeoJsonOptions, LGeoJsonOptionsBuilder](new LGeoJsonOptionsBuilder(_)) {

  def fill(v: Boolean) = jsOpt("fill", v)

  def lineCap(v: String) = jsOpt("lineCap", v)

  def opacity(v: Double) = jsOpt("opacity", v)

  def style(v: js.Function1[js.Dynamic, Any]) = jsOpt("style", v)

  def color(v: String) = jsOpt("color", v)

  def fillColor(v: String) = jsOpt("fillColor", v)

  def pointerEvents(v: String) = jsOpt("pointerEvents", v)

  def lineJoin(v: String) = jsOpt("lineJoin", v)

  def clickable(v: Boolean) = jsOpt("clickable", v)

  def stroke(v: Boolean) = jsOpt("stroke", v)

  def pointToLayer(v: js.Function2[js.Dynamic, LLatLng, Any]) = jsOpt("pointToLayer", v)

  def dashArray(v: String) = jsOpt("dashArray", v)

  def onEachFeature(v: js.Function2[js.Dynamic, LFeatureGroup, Any]) = jsOpt("onEachFeature", v)

  def className(v: String) = jsOpt("className", v)

  def weight(v: Double) = jsOpt("weight", v)

  def filter(v: js.Function2[js.Dynamic, LFeatureGroup, Any]) = jsOpt("filter", v)

  def fillOpacity(v: Double) = jsOpt("fillOpacity", v)

  def coordsToLatLng(v: js.Function1[js.Array[js.Dynamic], Any]) = jsOpt("coordsToLatLng", v)

}


@JSName("L.GeoJSON")
class LGeoJson extends LFeatureGroup {

  def this(geojson: UndefOr[js.Dynamic] = undefined, options: UndefOr[LGeoJsonOptions] = undefined) = this()

  def addData(data: js.Dynamic): LGeoJson = js.native

  def setStyle(data: js.Function1[js.Dynamic, Any]): LGeoJson = js.native

  def resetStyle(layer: LPath): LGeoJson = js.native

}

object LGeoJson {

  def apply(geojson: UndefOr[js.Dynamic] = undefined, options: UndefOr[LGeoJsonOptions] = undefined) = new LGeoJson(geojson, options)

}

@JSName("L.GeoJSON")
object LGeoJsonStatic extends js.Object {

  def geometryToLayer(featureData: js.Dynamic, pointToLayer: UndefOr[js.Function] = undefined): LILayer = js.native

  def coordsToLatLng(coords: js.Array[js.Dynamic], reverse: UndefOr[Boolean] = undefined): LLatLng = js.native

  def coordsToLatLngs(coords: js.Array[js.Dynamic], levelsDeep: UndefOr[js.Dynamic] = undefined, reverse: UndefOr[Boolean] = undefined): js.Array[js.Dynamic] = js.native

}


@JSName("L.Rectangle")
class LReactangle extends LPolygon {

  def this(bounds: LLatLngBounds, options: UndefOr[LPathOptions] = undefined) = this()

  def setBounds(bounds: LLatLngBounds): LReactangle = js.native

}


object LReactangle {

  def apply(bounds: LLatLngBounds, options: UndefOr[LPathOptions] = undefined) = new LReactangle(bounds, options)

}

@JSName("L.Circle")
class LCircle extends LPath {

  def this(latlng: LLatLng, radius: Double, options: UndefOr[LPathOptions] = undefined) = this()

  def hetLatLng(): LLatLng = js.native

  def getRadius(): Double = js.native

  def setLatLng(latlng: LLatLng): LCircle = js.native

  def setRadius(radius: Double): LCircle = js.native

  def toGeoJSON(): js.Dynamic = js.native


}

object LCircle {
  def apply(latlng: LLatLng, radius: Double, options: UndefOr[LPathOptions] = undefined) = new LCircle(latlng, radius, options)

}


trait LCircleMarkerOptions extends LPathOptions

object LCircleMarkerOptions extends LCircleMarkerOptionsBuilder(noOpts)

class LCircleMarkerOptionsBuilder(val dict :OptMap) extends JSOptionBuilder[LCircleMarkerOptions,LCircleMarkerOptionsBuilder](new LCircleMarkerOptionsBuilder(_)) {

  def fill(v: Boolean) = jsOpt("fill",v)

  def lineCap(v: String) = jsOpt("lineCap",v)

  def opacity(v: Double) = jsOpt("opacity",v)

  def color(v: String) = jsOpt("color",v)

  def fillColor(v: String) = jsOpt("fillColor",v)

  def pointerEvents(v: String) = jsOpt("pointerEvents",v)

  def lineJoin(v: String) = jsOpt("lineJoin",v)

  def clickable(v: Boolean) = jsOpt("clickable",v)

  def stroke(v: Boolean) = jsOpt("stroke",v)

  def dashArray(v: String) = jsOpt("dashArray",v)

  def className(v: String) = jsOpt("className",v)

  def weight(v: Double) = jsOpt("weight",v)

  def radius(v: Double) = jsOpt("radius",v)

  def fillOpacity(v: Double) = jsOpt("fillOpacity",v)

}



@JSName("L.CircleMarker")
class LCircleMarker extends LCircle {

  def this(latlng: LLatLng, options: UndefOr[LPathOptions] = undefined) = this()

  override def setLatLng(latlng: LLatLng): LCircleMarker = js.native

  override def setRadius(radius: Double): LCircleMarker = js.native

  override def toGeoJSON(): js.Dynamic = js.native
}

object LCircleMarker {

  def apply(latlng: LLatLng, options: UndefOr[LPathOptions] = undefined) = new LCircleMarker(latlng, options)

}


trait LDivIconOptions extends js.Object

object LDivIconOptions extends LDivIconOptionsBuilder(noOpts)

class LDivIconOptionsBuilder(val dict :OptMap) extends JSOptionBuilder[LDivIconOptions,LDivIconOptionsBuilder](new LDivIconOptionsBuilder(_)) {

  def iconAnchor(v: LPoint) = jsOpt("iconAnchor",v)

  def iconSize(v: LPoint) = jsOpt("iconSize",v)

  def popupAnchor(v: LPoint) = jsOpt("popupAnchor",v)

  def html(v: String) = jsOpt("html",v)

  def className(v: String) = jsOpt("className",v)

}



@JSName("L.DivIcon")
class LDivIcon extends js.Object {
  def this(options: LDivIconOptions) = this()
}

object LDivIcon {
  def apply(options: LDivIconOptions) = new LDivIcon(options)
}



trait LControlOptions extends js.Object

object LControlOptions extends LControlOptionsBuilder(noOpts)

class LControlOptionsBuilder(val dict :OptMap) extends JSOptionBuilder[LControlOptions,LControlOptionsBuilder](new LControlOptionsBuilder(_)) {

  def position(v: String) = jsOpt("position",v)

}



@JSName("L.Control")
class LControl extends LIControl {

  def this(options: UndefOr[LControlOptions] = undefined) = this()

  def setPosition(position: String): LControl = js.native

  def getPosition(): String = js.native

  def addTo(map: LMap): LControl = js.native

  def removeFrom(map: LMap): LControl = js.native

  def getContainer(): HTMLElement = js.native

  def zoom(options: UndefOr[LControlZoomOptions] = js.native): LControlZoom = js.native

  def attribution(options: UndefOr[LControlAttributionOptions] = undefined): LControlAttribution = js.native

  def layers(baseLayers: UndefOr[js.Dynamic] = undefined, overlays: UndefOr[js.Dynamic] = undefined, options: UndefOr[LControlLayersOptions] = undefined): LControlLayers = js.native

}

object LControl {

  def apply(options: UndefOr[LControlOptions] = undefined) = new LControl(options)

}



trait LControlZoomOptions extends js.Object

object LControlZoomOptions extends LControlZoomOptionsBuilder(noOpts)

class LControlZoomOptionsBuilder(val dict :OptMap) extends JSOptionBuilder[LControlZoomOptions,LControlZoomOptionsBuilder](new LControlZoomOptionsBuilder(_)) {

  def zoomOutText(v: String) = jsOpt("zoomOutText",v)

  def zoomInTitle(v: String) = jsOpt("zoomInTitle",v)

  def position(v: String) = jsOpt("position",v)

  def zoomOutTitle(v: String) = jsOpt("zoomOutTitle",v)

  def zoomInText(v: String) = jsOpt("zoomInText",v)

}





@JSName("L.Control.Zoom")
class LControlZoom extends LControl



trait LControlAttributionOptions extends js.Object

object LControlAttributionOptions extends LControlAttributionOptionsBuilder(noOpts)

class LControlAttributionOptionsBuilder(val dict :OptMap) extends JSOptionBuilder[LControlAttributionOptions,LControlAttributionOptionsBuilder](new LControlAttributionOptionsBuilder(_)) {

  def prefix(v: String) = jsOpt("prefix",v)

  def position(v: String) = jsOpt("position",v)

}


@JSName("L.Control.Attribution")
class LControlAttribution extends LControl {

  def setPrefix(prefix: String): LControlAttribution = js.native

  def addAttribution(text: String): LControlAttribution = js.native

  def removeAttribution(text: String): LControlAttribution = js.native

}


trait LControlLayersOptions extends js.Object

object LControlLayersOptions extends LControlLayersOptionsBuilder(noOpts)

class LControlLayersOptionsBuilder(val dict :OptMap) extends JSOptionBuilder[LControlLayersOptions,LControlLayersOptionsBuilder](new LControlLayersOptionsBuilder(_)) {

  def autoZIndex(v: Boolean) = jsOpt("autoZIndex",v)

  def position(v: String) = jsOpt("position",v)

  def collapsed(v: Boolean) = jsOpt("collapsed",v)

}



@JSName("L.Control.Layers")
class LControlLayers extends LControl with LEventEmitter {

  def addBaseLayer(layer: LILayer, name: String): LControlLayers = js.native

  def addOverlay(layer: LILayer, name: String): LControlLayers = js.native

  def removeLayer(layer: LILayer): LControlLayers = js.native
}

trait LControlScaleOptions extends js.Object

object LControlScaleOptions extends LControlScaleOptionsBuilder(noOpts)

class LControlScaleOptionsBuilder(val dict :OptMap) extends JSOptionBuilder[LControlScaleOptions,LControlScaleOptionsBuilder](new LControlScaleOptionsBuilder(_)) {

  def metric(v: Boolean) = jsOpt("metric",v)

  def maxWidth(v: Double) = jsOpt("maxWidth",v)

  def updateWhenIdle(v: Boolean) = jsOpt("updateWhenIdle",v)

  def position(v: String) = jsOpt("position",v)

  def imperial(v: Boolean) = jsOpt("imperial",v)

}

class LControlScale extends LControl {


}


@JSName("L.Map")
class LMap(id: String, options: UndefOr[LMapOptions]) extends LEventEmitter {


  def setView(center: LLatLng, zoom: UndefOr[Double] = undefined, options: UndefOr[LZoomPanOptions] = undefined): LMap = js.native

  def setZoom(zoom: Double, options: UndefOr[LZoomPanOptions] = undefined): LMap = js.native

  def zoomIn(delta: UndefOr[Double] = undefined, options: UndefOr[LZoomOptions] = undefined): LMap = js.native

  def zoomOut(delta: UndefOr[Double] = undefined, options: UndefOr[LZoomOptions] = undefined): LMap = js.native

  def setZoomAround(latlng: LLatLng, zoom: Double, options: UndefOr[LZoomOptions] = undefined): LMap = js.native

  def fitBounds(bounds: LLatLngBounds, options: UndefOr[LFitBoundsOptions] = undefined): LMap = js.native

  def fitWorld(options: UndefOr[LFitBoundsOptions] = undefined): LMap = js.native

  def panTo(latlng: LLatLng, options: UndefOr[LPanOptions] = undefined): LMap = js.native

  def panInsideBounds(bounds: LLatLngBounds, options: UndefOr[LPanOptions] = undefined): LMap = js.native

  def panBy(point: LPoint, options: UndefOr[LPanOptions] = undefined): LMap = js.native

  def invalidateSize(animate: Boolean): LMap = js.native

  def invalidateSize(options: LZoomPanOptions): LMap = js.native

  def setMaxBounds(bounds: LLatLngBounds): LMap = js.native

  def locate(options: UndefOr[LocateOptions] = undefined): LMap = js.native

  def stopLocate(): LMap = js.native

  def remove(): LMap = js.native

  //Methods for Getting Map State

  def getCenter(): LLatLng = js.native

  def getZoom(): Double = js.native

  def getMinZoom(): Double = js.native

  def getMaxZoom(): Double = js.native

  def getBounds(): Double = js.native

  def getBoundsZoom(bounds: LLatLngBounds, inside: UndefOr[Boolean] = undefined): Double = js.native

  def getSize(): LPoint = js.native

  def getPixelBounds(): LBounds = js.native

  def getPixelOrigin(): LPoint = js.native

  //Methods for Layers and Controls
  def addLayer(layer: LILayer): LMap = js.native

  def removeLayer(layer: LILayer): LMap = js.native

  def hasLayer(layer: LILayer): Boolean = js.native

  def eachLayer(fn: js.Function, context: UndefOr[js.Object] = undefined): LMap = js.native

  def openPopup(popup: LPopup): LMap = js.native

  def openPopup(html: String, latlng: LLatLng, options: UndefOr[LPopupOptions] = undefined): LMap = js.native

  @JSName("openPopup")
  def openPopupWithElement(el: HTMLElement, latlng: LLatLng, options: UndefOr[LPopupOptions] = undefined): LMap = js.native

  def closePopup(popup: UndefOr[LPopup] = undefined): LMap = js.native

  def addControl(control: LIControl): LMap = js.native

  def removeControl(control: LIControl): LMap = js.native

  //Conversion Methods
  def latLngToLayerPoint(latlng: LLatLng): LPoint = js.native

  def layerPointToLatLng(point: LPoint): LLatLng = js.native

  def containerPointToLayerPoint(point: LPoint): LPoint = js.native

  def layerPointToContainerPoint(point: LPoint): LPoint = js.native

  def latLngToContainerPoint(latlng: LLatLng): LPoint = js.native

  def containerPointToLatLng(point: LPoint): LLatLng = js.native

  def project(latlng: LLatLng, zoom: UndefOr[Double] = undefined): LPoint = js.native

  def unproject(point: LPoint, zoom: UndefOr[Double] = undefined): LLatLng = js.native

  def mouseEventToContainerPoint(event: LMouseEvent): LPoint = js.native

  def mouseEventToLayerPoint(event: LMouseEvent): LPoint = js.native

  def mouseEventToLatLng(event: LMouseEvent): LPoint = js.native

  // other methods
  def getContainer(): HTMLElement = js.native

  def getPanes(): LMapPanes = js.native

  def whenReady(fn: js.Function, context: UndefOr[js.Object]): LMap = js.native

}

object LMap {

  def apply(id: String, options: UndefOr[LMapOptions] = undefined) = new LMap(id, options)
}


@JSName("L")
object LeafLeft extends js.Object {

  def map(id: String, options: UndefOr[LMapOptions] = undefined): LMap = js.native

  @JSName("map")
  def mapWithElement(id: HTMLElement, options: UndefOr[LMapOptions] = undefined): LMap = js.native

  def latlng(lat: Double, lng: Double, alt: UndefOr[Double] = undefined): LLatLng = js.native

  def latLngBounds(southWest: LLatLng, northEast: LLatLng): LLatLngBounds = js.native

  def latLngBounds(latlngs: js.Array[LLatLng]): LLatLngBounds = js.native

  def point(x: Double, y: Double, round: UndefOr[Boolean] = undefined): LPoint = js.native

  def CRS: LICRS = js.native

  def bounds(topLeft: LPoint, bottomRight: LPoint): LBounds = js.native

  def bounds(points: js.Array[LPoint]): LBounds = js.native

  def popup(options: UndefOr[LPopupOptions] = undefined, source: UndefOr[LILayer] = undefined): LPopup = js.native

  def icon(options: LIconOptions): LIcon = js.native

  def marker(latlng: LLatLng, options: UndefOr[LMarkerOptions] = undefined): LMarker = js.native

  def tileLayer(urlTemplate: String, options: UndefOr[LTileLayerOptions] = undefined): LTileLayer = js.native

  def imageOverlay(imageUrl: String, bounds: LLatLngBounds, options: UndefOr[LImageOverlayOptions] = undefined): LImageOverlay = js.native

  def polyline(latlngs: js.Array[LLatLng], options: UndefOr[LPolylineOptions] = undefined): LPolyline = js.native

  def layerGroup(layers: UndefOr[LILayer] = undefined): LLayerGroup = js.native

  def featureGroup(layers: UndefOr[LILayer] = undefined): LFeatureGroup = js.native

  def geoJson(geojson: UndefOr[js.Dynamic] = undefined, options: UndefOr[LGeoJsonOptions] = undefined): LGeoJson = js.native

  def polygon(latlngs: js.Array[LLatLng], options: UndefOr[LPolylineOptions] = undefined): LPolygon = js.native

  def reactangle(bounds: LLatLngBounds, options: UndefOr[LPathOptions] = undefined): LReactangle = js.native

  def circle(latlng: LLatLng, radius: Double, options: UndefOr[LPathOptions] = undefined): LCircle = js.native

  def circleMarker(latlng: LLatLng, options: UndefOr[LPathOptions] = undefined): LCircleMarker = js.native

  def divIcon(options: LDivIconOptions): LDivIcon = js.native

  def control(options: UndefOr[LControlOptions] = undefined): LControl = js.native

  def posAnimation(): LPosAnimation = js.native

  val version: String = js.native
}
