(defproject opencv-play "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :jvm-opts ["-Djava.library.path=./lib"]
  :resource-paths ["./lib/opencv-310.jar"
                   "./lib/Imshow.jar"]
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :injections [(clojure.lang.RT/loadLibrary org.opencv.core.Core/NATIVE_LIBRARY_NAME)]
  :dependencies [[org.clojure/clojure "1.8.0"] [cider/cider-nrepl "0.9.0-SNAPSHOT"]]
  :main opencv-play.core)
