
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
object allProducts extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[model.Product],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(prodList: List[model.Product]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.33*/("""

Listing all products (Total amont """),_display_(Seq[Any](/*3.36*/prodList/*3.44*/.size())),format.raw/*3.51*/("""):

<ul>
		"""),_display_(Seq[Any](/*6.4*/for(product <- prodList) yield /*6.28*/{_display_(Seq[Any](format.raw/*6.29*/("""
			<a href="/getOneProduct/"""),_display_(Seq[Any](/*7.29*/product/*7.36*/.getProductId)),format.raw/*7.49*/(""""><li>"""),_display_(Seq[Any](/*7.56*/product/*7.63*/.getName())),format.raw/*7.73*/("""</a></li>
		""")))})),format.raw/*8.4*/("""
</ul>"""))}
    }
    
    def render(prodList:List[model.Product]): play.api.templates.HtmlFormat.Appendable = apply(prodList)
    
    def f:((List[model.Product]) => play.api.templates.HtmlFormat.Appendable) = (prodList) => apply(prodList)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 12 12:41:59 CET 2014
                    SOURCE: /Users/Johan/Desktop/webshop/app/views/allProducts.scala.html
                    HASH: d9c778f80d0d9f33542cb4710a37a3e8d4bc89d1
                    MATRIX: 793->1|918->32|990->69|1006->77|1034->84|1080->96|1119->120|1157->121|1221->150|1236->157|1270->170|1312->177|1327->184|1358->194|1401->207
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|35->7|35->7|35->7|35->7|35->7|35->7|36->8
                    -- GENERATED --
                */
            