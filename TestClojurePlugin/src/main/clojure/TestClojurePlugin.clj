(ns TestClojurePlugin
  )

(gen-class
  :implements [com.proactiveapathy.SlalomGamingBot.plugins.PluginInterface]

  :name "com.proactiveapathy.SlalomGamingBot.plugins.TestClojurePlugin")



(defn -wantsMessage [_ mess]
  (if (re-matches #"\!test" (.getMessageString mess))
    true
    false
    )
  )

(defn -processMessage [_ mess]
  (let [
        c (-> mess .getMessageChannel )]
    (.queue (.sendMessage c "Hello From Clojue!"))))

