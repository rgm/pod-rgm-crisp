#!/usr/bin/env bb

(ns test-pod
  (:require
   [babashka.pods :as pods]))

(pods/load-pod "./crisp")
(require '[pod.crisp :as crisp])

(let [orig   {:hi "there"}
      frozen (crisp/freeze orig)
      thawed (crisp/thaw frozen)]
  {:orig orig
   :frozen frozen
   :thawed thawed
   :passing (= orig thawed)})

;; vi:ft=clojure
