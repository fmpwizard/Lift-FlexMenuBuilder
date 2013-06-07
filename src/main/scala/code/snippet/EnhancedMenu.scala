package code
package snippet

import scala.xml.{NodeSeq, Text}
import net.liftweb.http.{DispatchSnippet, S}
import net.liftweb.sitemap.FlexMenuBuilder
import net.liftweb.util._
import net.liftweb.common._

class EnhancedMenu extends FlexMenuBuilder with DispatchSnippet {

  def dispatch = overriddenDispatch orElse net.liftweb.builtin.snippet.Menu.dispatch

  def overriddenDispatch :DispatchIt = {
    case "builder" => i => render
  }


  override def expandAll = true
  override def linkToSelf = true

  override protected def buildInnerTag(contents: NodeSeq, path: Boolean, current: Boolean) = {
    val innerTag = updateForCurrent(updateForPath(<li>{contents}</li>, path), current)
    val innerList = innerTag \\ "ul" // <-- Can't go beyond this because scala.xml.Group barfs.
    /*==============================================*/
    /*= Do something interesting with the innerTag =*/
    /*=  and  return  the mutated  innerTag here.  =*/
    /*==============================================*/
    innerTag
  }

}

