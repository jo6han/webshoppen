
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

<!DOCTYPE html>
<html><head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
	<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
</head><body>
	"""),_display_(Seq[Any](/*9.3*/message)),format.raw/*9.10*/("""
	<div class="container">
	
	
	<a href="/getOneProduct/1">product 1</a><br>
	<a href="/getAllProducts">Alla product</a>
	
	
	</div>
</body></html>
"""))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 12 13:01:18 CET 2014
                    SOURCE: /Users/Johan/Desktop/webshop/app/views/index.scala.html
                    HASH: e176cb7148d3e184031848cfcbe4a5f862d6007b
                    MATRIX: 774->1|885->18|1184->283|1212->290
                    LINES: 26->1|29->1|37->9|37->9
                    -- GENERATED --
                */
            