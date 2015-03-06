package chandu0101.scalajs.facades.leaflet

import org.scalajs.dom.raw.HTMLElement

import scala.scalajs.js
import scala.scalajs.js.{undefined, UndefOr}
import scala.scalajs.js.annotation.JSName

/**
 * Created by chandrasekharkode on 3/3/15.
 */


@JSName("L.Browser")
object LBrowser extends js.Object {
  
  val ie : Boolean = js.native
  val ie6 : Boolean = js.native
  val ie7 : Boolean = js.native
  val webkit : Boolean = js.native
  val webkit3d : Boolean = js.native
  val android : Boolean = js.native
  val android23 : Boolean = js.native
  val mobile : Boolean = js.native
  val opera : Boolean = js.native
  val mobileWebkit : Boolean = js.native
  val mobileOpera : Boolean = js.native
  val touch : Boolean = js.native
  val msTouch : Boolean = js.native
  val retina : Boolean = js.native

}


@JSName("L.DomUtil")
object LDomUtil extends js.Object {
  
  def get(id : String) : HTMLElement = js.native
  def getStyle(el : HTMLElement,style : String) : String = js.native
  def getViewportOffset(el : HTMLElement) : LPoint = js.native
  def create( tagName : String,className : String,container : UndefOr[HTMLElement] = undefined) : HTMLElement = js.native
  def disableTextSelection() : Unit = js.native
  def enableTextSelection() : Unit = js.native
  def hasCLass(el : HTMLElement,name : String) : Boolean = js.native
  def addClass(el : HTMLElement,name : String) : Unit = js.native
  def removeClass(el : HTMLElement,name : String) : Unit = js.native
  def setOpacity(el : HTMLElement,value : Double) : Unit = js.native
  def testProp(props : js.Array[String]) : js.Dynamic = js.native
  def getTranslateString(point : LPoint) : String = js.native
  def getScaleString( scale : Double,origin : LPoint) : String = js.native
  def setPosition(el : HTMLElement,point : LPoint,diable3D : UndefOr[Boolean] = undefined) : Unit = js.native
  def getPosition(el : HTMLElement) : LPoint = js.native
  val TRANSITION : String = js.native
  val TRANSFORM : String = js.native

}

@JSName("L.PosAnimation")
class LPosAnimation extends js.Object with LEventEmitter {
  
  def run(el : HTMLElement,newPos : LPoint,duration : UndefOr[Double] = undefined,easeLinearity : UndefOr[Double] = undefined) : LPosAnimation = js.native
}

object LPosAnimation {
  
  def apply() = new LPosAnimation()
  
}

@JSName("L.Draggable")
class LDraggable extends js.Object with LEventEmitter{
  
  def this(el : HTMLElement , dragHandle : UndefOr[HTMLElement] = undefined) = this()
  def enable() : Unit = js.native
  def disable() : Unit = js.native

}

object LDraggable {
  
  def apply(el : HTMLElement , dragHandle : UndefOr[HTMLElement] = undefined) = new LDraggable(el,dragHandle)
  
}
