(ns hatebu-book.view
  (:use [hiccup core page form]))

(defn index []
  {:status 200
   :headers {"Content-Type" "text/html; charset=utf-8"}
   :body
    (html5 {:lang "ja"}
    [:head
     [:meta {"http-equiv" "X-UA-Compatible", "content" "IE=edge,chrome=1"}]
     [:meta {"name" "viewport", "content" "width=device-width, initial-scale=1.0" }]
     [:meta {"http-equiv" "Content-Type", "content" "text/html; charset=utf-8"}]
     [:meta {"name" "description", "content" "本をめくるように、はてブを見る"}]
     [:meta {"name" "keywords","content" "はてぶ,はてブ,はてなブックマーク"}]
      [:title "はてぶBOOK"]
     (include-css "css/jquery.jscrollpane.custom.css" "css/bookblock.css" "css/custom.css")
     (include-js "js/modernizr.custom.79639.js")
     ]
    [:body
     [:div#container.container
      [:div.menu-panel
       [:h3 [:a {:href "/"} "はてぶBOOK"]]
       [:ul#menu-toc.menu-toc
        [:li.menu-toc-current [:a {:href "#item1"} "トップ"]]
        [:li [:a {:href "#item2"} "総合"]]
        [:li [:a {:href "#item3"} "世の中"]]
        [:li [:a {:href "#item4"} "政治と経済"]]
        [:li [:a {:href "#item5"} "暮らし"]]
        [:li [:a {:href "#item6"} "学び"]]
        [:li [:a {:href "#item7"} "テクノロジー"]]
        [:li [:a {:href "#item8"} "エンタメ"]]
        [:li [:a {:href "#item9"} "アニメとゲーム"]]
        [:li [:a {:href "#item10"} "おもしろ"]]
        [:li [:a {:href "#item11"} "いろいろ"]]]]
      [:div.bb-custom-wrapper
       [:div#bb-bookblock.bb-bookblock
        [:div#item1.bb-item [:div.content [:div.scroller [:h2#top "トップ"]]]]
        [:div#item2.bb-item [:div.content [:div.scroller [:h2#general "総合"]]]]
        [:div#item3.bb-item [:div.content [:div.scroller [:h2#social "世の中"]]]]
        [:div#item4.bb-item [:div.content [:div.scroller [:h2#eco "政治と経済"]]]]
        [:div#item5.bb-item [:div.content [:div.scroller [:h2#life "暮らし"]]]]
        [:div#item6.bb-item [:div.content [:div.scroller [:h2#knowledge "学び"]]]]
        [:div#item7.bb-item [:div.content [:div.scroller [:h2#it "テクノロジー"]]]]
        [:div#item8.bb-item [:div.content [:div.scroller [:h2#entertaiment "エンタメ"]]]]
        [:div#item9.bb-item [:div.content [:div.scroller [:h2#game "アニメとゲーム"]]]]
        [:div#item10.bb-item [:div.content [:div.scroller [:h2#fun "おもしろ"]]]]
        [:div#item11.bb-item
         [:div.content
          [:div.scroller
           [:h2#some "いろいろ"]
           [:p "めも1　キーボードの矢印でページめくりができます"]
           [:p "めも2　キーボードの「v」でメニューバーの表示・非表示ができます"]
           [:p "お世話になっているサイト　" [:a.site-link {:href "http://b.hatena.ne.jp/" :target "_blank"} "はてなブックマーク"]]
           [:p "お世話になっているプラットフォーム　" [:a.site-link {:href "https://www.heroku.com/" :target "_blank"} "Heroku"]]
           [:p "お世話になっている言語　" [:a.site-link {:href "http://clojure.org/" :target "_blank"} "Clojure"]]
           [:p "ソースコード　" [:a.site-link {:href "https://github.com/hiroftp/hatebu-book" :target "_blank"} "GitHub"]]
           [:p "作った人　" [:a.site-link {:href "https://twitter.com/hiroftp" :target "_blank"} "@hiroftp　"]
                           [:a.site-link {:href "http://instagram.com/hiroftp" :target "_blank"} "ねこー！"]]
           [:br] [:br]
           [:div#footer [:a {:href "/"} "はてぶBOOK"]]
           ]]
        ]
       [:nav
        [:span#bb-nav-prev "◀"]
        [:span#bb-nav-next "▶"]]
       [:span#tblcontents.menu-button "Table of Contents"]
       ]
      ]
     (include-js
      "http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"
      "js/jquery.mousewheel.min.js"
      "http://cdnjs.cloudflare.com/ajax/libs/jScrollPane/2.0.14/jquery.jscrollpane.min.js"
      "js/jquerypp.custom.min.js"
      "js/jquery.bookblock.min.js"
      "js/page.js")
      "<script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','//www.google-analytics.com/analytics.js','ga');ga('create', 'UA-41776305-1', 'herokuapp.com');ga('send', 'pageview'); </script>"
      ]
     ]
    )
  }
)
