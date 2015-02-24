package chandu0101.scalajs.facades.examples.pages.common

import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.searchboxes.ReactSearchBox
import japgolly.scalajs.react.vdom.all
import japgolly.scalajs.react.{ReactComponentB, BackendScope}
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js

/**
 * Created by chandrasekharkode .
 */

object ExampleLeftNav {

  case class Menu(text: String, route: String)

  trait Style {

    def leftNav: TagMod = Seq[TagMod](display := "flex", flexDirection := "column")

    def menuItem: TagMod = Seq(
      lineHeight2 := "48px",
      padding := "0 25px",
      color := "rgb(160, 156, 156)",
      fontSize := "15px",
      textDecoration := "none"
    )

    def selectedMenuItem: TagMod = Seq(
      color := "rgb(234, 224, 119)",
      fontWeight := 500
    )

    def menuItemHover: TagMod = Seq(color := "#555555",
      backgroundColor := "#ecf0f1")

  }


  case class State(hoveredItem: String = "" ,menu : List[ExampleLeftNav.Menu] )

  class Backend(t: BackendScope[Props, State]) {

    def onMouseEnter(item: String) = {
      t.modState(_.copy(hoveredItem = item))
    }

    def onMouseLeave = {
      t.modState(_.copy(hoveredItem = ""))
    }
    
    def onTextChange(txt : String) = {
      val newMenu = t.props.menu.filter(m => m.text.toLowerCase.contains(txt.toLowerCase))
      t.modState(_.copy(menu = newMenu))
    }

  }
  
  object SearchBoxStyle extends ReactSearchBox.Style {
    override def searchBox: all.TagMod = super.searchBox.+(width := "100%")

    override def searchInput: all.TagMod = super.searchInput.+(Seq(width := "100%" ,color := "rgb(203, 200, 200)",padding := "7px"))

    override def searchInputFocus: all.TagMod = super.searchInputFocus
  }

  val component = ReactComponentB[Props]("ExampleLeftNav")
    .initialStateP(p => State(menu = p.menu))
    .backend(new Backend(_))
    .render((P, S, B) => {
    div(P.style.leftNav)(
      a(href := "#" , color := "pink", textAlignCenter,textDecoration := "none", "Home",paddingBottom := "20px"),
      ReactSearchBox(onTextChange = B.onTextChange ,style = SearchBoxStyle),
      S.menu.map { item => {
        val selected = item.text == P.selectedItem
        val hover = S.hoveredItem == item.text
        a(key := item.text, P.style.menuItem, selected ?= P.style.selectedMenuItem,
          hover ?= P.style.menuItemHover)(
            onMouseEnter --> B.onMouseEnter(item.text),
            onMouseOut --> B.onMouseLeave)(href := item.route)(item.text)
      }
      }
    )
  })
    .build


  case class Props(menu: List[Menu], selectedItem: String, style: Style)


  def apply(menu: List[Menu], selectedItem: String = "", style: Style = new Style {}, ref: js.UndefOr[String] = "", key: js.Any = {}) = component.set(key, ref)(Props(menu, selectedItem, style))


}

