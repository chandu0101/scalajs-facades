package chandu0101.scalajs.facades.examples

import chandu0101.scalajs.facades.examples.routes.AppRouter
import japgolly.scalajs.react.React
import org.scalajs.dom

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

/**
 * Created by chandrasekharkode .
 */
object ReactApp extends JSApp{
  @JSExport
  override def main(): Unit = {
    React.render(AppRouter.C(),dom.document.getElementById("container"))
    
  }
}
