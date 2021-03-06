(defproject lambdaisland/uri "1.1.0"
  :description "A pure Clojure/ClojureScript, RFC compliant URI library"
  :url "http://github.com/lambdaisland/uri"
  :license {:name "Mozilla Public License 2.0"
            :url "https://www.mozilla.org/en-US/MPL/2.0/"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/data.json "0.2.6"]]
  :plugins [[lein-doo "0.1.7"]
            [lein-cljsbuild "1.1.5"]
            [lein-mutate "0.1.0"]]
  :doo {:build "test"
        :alias {:default [:phantom]}}
  :cljsbuild {:builds [{:id "test"
                        :source-paths ["src" "test"]
                        :compiler {:output-to "target/testable.js"
                                   :output-dir "target"
                                   :main lambdaisland.test-runner
                                   :optimizations :none}}]}
  :aliases {"test-all" ["do"
                        ["test"]
                        ["doo" "phantom" "test" "once"]]}
  :profiles {:dev
             {:dependencies [[org.clojure/clojurescript "1.9.562"]
                             [com.cemerick/piggieback "0.2.1"]
                             [lein-doo "0.1.7"]
                             ]}
             :codox {:dependencies [[codox-theme-rdash "0.1.2"]]
                     :plugins [[lein-codox "0.10.3"]]
                     :codox {:output-path "gh-pages"
                             :project {:name "lambdaisland-uri"}
                             :metadata {:doc/format :markdown} ;; docstring format
                             :themes [:rdash]}}})
