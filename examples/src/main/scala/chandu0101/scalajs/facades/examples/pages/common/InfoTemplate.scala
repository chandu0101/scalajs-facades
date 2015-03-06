package chandu0101.scalajs.facades.examples.pages.common

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._


/**
 * Created by chandrasekharkode on 3/4/15.
 */
object InfoTemplate {


  val component = ReactComponentB[String]("InfoTemplate")
    .render((P, C) => {
      div(
       C,
       ComponentCredits(P)
      )
    })
    .build
  
  
  def apply(filePath : String)(children : ReactNode*) = component(filePath,children)
}
