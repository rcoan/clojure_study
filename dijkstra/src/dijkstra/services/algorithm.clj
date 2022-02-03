(ns dijkstra.services.algorithm
  (:use clojure.pprint))

(defn- nearest-neighbor [vertex]
  (let [vertex-neighbors (:vertex/neighbors vertex)]
    (if (not-empty vertex-neighbors)
      (first (apply min-key second vertex-neighbors)))))

(defn- graph-path
  ([graph] (graph-path (:graph/vertices graph) (:graph/shortest-path graph)))
  ([vertices current-path]
   (let [current-vertex (first vertices)
         current-vertex-neighbors (:vertex/neighbors current-vertex)]
     (if (not-empty current-vertex-neighbors)
       (->> current-vertex
            nearest-neighbor
            (assoc current-path (:vertex/name current-vertex))
            (recur (next vertices)))
       current-path))))

(defn- trace-route
  ([path] (trace-route path [:beginning] :beginning))
  ([path current-route current-node]
   (if current-node
     (let [next-step (current-node path)]
       (if next-step
         (recur path (conj current-route next-step) next-step)
         current-route)))))

(defn find-graph-shortest-path [graph]
  (->> graph
       graph-path
       trace-route))
