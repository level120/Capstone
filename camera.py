#!/usr/bin/python3
# 'rtsp://210.119.85.77:1554/video1'
# 'rtsp://210.119.85.77:1554/video1s'
# 'rtsp-udp://210.119.85.77:1554/video1'
# 'rtsp-multicast://210.119.85.77:1554/video1'

import cv2
import time
rtsp_url = 'rtsp://210.119.85.77:1554/video1'
video = cv2.VideoCapture(rtsp_url)
time.sleep(0.25)
video.set(cv2.CAP_PROP_FPS, 10)

while(True):
    _, frame = video.read()
    cv2.imshow('HA-20SW', frame)
    cv2.waitKey(1)


capture.release()  
cv2.destroyAllWindows()  
