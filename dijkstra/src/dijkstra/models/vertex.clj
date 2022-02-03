(ns dijkstra.models.vertex)


(defn new-vertex [name neighbors]
  {:vertex/name  name
   :vertex/neighbors  neighbors
   :vertex/nearest-neighbor nil})