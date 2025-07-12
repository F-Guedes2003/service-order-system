(defproject ordem-pedidos "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [metosin/reitit "0.9.1"]
                 [ring/ring-core "1.14.2"]
                 [metosin/muuntaja "0.6.11"]
                 [ring/ring-jetty-adapter "1.14.2"]
                 [cc.qbits/alia-all "4.3.7-beta1"]
                 [org.apache.kafka/kafka-clients "3.7.0"]
                 [cheshire "5.11.0"]]
  :main ^:skip-aot ordem-pedidos.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
