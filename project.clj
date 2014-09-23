(defproject raku "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [hiccup "1.0.5"]
                 [dieter "0.4.1"]
                 [org.clojars.fasterthanlime/dieter-sass "0.0.1"]
                 [org.clojure/clojurescript "0.0-2342"]]
  :plugins [[lein-ring "0.8.11"]
            [lein-cljsbuild "1.0.3"]]
  :cljsbuild {
    :builds [{
       :source-paths ["resources/scripts"]
       :compiler {
          :output-to "resources/assets/main.js"
          :optimizations :whitespace
          :pretty-print true}}]}
  :ring {:handler raku.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
