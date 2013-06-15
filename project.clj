(defproject hatebu-book "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [cheshire "5.1.2"]
                 [hiccup "1.0.3"]
                 [ring/ring-jetty-adapter "1.2.0-beta3"]
                 [org.clojars.mikejs/ring-gzip-middleware "0.1.0-SNAPSHOT"]
                 ]
  :plugins [[lein-ring "0.8.3"]]
  :ring {:handler hatebu-book.handler/app}
  :main hatebu-book.handler
  :profiles {:dev {:dependencies [[ring-mock "0.1.5"]]}})
