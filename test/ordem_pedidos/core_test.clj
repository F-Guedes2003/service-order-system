(ns ordem-pedidos.core-test
  (:require [clojure.test :refer :all]
            [ordem-pedidos.core :refer :all]
            [ordem-pedidos.api.functions :as functions]
            [ordem-pedidos.api.comum-handler :as comum-handler]))

(deftest health-test 
  (testing "the health function"
    (is (= {:status 200 :body {:status 200 :response "hello world"}} (functions/hello-fun nil)))))

(deftest http-200-handler-test
  (testing "if http-200-handler is working well"
    (is (= {:status 200 :body {:status 200 :response nil}} (comum-handler/http-200-handler nil)))
    (is (= {:status 200 :body {:status 200 :response "hello world"}} (comum-handler/http-200-handler "hello world")))))

