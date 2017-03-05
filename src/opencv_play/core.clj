(ns opencv-play.core
  (:gen-class))

(import [com.atul.JavaOpenCV Imshow])
(import [org.opencv.video Video])
(import [org.opencv.videoio VideoCapture])
(import [org.opencv.core Mat CvType])

(def is (Imshow. "VLADLINK"))
(def buffer (Mat. 512 512 CvType/CV_8UC3))
(def mask (Mat. 512 512 CvType/CV_8UC3))
(def stream (VideoCapture. "http://109.126.0.19:8080/rtsp/24237/0b1d2081e11b0b3435a6?start=0"))
(def fgbg (Video/createBackgroundSubtractorMOG2))
(defn frame [buffer mask] (.apply fgbg buffer mask))

(defn -main []
  (println "Starting")
  (while true (do 
    (.read stream buffer)
    (println "Got image")
    (frame buffer mask)
    (println "Made frame")
    (.showImage is mask)))
  (println "Done"))
