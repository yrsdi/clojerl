(ns examples.macro)

(def cons (fn* [x s] (clj_core/cons x s)))
(def seq (fn* [s] (clj_core/seq s)))

(def ^:macro defn
  (fn* [form env name args & body]
       (cons 'def
             (cons name
                   [(cons 'fn* (cons args body))]))))

(defn hello [name]
  (io/format "Going to say hi...")
  (io/format "Hello ~s!~n" (seq [name])))

(hello "Moto")
