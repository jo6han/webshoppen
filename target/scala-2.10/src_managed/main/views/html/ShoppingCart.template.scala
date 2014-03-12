
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
/* ShoppingCart Template File */
object ShoppingCart extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Any,play.api.templates.HtmlFormat.Appendable] {

    /* ShoppingCart Template File */
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
                    DATE: Wed Mar 12 11:00:29 CET 2014
                    SOURCE: /Users/Johan/Desktop/webshop/app/views/ShoppingCart.scala.html
                    HASH: a418ef90a8988f90b12174ee7ecb1efc3be69081
                    MATRIX: 834->34|940->46
                    LINES: 26->2|29->2
                    -- GENERATED --
                */
            