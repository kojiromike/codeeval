; # Problem
;
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
;
;
; # Approach
;
; If n >= x to begin with, we are trivially done.
;
; If x is a multiple of n, we are done.
;
; Given a binary representation of both numbers and the fact that the n number is a power of two
; any binary number with ones at or above the exponent of n and all lower-order bits zero will
; be a multiple of n. (For example if n is 16, 10000, then 100000 is 32, 110000 is 48, etc.)
;
; So we clear the bits of x less than n. This makes a value smaller than x, but not less than or
; equal to n because we already eliminated n >= x, and not smaller than x by a margin of n because
; we only eliminated bits at a lower order than n's exponent. Thus, adding n back to this result
; guarantees the smallest multiple of n greater than x.
;

; n divides x if all bits of x less than the exponent of n are zero.
; 1. Isolate the least significant 1-bit of x. If it's less than n, x is not a multiple of n.
(defn n-divides-x?
  "Test whether x is a multiple of n. n is a power of two. Don't use modulo."
  [x n]
  (<= n (bit-and x (- x))))

; n - 1 is a number with all ones lower-order than n's exponent. x OR that number _sets_ all those
; bits on x. This is equivalent to adding (n - 1) to (x with lower order bits cleared), so adding
; 1 to this result is equivalent to adding n to (x with lower order bits cleared).
(defn clear-lower-order-add-n
  "Set all bits less than some power of two to zero, and set the bit at that power of two"
  [x n]
  (+ 1 (bit-or x (- n 1))))

(defn smallest-multiple-gte
  "Return the smallest multiple of n greater than or equal to x."
  [x n]
  (cond
    (> n x) n
    (n-divides-x? x n) x
    :else (+ n (clear-lower-order-add-n x n))))

(print (smallest-multiple-gte 11 4)) ; 12
(print "\n")
(print (smallest-multiple-gte 8 8)) ; 8
(print "\n")
(print (smallest-multiple-gte 1 4)) ; 4
(print "\n")
(print (smallest-multiple-gte 90 16)) ; 96
(print "\n")

; (with-open [rdr (clojure.java.io/reader (first *command-line-args*))]
;   (doseq [line (remove empty? (line-seq rdr))]
;     (do-something-with line)))
