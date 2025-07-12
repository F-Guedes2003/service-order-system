(ns ordem-pedidos.routes
  (:require
   [reitit.ring :as ring]
   [muuntaja.core :as m]
   [reitit.ring.middleware.muuntaja :as muuntaja]
   [ordem-pedidos.functions :as fun]))

(def router 
  (ring/router 
   ["/api"
    ["/v1"
     ["/producer-test" {:post fun/producer-test}]
     ["/health" {:get fun/hello-fun}]]]
   {:data {:muuntaja m/instance
           :middleware [muuntaja/format-middleware]}}))