(ns dijkstra.models.edge)

(defn new-edge [origin destination weight]
  {:edge/origin  origin
   :edge/destination  destination
   :edge/weight  weight})