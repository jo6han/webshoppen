// @SOURCE:/Users/Johan/Desktop/webshop/conf/routes
// @HASH:a1359a40c229a9d9da69ba318693b0eaa8211b04
// @DATE:Wed Mar 12 12:27:37 CET 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_ProductController_getOneProduct1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getOneProduct/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:8
private[this] lazy val controllers_ProductController_getAllProducts2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getAllProducts"))))
        

// @LINE:11
private[this] lazy val controllers_Assets_at3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getOneProduct/$id<[^/]+>""","""controllers.ProductController.getOneProduct(id:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getAllProducts""","""controllers.ProductController.getAllProducts()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_ProductController_getOneProduct1(params) => {
   call(params.fromPath[Int]("id", None)) { (id) =>
        invokeHandler(controllers.ProductController.getOneProduct(id), HandlerDef(this, "controllers.ProductController", "getOneProduct", Seq(classOf[Int]),"GET", """""", Routes.prefix + """getOneProduct/$id<[^/]+>"""))
   }
}
        

// @LINE:8
case controllers_ProductController_getAllProducts2(params) => {
   call { 
        invokeHandler(controllers.ProductController.getAllProducts(), HandlerDef(this, "controllers.ProductController", "getAllProducts", Nil,"GET", """""", Routes.prefix + """getAllProducts"""))
   }
}
        

// @LINE:11
case controllers_Assets_at3(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     