(ns ordem-pedidos.api.producer
  (:require [cheshire.core :as json])
  (:import 
   [java.util Properties]
   [org.apache.kafka.clients.producer ProducerRecord KafkaProducer]
   [org.apache.kafka.common.serialization Serializer Deserializer Serdes]))


(defn json-serializer []
  (reify Serializer
    (configure [_ _ _])
    (close [_])
    (serialize [_ _ data]
      (when data
        (.getBytes (json/generate-string data))))))


(defn json-deserializer []
  (reify Deserializer
    (configure [_ _ _])
    (close [_])
    (deserialize [_ _ data]
      (when data
        (json/parse-string (String. data "UTF-8") true)))))


(def props 
    (doto (Properties.)
      (.put "bootstrap.servers" "localhost:9092")
      (.put "acks" "all")))

(def producer
  (KafkaProducer. props
                  (org.apache.kafka.common.serialization.StringSerializer.)
                  (json-serializer)))


(defn write-to
  "receives a topic, a key(optional) and a value and writes into the kafka topic"
  ([topic value]
   (write-to topic nil value))
  ([topic key value]
   (.send producer (ProducerRecord. topic key value))))


(defn json-serde []
  (Serdes/serdeFrom (json-serializer) (json-deserializer)))