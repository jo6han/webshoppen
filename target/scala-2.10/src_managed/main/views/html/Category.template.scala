
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/* Category Template File */
object Category extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Any,play.api.templates.HtmlFormat.Appendable] {

    /* Category Template File */
    def apply/*2.2*/(param: Any):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*2.14*/("""
"""))}
    }
    
    def render(param:Any): play.api.templates.HtmlFormat.Appendable = apply(param)
    
    def f:((Any) => play.api.templates.HtmlFormat.Appendable) = (param) => apply(param)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 12 11:00:19 CET 2014
                    SOURCE: /Users/Johan/Desktop/webshop/app/views/Category.scala.html
                    HASH: 0c2e4a41d613760b12199a4523a37e1c6a6af1cc
                    MATRIX: 822->30|928->42
                    LINES: 26->2|29->2
                    -- GENERATED --
                */
            