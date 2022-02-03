(ns collections.logic)

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
  {:user-id     user
   :qtd         (count orders)
   :preco-total (orders-total orders)})

(defn users-summary
  [orders]
  (->> orders
       (group-by :usuario)
       (map total-map)))