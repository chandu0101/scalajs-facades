package chandu0101.scalajs.facades.examples.pages.common

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom
import org.scalajs.dom.ext.PimpedNodeList

import scala.scalajs.js

/**
 * Created by chandrasekharkode .
 */
object CodeExample {


  object Style {

    val pageBodyContent = Seq( borderRadius := "2px" ,
      
      boxShadow := "0 1px 4px rgba(223, 228, 228, 0.79)" ,
      maxWidth := "1024px" )

    val contentDemo = Seq(padding := "30px",
     fontSize := "14px"
    )

    val contentCode =Seq( borderTop := "solid 1px #8B8888" ,
      padding := "20px"
    )

  }

  val component = ReactComponentB[Props]("codeexample")
    .render((P,C) => {
       div(Style.pageBodyContent)(
         div(Style.contentDemo ,key := "dan" )(
           C
         ),
         pre(Style.contentCode ,key := "code")(
          code(P.code)
         )
       )
    })
    .configure(installSyntaxHighlighting)
    .build

  def installSyntaxHighlighting[P, S, B] =
    (_: ReactComponentB[P, S, B])
      .componentDidMount(_ => applySyntaxHighlight())
      .componentDidUpdate((_,_,_)  => applySyntaxHighlight())

  def applySyntaxHighlight() = {
    import scala.scalajs.js.Dynamic.{global => g}
    val nodeList = dom.document.querySelectorAll("pre code").toArray
    nodeList.foreach( n => g.hljs.highlightBlock(n))
  }
  case class Props(code: String)

  def apply(code: String ,ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactNode *) = component.set(key,ref)(Props(code),children)

}
