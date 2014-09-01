(ns hatebu-book.handler
  (:use compojure.core
        ring.adapter.jetty)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [hatebu-book.core :as core]
            [hatebu-book.view :as view]
            [cheshire.core :as json]))

(defroutes app-routes
  (GET "/" [] (view/index))
  (GET "/hatebu" [] {:status 200
                     :headers {"Content-Type" "application/json; charset=utf-8"}
                     :body (json/generate-string (core/get-hatebu))})
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn -main [& args]
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "8080"))]
    (run-jetty app {:port port})))
