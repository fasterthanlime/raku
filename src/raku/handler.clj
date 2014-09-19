(ns raku.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/:id" [id :as req]
    (str
      "<div style='width: 900px; margin: 20px auto;'>"
      "<table style='font-family: Helvetica Neue;'>"
      (reduce (fn [n y] (str n "<tr><td style='width: 280px'>" (key y) "</td><td>" (val y) "</td></tr>")) "" req)
      "</table>"
      "</div>"
    )
  )
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
