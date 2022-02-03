(ns dijkstra.core
  (:use clojure.pprint)
  (:require [dijkstra.models.vertex :as m.vertex]
            [dijkstra.models.graph :as m.graph]
            [dijkstra.services.algorithm :as s.algorithm]))

(def graph (let [vertex-beginning (m.vertex/new-vertex :beginning {:a 6, :b 2})
                 vertex-a (m.vertex/new-vertex :a {:end 1})
                 vertex-b (m.vertex/new-vertex :b {:a 3, :end 5})
                 vertex-end (m.vertex/new-vertex :end {})]
             (m.graph/new-graph [vertex-beginning vertex-a vertex-b vertex-end])))

(pprint (s.algorithm/find-graph-shortest-path graph))