(ns ecommerce.aula1e2
  (:use clojure.pprint)
  (:require [datomic.api :as d]
            [ecommerce.db :as db]
            [ecommerce.model :as model]))

(def conn (db/abre-conexao))

(pprint (db/cria-schema conn))

(pprint (let [computador (model/novo-produto "Computador Novo", "/computador_novo", 2500.10M)]
          (d/transact conn [computador])))

(defn db []
  (d/db conn))

(d/q '[:find ?entidade
       :where [?entidade :produto/nome]] (db))


(pprint (let [computador (model/novo-produto "Celular caro", "/celular_caro", 5500.10M)]
          (d/transact conn [computador])))


(d/q '[:find ?entidade
       :where [?entidade :produto/nome]] (db))


(let [celular-barato (model/novo-produto "Celular Barato", "/celular-barato", 8888.10M)
      resultado @(d/transact conn [celular-barato])
      id-entidade (-> resultado :tempids vals first)]
  (pprint resultado)
  (pprint @(d/transact conn [[:db/add id-entidade :produto/preco 0.1M]]))
  (pprint @(d/transact conn [[:db/retract id-entidade :produto/slug "/celular-barato"]])))

(db/apaga-banco)