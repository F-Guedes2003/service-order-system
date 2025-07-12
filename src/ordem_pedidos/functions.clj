(ns ordem-pedidos.functions
  (:require
   [ordem-pedidos.comum-handler :as handler]
   [ordem-pedidos.producer :as producer]))

(defn producer-test
  "Function to check if the kafka producer is working"
  [req]
  (try
    (let [body-params (:body-params req)
          msg (:msg body-params)
          _ (prn msg)]
      (producer/write-to "teste.teste" "" msg)
      (handler/http-200-handler "Mensagem escrita no tópico com sucesso!")) 
    (catch Exception e
      (prn e))))

(defn hello-fun
  "Function to check the api is working"
  [_]
  (handler/http-200-handler "hello world"))