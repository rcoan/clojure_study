(ns collections.aula3
  (:require [collections.db :as l.db]))

(defn item-total
  [[_ detail]]
  (* (get detail :quantidade 0) (get detail :preco-unitario 0)))

(defn order-total
  [order]
  (->> order
       (map item-total)
       (reduce +)))

(defn orders-total
  [orders]
  (->> orders
       (map :itens)
       (map order-total)
       (reduce +)))

(defn total-map
  [[user orders]]
  { :user-id user
   :qtd (count orders)
   :preco-total (orders-total orders)})

(->> (l.db/todos-pedidos)
     (group-by :usuario)
     (map total-map)
     println)