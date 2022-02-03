(ns dijkstra.models.graph)

(defn new-graph [vertices]
  {:graph/vertices      vertices
   :graph/shortest-path {}})