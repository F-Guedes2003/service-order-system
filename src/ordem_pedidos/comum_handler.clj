(ns ordem-pedidos.comum-handler)

(defn http-200-handler 
  "Return of a succesful request"
  ([]
   (http-200-handler nil))
  ([response]
  {:status 200 :body {:status 200 :response response}}))