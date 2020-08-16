(ns poc.main
  (:gen-class)
  (:require
   [medley.core :as medley]
   [malli.core :as m]
   [malli.transform :as mt]
   [malli.error :as me]
   [clojure.string :as str]))



(defn errors->str [errors]
  (cond->> errors
    (map? errors)
    (reduce-kv (fn [errors k [v]]
                 (conj errors (str (name k) ": " v))) [])

    true (str/join "\n")))

(defn- *ask [{:keys [question validation]}]
  (println question)
  (flush)
  (m/decode validation
            (read-line)
            mt/string-transformer))

(defn- process-errors [answer validation]
  (println "Errors:")
  (-> (m/explain validation answer)
      (me/humanize)
      (errors->str)
      println))

(defn ask [{:keys [validation] :as opts}]
  (loop []
    (let [answer (*ask opts)]
      (if-not (m/validate validation answer)
        (do
          (process-errors answer validation)
          (recur))
        answer))))

(defn ask-questions [questions]
  (reduce (fn [answers {:keys [field] :as question}]
            (assoc answers field (ask question))) {} questions))

(def Age [pos-int? {:error/message "Your age must be a positive integer"}])

(def Name [:string {:error/message "You name must contain at leas 3 characters" :min 3}])

(def questions [{:field :name
                    :question "What's your name"
                    :validation Name}
                   {:field :age
                    :question "How old are you?"
                    :validation Age}])

(defn -main [& _]
  (let [{:keys [name age]} (ask-questions questions)]
    (println (format "Hello %s, you are %d years old" name age))))
