(ns HelpAndGreet
  (:require [clojure.string :as s])
  (:import (net.dv8tion.jda.core.events.guild.member GuildMemberJoinEvent)))



(gen-class
  :implements [com.proactiveapathy.SlalomGamingBot.plugins.PluginInterface]

  :name "com.proactiveapathy.SlalomGamingBot.plugins.HelpAndGreet")



(def bot (atom ()))
(def help-text (atom ()))

(def reg #"\!(?i)(help)( )?(\w+)?(.*)")


(defn -init [_]
  (reset! help-text (into {} (map (fn [[k v]] [(second (s/split k #"-")) v])) (filter #(s/starts-with? (first %) "help-") (into {} (.getIniMap @bot "Help")))))
  )

(defn -setInterface [_ b]
  (reset! bot b))

(defn -wantsMessage [_ mess]
  (if (re-matches reg (s/lower-case (.getMessageString mess)))
    true
    false
    )
  )


(defn sendDM [m s]
  (.queue (.sendMessage (.complete (.openPrivateChannel m)) s)))


(defn -processMessage [_ mess]

  (let [g (re-matches reg (.getMessageString mess))
        ;command (s/lower-case (nth g 1))
        topic (s/lower-case (some identity [(nth g 3) "about"]))
        user (-> mess .getMessage .getAuthor)
        ]
    (sendDM user (if (contains? @help-text topic)
                                      (get @help-text topic)
                                      "I don't know about that topic.   Please try !help"))
    )
  )

(defn -wantsEvent [_ evt]
  (cond
    (= evt GuildMemberJoinEvent) true
    :default false)
  )

(defn -processEvent [_ evt]
  (sendDM (.getUser evt) (get @help-text "about"))
  )



