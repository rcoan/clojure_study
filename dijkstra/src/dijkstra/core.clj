(ns dijkstra.core
  (:use clojure.pprint)
  (:require [dijkstra.models.edge :as m.edge]
            [dijkstra.models.vertex :as m.vertex]
            [dijkstra.models.graph :as m.graph]))

(def graph (let [vertex-beginning (m.vertex/new-vertex :beginning {:a 6, :b 2})
                 vertex-a (m.vertex/new-vertex :a {:end 1})
                 vertex-b (m.vertex/new-vertex :b {:a 3, :end 5})
                 vertex-end (m.vertex/new-vertex :end {})]
             (m.graph/new-graph [vertex-beginning vertex-a vertex-b vertex-end])))


(defn nearest-neighbor [vertex]
  (let [vertex-neighbors (:vertex/neighbors vertex)]
    (if (not-empty vertex-neighbors)
      (first (apply min-key second vertex-neighbors)))))


(map nearest-neighbor (:graph/vertices graph))

(defn graph-path
  ([graph] (graph-path (:graph/vertices graph) (:graph/current-path graph)))
  ([vertices current-path]
   (let [current-vertex (first vertices)
         current-vertex-neighbors (:vertex/neighbors current-vertex)]
     (if (not-empty current-vertex-neighbors)
       (->> current-vertex
            nearest-neighbor
            (assoc current-path (:vertex/name current-vertex))
            (recur (next vertices)))
       current-path))))

(defn trace-route
  ([path] (trace-route path [:beginning] :beginning))
  ([path current-route current-node]
   (if current-node
     (let [next-step (current-node path)]
       (recur path (conj current-route next-step) next-step))
     current-route)))

(->> graph
     graph-path
     trace-route
     print)
;(first (apply min-key second a)))