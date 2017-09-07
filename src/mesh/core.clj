(ns mesh.core)

(defn create-grid
  [{:keys [height width]}]
  (vec
   (for [x (range height)]
     (mapv (fn [y]
             {:x x
              :y y})
           (range width)))))

(defn get-cell
  ([grid x y]
   (-> grid (nth x) (nth y)))
  ([grid {:keys [x y]}]
   (get-cell grid x y)))

(defn update-cell
  ([grid x y update-fn]
   (update-in grid [x y] update-fn))
  ([grid {:keys [x y]} update-fn]
   (update-cell grid x y update-fn)))

(defn get-row
  [grid y]
  (mapv #(get % 0) grid))

(defn get-column
  [grid x]
  (get grid x))
