(ns collections.aula5
  (:require [collections.db :as l.db]
            [collections.logic :as l.logic]))

(let [resumo (l.logic/users-summary (l.db/todos-pedidos))]
  (println resumo))
