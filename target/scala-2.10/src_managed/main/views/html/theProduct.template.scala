
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
/**/
object theProduct extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[model.Product,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(prod: model.Product):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.23*/("""


Product name: """),_display_(Seq[Any](/*4.16*/prod/*4.20*/.getName())),format.raw/*4.30*/(""" <br>
Product cost: """),_display_(Seq[Any](/*5.16*/prod/*5.20*/.getCost())))}
    }
    
    def render(prod:model.Product): play.api.templates.HtmlFormat.Appendable = apply(prod)
    
    def f:((model.Product) => play.api.templates.HtmlFormat.Appendable) = (prod) => apply(prod)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 12 12:42:01 CET 2014
                    SOURCE: /Users/Johan/Desktop/webshop/app/views/theProduct.scala.html
                    HASH: 7b88f9f38638f13ea2721b947aae0f0985283a2e
                    MATRIX: 786->1|901->22|954->40|966->44|997->54|1053->75|1065->79
                    LINES: 26->1|29->1|32->4|32->4|32->4|33->5|33->5
                    -- GENERATED --
                */
            