;; namespace for leinengen
(ns password-reader.core
  (:require [clojure.java.io :as io]
            [clojure.string :as str])
  (:gen-class))

;; open a seq containing the contents of `file-path`
(defn read-passwd-file [file-path]
  (with-open [reader (io/reader file-path)]
    (doall (line-seq reader))))

;; parse the seq, splitting by `:` char
(defn parse-passwd-line [line]
  (let [fields (str/split line #":")]
    (last fields)))

;; map the count of lines 
(defn count-login-shells [passwd-lines]
  (->> passwd-lines
       (map parse-passwd-line)
       (frequencies)))

;; print and format output from gathered information
(defn print-login-shells [login-shells]
  (doseq [[shell count] login-shells]
    (println (str "Shell: " shell ", Count: " count))))

;; main() function "the meat n potatoes"
(defn -main
  "run the function"
  [& args]
  (let [passwd-file-path "passwd"
        passwd-lines (read-passwd-file passwd-file-path)
        login-shells (count-login-shells passwd-lines)]
    (print-login-shells login-shells)))

;; run main (for repl and testing)
(-main)
