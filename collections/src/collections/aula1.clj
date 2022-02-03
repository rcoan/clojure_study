(ns collections.aula1)

(defn cmap
  [func seq]
  (let [first (first seq)]
    (if (not (nil? first))
      (do
        (func first)
        (recur func (rest seq))))))

(cmap println (range 500))