(ns ordem-pedidos.utils
  (:import 
   [java.util Properties]
   [org.apache.kafka.clients.producer ProducerRecord KafkaProducer]))

(def props 
    (doto (Properties.)
      (.put "bootstrap.servers" "localhost:9092")
      (.put "acks" "all")
      (.put "key.serializer" "org.apache.kafka.common.serialization.StringSerializer")
      (.put "value.serializer" "org.apache.kafka.common.serialization.StringSerializer")))

(defn write-to
  "receives a topic, a key(optional) and a value and writes into the kafka topic"
  ([topic value]
   (let [producer (KafkaProducer. props)
         record   (ProducerRecord. topic value)]
     (.send producer record)))
  ([topic key value]
   (let [producer (KafkaProducer. props)
         record   (ProducerRecord. topic key value)]
     (.send producer record))))