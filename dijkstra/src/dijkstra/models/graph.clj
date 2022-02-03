(ns dijkstra.models.graph)


(defn new-graph [vertices]
  {:graph/vertices  vertices
   :graph/current-path {}})