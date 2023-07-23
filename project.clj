(defproject password-reader "0.1.0-SNAPSHOT"
  :description "password test"
  :url "http://github.com/izder456/password-shell-clj"
  :license {:name "WTFPL"
            :url "https://www.wtfpl.net/"}
  :dependencies [[org.clojure/clojure "1.11.1"]]
  :main ^:skip-aot password-reader.core
  :target-path "target/%s"
  :plugins [[dev.weavejester/lein-cljfmt "0.10.6"]]
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
