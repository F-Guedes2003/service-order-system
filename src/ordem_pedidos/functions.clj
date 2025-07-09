(ns ordem-pedidos.functions
  (:require
   [ordem-pedidos.comum-handler :as handler]))

(defn hello-fun
  [_]
  (handler/http-200-handler "hello world"))