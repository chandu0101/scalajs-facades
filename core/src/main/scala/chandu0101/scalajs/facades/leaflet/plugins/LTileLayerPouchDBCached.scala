package chandu0101.scalajs.facades.leaflet.plugins

import chandu0101.scalajs.facades.leaflet.{LTileLayerOptions, LTileLayer}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
 * Created by chandrasekharkode on 3/3/15.
 */

@JSName("L.TileLayer.PouchDBCached")
class LTileLayerPouchDBCached extends LTileLayer{
  
  def this(url : String ,options : js.UndefOr[LTileLayerOptions] = js.undefined)  = this()
}

object LTileLayerPouchDB {
  
  def apply(url : String ,options : js.UndefOr[LTileLayerOptions] = js.undefined) = new LTileLayerPouchDBCached(url,options)
  
}