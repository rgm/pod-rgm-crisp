(ns crisp.main
  (:require
   [clojure.string :as string]
   [pod-racer.core :as pod]
   [taoensso.nippy :as nippy])
  (:gen-class))

(set! *warn-on-reflection* true)

(defn- dedent
  [indent string]
  (let [pattern (re-pattern (str "^" indent))]
    (->> (string/split string #"\n")
         (map #(string/replace % pattern ""))
         (string/join "\n"))))

(defn print-and-exit
  [{:keys [help exit]}]
  (println help)
  (System/exit exit))

(def pod-config
  {:pod/namespaces
   [{:pod/ns "pod.crisp"
     :pod/vars [{:var/name "freeze" :var/fn nippy/freeze-to-string}
                {:var/name "thaw"   :var/fn nippy/thaw-from-string}]}]})

(def help
  (dedent
   "    "
   "Babashka pod to serialize/deserialize nippy data.

    Use `pod.crisp/freeze` or `pod.crisp/thaw` from a babashka script."))

(defn -main [& _]
  (if (System/getenv "BABASHKA_POD")
    (pod/launch pod-config)
    (print-and-exit {:help help :exit 1})))
