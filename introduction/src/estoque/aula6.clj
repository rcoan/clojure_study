(ns estoque.aula6)

(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(defn imprime [valor]
  (println valor)
  15)
(println (map imprime pedido))

(defn imprime [[chave valor]]
  (println chave "e" valor)
  15)

(println (map imprime pedido))

(defn total-produto [produto]
  (* (:preco produto) (:quantidade produto)))

(println (map preco-por-produto pedido))

(defn total
  [pedido]
  (->> pedido
       vals
       (map total-produto)
       (reduce +)))

(println (total pedido))


(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 0}})

(defn free?
  [item]
  (<= (:preco item 0) 0))

(defn pago?
  [item]
  (not (free? item)))

(println (->> pedido
              vals
              (filter free?)))

(println (->> pedido
              vals
              (filter pago?)))