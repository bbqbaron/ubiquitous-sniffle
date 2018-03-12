(ns reveal.slides)

(defn make-ul [title items]
  [:section
    [:h4 title]
    [:ul
      (map (fn [i] [:li i]) items)]])

(defn make-table [headers rows]
  [:table {:style "font-size:36px"}
    [:thead
      [:tr
        (map (fn [i] [:th i]) headers)]]
    [:tbody
      (map
         (fn [row] [:tr (map (fn [i] [:td i]) row)])
         rows)]])

(def title
  [:section
    [:h1 "The Joy of Clojure"]
    [:h2 "A case study"]])
   
(def me
  [:section
    [:h1 "About Me"]
    [:ul
      [:li "Hobby clojurist"]
      [:li "Language dork"]
      [:li "Web developer"]
      [:li "Pedant"]]])

(def about-slides
  [:section
    [:h2 "About These Slides"]
    [:ul
      [:li "Also in Clojurescript"]
      [:li "Obviously with Reveal. Are there cooler slide decks these days?"]
      [:li "Tables for layout :|"]]])

(def translate
  [:section
    [:h5 "Let's Translate Some Hyperbole"]
    [:p "A prefatory guide to Ericisms"]
    [:table {:style "font-size:36px"}
      [:thead
        [:tr
          [:th "I say"]
          [:th "I mean"]]]
      [:tbody
        (map (fn [[a b]]
              [:tr
                [:td a]
                [:td b]])
          [
            ["My personal god! The pinnacle of [X]!" "My most recent experience was pleasant"]
            ["Only an idiot..." "I personally am not good at thinking this way"]
            ["Duh, yes, we know" "This is a part of my narrow personal experience"]
            ["Garbage!" "I do not enjoy this/it's not for me"]
            ["I hate Java" "I _really_ hate Java"]])]]])

(def cljs
  [:section
    [:h2 "Clojurescript"]
    [:ul
      [:li "Dialect of lisp"]
      [:li "Transpiles to JS"]
      [:li "Cousin to the Java-based Clojure"]]])

(def cljs-to-js
  (make-ul "Why CLJS?"
    [
     "Sweet features carefully designed"
     "Fewer deps"
     "Structural simplicity of lisp"
     "Code-sharing with JVM Clojure"
     "Whimsical package names"
     "Structural editing zomg"]))

(def hoare
  [:section
    [:h5 "Unfounded assertion"]
    [:p "The aggregate cost of trying to make the entire JS ball of mud work together will eventually put Tony Hoare's mind at ease."]])

(def fewer-deps
  [:section
    (make-table
      ["JS" "CLJS"]          
      [
       ["Immutable.js" [:code "(assoc thing :key \"a value!\")"]]
       ["JSX" [:code "[:div [:p \"hi!\"]]"]]
       ["Redux" [:code "(def some-state (atom {}))"]]])])
       
(def js-extras 
  (make-ul
   "Things You Don't Need"
   ["Lodash"
    "Babel"
    "ES* levels"
    "this."
    "NaN"]))

(def things-you-get
  (make-ul
    "Things You Get"
    ["First-class immutability" "Contracts" "Macros"
     "Small syntax"
     "Protocol-based programming"
     "Built-in transactional memory, CSPs, agents"]))

(def the-real-test
  [:section
    [:h5 "The ultimate test"]
    [:p "Clj(s) always seems to be the way I ultimately get things _done_"]])

(def building
  (make-ul
    "Build tools"
    ["Leiningen (JVM-first)"
      "Boot (JVM-first)"
      "Lumo (more of a repl)"
      "Planck (ditto)"]))
        
(def shadow
  (make-ul "Shadow"
    ["Multi-target"
      "First-class NPM integration"
      "Watch mode"
      "Daemon"
      "File server"
      "I am insanely impatient and it was well within my capacity."]))

(def react
  (make-ul
    "Reactish Things"
    [
      "Reagent"
      "Re-frame"
      "Om"
      "Rum"]))

(def reagent
  (make-ul
    "Reagent"
    [
      "Dead-simple"
      "Basically just React interop"]))
    
(def reframe
  (make-ul
    "Re-frame"
    [
      "Whole state management/reactive/subscriptive enchilada"
      "Insanely cool"
      "I have never used it in anger"]))

(def om
  (make-ul
    "Om"
    ["By David Nolen, king of CLJS"
      "Highly opinionated"
      "Currently incubating in some kind of mad-science mode"]))
    
(def rum
    (make-ul
      "Rum"
      ["React with atoms as state"
       "Asks nothing of you that don't already know"
       "Read: 'you' as 'Eric'"
       "No superstructure, no other deps, no nothing"]))

(def now
    (make-ul
     "Zeit's Now"
     ["CLI-based package deployment service"
      "From creators of Next, Hyper"]))

(def now-desc
    (make-ul
      "Cool qualities"
      ["Immutable deploys with unique URLs"
       "Best CLI ever"
       "Basically no UI"]))

(def now-todo
      (make-ul
        "Not part of Now AFAICT"
        ["Live monitoring?"]))

(defn all
  "Add here all slides you want to see in your presentation."
  []
  [title 
    [:section me about-slides translate]
    [:section cljs cljs-to-js hoare fewer-deps js-extras things-you-get the-real-test]
    [:section building shadow]
    [:section react reagent reframe om rum]
    [:section now now-desc]
    (make-ul "Obligatory summation" ["Certainty impossible" "World spinning helter skelter through space" "Parens surprisingly helpful" "Clojurescript fun"])])