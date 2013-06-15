(ns hatebu-book.core
  (:require [clojure.xml :as xml])
  (:import java.util.Date))

(def ^:const ^:private hatebu-urls {:top "http://feeds.feedburner.com/hatena/b/hotentry"
                                    :general "http://b.hatena.ne.jp/hotentry.rss?mode=general"
                                    :social "http://b.hatena.ne.jp/hotentry/social.rss"
                                    :eco "http://b.hatena.ne.jp/hotentry/economics.rss"
                                    :life "http://b.hatena.ne.jp/hotentry/life.rss"
                                    :entertaiment "http://b.hatena.ne.jp/hotentry/entertainment.rss"
                                    :knowledge "http://b.hatena.ne.jp/hotentry/knowledge.rss"
                                    :it "http://b.hatena.ne.jp/hotentry/it.rss"
                                    :game "http://b.hatena.ne.jp/hotentry/game.rss"
                                    :fun "http://b.hatena.ne.jp/hotentry/fun.rss"})

(defn now []
  (.getTime (Date.)))

(def cache (atom {:time (now)}))

(defn- expired-cache-time? []
  (let [n (- (now)(:time @cache))]
    (> n 900000))) ;;15min

(defn- get-item-tag-elems [elems]
  (filter #(= :item (:tag %)) elems))

(defn- convert-elem [item]
  (->> (:content item)
       (map (fn [{key :tag val :content}][key (first val)]))
       (into {})))

(defn- select-elem [item-elem]
  (select-keys item-elem [:hatena:bookmarkcount :link :title]))

(defn- get-rss-item-elems [[k url]]
  (as-> (:content (xml/parse url)) x
        (get-item-tag-elems x)
        (map convert-elem x)
        (map select-elem x)
        {k x}))

(defn get-hatebu []
  (if (or (expired-cache-time?)(nil? (:ret @cache)))
    (do (reset! cache {:time (now) :ret (reduce merge (pmap get-rss-item-elems hatebu-urls))})
        (:ret @cache))
    (:ret @cache)))
