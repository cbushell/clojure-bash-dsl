(ns clojure-dsl.core)

(defmulti emit-bash
    (fn [from]
          (class from)))

(defmethod emit-bash
    clojure.lang.PersistentList
    [from]
    (case (name (first from))
          "println" (str "echo " (second from))))

(defmethod emit-bash
    java.lang.String
    [from]
    from)

(defmethod emit-bash
    java.lang.Integer
    [from]
    (str from))

(defmethod emit-bash
    java.lang.Double
    [from]
    (str from))
