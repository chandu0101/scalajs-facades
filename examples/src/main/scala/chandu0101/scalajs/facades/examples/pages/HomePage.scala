package chandu0101.scalajs.facades.examples.pages


import chandu0101.scalajs.facades.examples.routes.AppRouter.AppPage
import chandu0101.scalajs.facades.examples.routes.AppRouter.AppPage._
import chandu0101.scalajs.react.components.mixins.AsyncLoad
import chandu0101.scalajs.react.components.util.MTypes
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scala.scalajs.js
import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._


/**
 * Created by chandrasekharkode .
 */
object HomePage {

  
  object Style {
    
    def content = Seq(display := "flex",
      flexWrap := "wrap",
      padding := "30px"
    )
    def item = Seq(width := "250px" ,
      boxShadow := "0px 2px 4px rgb(155, 83, 71)",
      display := "flex",
      height := "250px",
      cursor := "pointer",
      color := "white",
       textDecoration := "none",
      flexDirection := "column",
      alignItems := "center",
      margin := "20px"
    )
    
    def itemTitle = Seq(background := "rgb(240, 176, 10)",
     border := "1px solid gray",
     textAlignCenter,
     width := "100%",
    lineHeight2 := "40px"
    )
    
    def itemHover = Seq(boxShadow := "0px 8px 14px rgb(240, 176, 10)")
  }

  
  case class Library(name : String, description : String ,route : String)
  
  case class State(hover: String = "")

  class Backend(t: BackendScope[_, State]) {

   def onMouseEnter(name : String) = t.modState(_.copy(hover = name))
    
   def onMouseLeave = t.modState(_.copy(hover = ""))
//    this.getClass.getR
  }

  lazy val libraries  = List(
   Library(name = "PouchDB" ,description = "Database that syncs." ,route = pInfo.path.value ),
   Library(name = "LeafLet" ,description = "Simple and Robust Javascript library for maps on all devices!" ,route = linfo.path.value )

  )
  
  val component = ReactComponentB[Unit]("HomePage")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
     div(Style.content)(
       libraries.map(item => {
          a(Style.item, S.hover==item.name  ?= Style.itemHover,
            href := item.route,
            onMouseEnter --> B.onMouseEnter(item.name) ,
            onMouseLeave --> B.onMouseLeave,
           h3(Style.itemTitle)(item.name),
           p(item.description)
           )
       })
     )
  })
    .buildU

  def apply() = component()
}
