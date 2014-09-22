(ns raku.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [hiccup.core :refer :all]
            [dieter.core :refer [asset-pipeline]]))

(defn link [url label]
  [:a {:href url} label])

(defn layout [body]
  [:body
    [:link {:rel "stylesheet" :href "/assets/main.scss"}]
    [:script {:src "/assets/main.coffee"}]
    [:div {:class "main"} [:div {:class "topbar"}
      (link "/" "Home")
      (link "/1" "One")
      (link "/2" "Two")
      (link "/3" "Three")]
     [:div {:class "body"} body]]
  ])

(defroutes app-routes
  (GET "/" []
       (html (layout [:span "Hello there"]))
       )
  (GET "/:id" [id :as req]
       (html (layout [:div
              [:ul
               (map (fn [x] [:li [:strong (key x)] ": " (str (val x))]) (req :headers))]
              ]))
       )
  (route/resources "/")
  (route/not-found "Not Found"))

(def app (->
  (handler/site app-routes)
  (asset-pipeline {})
))
