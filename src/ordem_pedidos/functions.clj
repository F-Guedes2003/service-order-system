(ns ordem-pedidos.functions
  (:require
   [ordem-pedidos.comum-handler :as handler]
   [ordem-pedidos.utils :as utils]))

(defn producer-test
  "Function to check if the kafka producer is working"
  [req]
  (let [body-params (:body-params req)
        msg (:msg body-params)]
    (utils/write-to "teste.teste" "" msg))
  (handler/http-200-handler "Mensagem escrita no tópico com sucesso!"))

(defn hello-fun
  "Function to check the api is working"
  [_]
  (handler/http-200-handler "hello world"))