(ns clinica.aula1
  (:use clojure.pprint)
  (:require [schema.core :as s]))

(defn adiciona-paciente [pacientes paciente]
  (if-let [id (:id paciente)]
    (assoc pacientes id paciente)
    (throw (ex-info "Paciente não possui id" {:paciente paciente}))))

(defn adiciona-visita
  [visitas, paciente, novas-visitas]
  (if (contains? visitas paciente)
    (update visitas paciente concat novas-visitas)
    (assoc visitas paciente novas-visitas)))

(defn imprime-relatorio-de-pacientes [visitas, paciente]
  (println "Visitas do paciente" paciente "são" (get visitas paciente)))

(defn testa-uso-de-pacientes []
  (let [guilherme {:id 15, :nome "Guilherme"}
        daniela {:id 20, :nome "Daniela"}
        paulo {:id 25, :nome "Paulo"}

        ; uma variação com reduce, mais natural
        pacientes (reduce adiciona-paciente {} [guilherme, daniela, paulo])

        ; uma variação com shadowing, fica feio
        visitas {}
        visitas (adiciona-visita visitas 15 ["01/01/2019"])
        visitas (adiciona-visita visitas 20 ["01/02/2019", "01/01/2020"])
        visitas (adiciona-visita visitas 15 ["01/03/2019"])]
    (pprint pacientes)
    (pprint visitas)
    (imprime-relatorio-de-pacientes visitas 20)
    (println (get visitas 20))))

(testa-uso-de-pacientes)

(s/defn novo-paciente
  [id :- Long, nome :- s/Str]
  { :id id, :nome nome})

(pprint (novo-paciente 15 "Guilherme"))