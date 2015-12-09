; Given numbers x and n, where n is a power of 2, print out the smallest multiple of n which is greater than or equal to x. Do not use division or modulo operator.
; Input sample:
; 
; The first argument will be a path to a filename containing a comma separated list of two integers, one list per line. E.g.
; 
; 13,8
; 17,16
; 
; Output sample:
; 
; Print to stdout, the smallest multiple of n which is greater than or equal to x, one per line. E.g.
; 
; 16
; 32

(defn clear-bits-less-than-n-set-n
  "Set all bits less than some power of two to zero, and set the bit at that power of two"
  [x n]
  (+ 1 (bit-or 
         (- (bit-or x n) n) 
         (- n 1))))

(defn smallest-multiple-gte
  "Return the smallest multiple of n greater than or equal to x."
  [x n]
  (if (> n x) n
    (+ (clear-bits-less-than-n-set-n x n)
       (if (bit-and x n) n 0))))

(print (smallest-multiple-gte 11 4))

; (with-open [rdr (clojure.java.io/reader (first *command-line-args*))]
;   (doseq [line (remove empty? (line-seq rdr))]
;     (do-something-with line)))
