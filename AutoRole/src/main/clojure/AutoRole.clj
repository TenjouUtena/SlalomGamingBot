(ns AutoRole
  (:require [clojure.string :as s]))


(gen-class
  :implements [com.proactiveapathy.SlalomGamingBot.plugins.PluginInterface]

  :name "com.proactiveapathy.SlalomGamingBot.plugins.AutoRole")


(def bot (atom ()))
(def valid-roles (atom ()))

(def reg #"\!(?i)(iam|iamnot) (.*)")


(defn -init [_]
      (reset! valid-roles (map #(s/lower-case (s/trim %)) (s/split (.getIni @bot "AutoRole" "roles") #",")))
  (println @valid-roles))

(defn -setInterface [_ b]
      (reset! bot b))

(defn -wantsMessage [_ mess]
      (if (re-matches reg (s/lower-case (.getMessageString mess)))
        true
        false
        )
      )

(defn -wantsEvent [_ _]
  false)

(defn -processEvent [_ _]
  nil)

(defn findRolebyName [guild role]
  (first (filter #(= role (s/lower-case (.getName %))) (.getRoles guild))))

(defn sendMessageWithMention [c m s]
  (.queue (.sendMessage c (str (.getAsMention m) ": " s))))

(defn -processMessage [_ mess]
      (let [g (re-matches reg (.getMessageString mess))
            role (s/lower-case (nth g 2))
            op (s/lower-case (nth g 1))
            c (-> mess .getMessageChannel)
            member (-> mess .getMessage .getMember)
            roleid (findRolebyName (-> mess .getMessage .getGuild) role)]
        (if roleid
          (if (some #(= role %) @valid-roles)
            (case op
              "iam" (do
                      (.queue (.addSingleRoleToMember (-> mess .getMessage .getGuild .getController) member roleid))
                      (sendMessageWithMention c member (str "Added role " (.getName roleid))))
              "iamnot" (do
                         (.queue (.removeSingleRoleFromMember (-> mess .getMessage .getGuild .getController) member roleid))
                         (sendMessageWithMention c member (str "Removed role " (.getName roleid)))))
            (sendMessageWithMention c member "I'm not allowed to manage that role."))
          (sendMessageWithMention c member "I could not find the role you want to add."))))


