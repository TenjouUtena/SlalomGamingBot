(ns TestClojurePlugin)

(gen-class
  :implements [com.proactiveapathy.SlalomGamingBot.plugins.PluginInterface]

  :name "com.proactiveapathy.SlalomGamingBot.plugins.TestClojurePlugin")


(def bot (atom ()))
(def channels (atom ()))


(defn -init [_]
  (reset! channels (.getIni @bot "TestClojure" "message")))

(defn -setInterface [_ b]
  (reset! bot b))

(defn -wantsMessage [_ mess]
  (if (re-matches #"\!test" (.getMessageString mess))
    true
    false
    )
  )

(defn -processMessage [_ mess]
  (let [
        c (-> mess .getMessageChannel )]
    (.queue (.sendMessage c (str "Hello From Clojure! " @channels)))))

