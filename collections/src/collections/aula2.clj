(ns collections.aula2)

(defn conta
  [total elements]
  (if (next elements)
    (recur (inc total) (rest elements))
    (inc total)))

(println (conta 0 ["daniela" "gui" "carlos" "paulo" "lucia" "ana"]))


(defn conta
  ([elements] (conta 0 elements))
  ([total elements]
   (if (seq elements)
     (recur (inc total) (rest elements))
     total)))

(println "------")
(println (conta  ["daniela" "gui" "carlos" "paulo" "lucia" "ana"]))
(println (conta []))


(println (conta 1 ["daniela" "gui" "carlos" "paulo" "lucia" "ana"]))

(println (conta 1 []))