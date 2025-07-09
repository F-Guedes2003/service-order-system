(ns ordem-pedidos.core
  (:gen-class)
  (:require 
   [reitit.ring :as ring]
   [ordem-pedidos.routes :as routes]
   [ring.adapter.jetty :as jetty]))

(def app 
  (ring/ring-handler routes/router))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (jetty/run-jetty app {:port 8080}))
