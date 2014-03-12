// @SOURCE:/Users/Johan/Desktop/webshop/conf/routes
// @HASH:a1359a40c229a9d9da69ba318693b0eaa8211b04
// @DATE:Wed Mar 12 12:27:37 CET 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:8
// @LINE:7
class ReverseProductController {
    

// @LINE:8
def getAllProducts(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getAllProducts")
}
                                                

// @LINE:7
def getOneProduct(id:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getOneProduct/" + implicitly[PathBindable[Int]].unbind("id", id))
}
                                                
    
}
                          

// @LINE:11
class ReverseAssets {
    

// @LINE:11
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          
}
                  


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:8
// @LINE:7
class ReverseProductController {
    

// @LINE:8
def getAllProducts : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ProductController.getAllProducts",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllProducts"})
      }
   """
)
                        

// @LINE:7
def getOneProduct : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ProductController.getOneProduct",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getOneProduct/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        
    
}
              

// @LINE:11
class ReverseAssets {
    

// @LINE:11
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:8
// @LINE:7
class ReverseProductController {
    

// @LINE:8
def getAllProducts(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ProductController.getAllProducts(), HandlerDef(this, "controllers.ProductController", "getAllProducts", Seq(), "GET", """""", _prefix + """getAllProducts""")
)
                      

// @LINE:7
def getOneProduct(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ProductController.getOneProduct(id), HandlerDef(this, "controllers.ProductController", "getOneProduct", Seq(classOf[Int]), "GET", """""", _prefix + """getOneProduct/$id<[^/]+>""")
)
                      
    
}
                          

// @LINE:11
class ReverseAssets {
    

// @LINE:11
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          
}
        
    