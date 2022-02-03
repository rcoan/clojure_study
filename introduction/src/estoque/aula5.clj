(ns estoque.aula5)

(def estoque {"Mochila"  10
              "Camiseta" 5})

(println estoque)

(println (count estoque))

(println (keys estoque))

(def estoque {:mochila 10
              :camiseta 5})

(println estoque)

(println (count estoque))

(println (keys estoque))

(println (assoc estoque :mochila 1))

(println (update estoque :mochila inc))

(def pedido {:mochila { :quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(println pedido)

(def pedido (assoc pedido :chaveiro {:quantidade 1, :preco 10}))

(println pedido)

(println (get pedido :chaveiro))

(println (:mochila pedido))

(println (:mochil pedido {}))

(println (:quantidade (:mochila pedido)))


(println (update-in pedido [:mochila :quantidade] inc))


(println (-> pedido
             :mochila
             :quantidade))