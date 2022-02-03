(ns collections.aula4
  (:require [collections.db :as l.db]
            [collections.logic :as l.logic]))

(let [resumo (l.logic/users-summary (l.db/todos-pedidos))]
  (println resumo)
  (println (sort-by :preco-total resumo))
  (println (reverse (sort-by :preco-total resumo))))
