#!/bin/bash
#./darknet yolo demo cfg/yolov3-tiny.cfg yolov3-tiny.weights rtsp://210.119.85.77:1554/video1 -i 0# -thresh 0.7# -out_filename res.mp4
#./darknet yolo demo cfg/tiny-yolo.cfg yolov2-tiny.weights rtsp://210.119.85.77:1554/video1 -i 0# -thresh 0.7# -out_filename res.mp4
#./darknet yolo demo cfg/yolov2.cfg yolov2.weights rtsp://210.119.85.77:1554/video1 -i 0# -out_filename res.mp4
#./darknet yolo demo cfg/yolov2.cfg yolov2.weights /home/server/Downloads/1.mp4
#./darknet yolo demo cfg/yolov2-tiny.cfg yolov2-tiny.weights /home/server/Downloads/2.mp4
#./darknet detector demo cfg/coco.data cfg/yolov2-tiny.cfg yolov2-tiny.weights /home/server/Downloads/2.mp4
#./darknet detector demo cfg/coco.data cfg/yolov2-tiny.cfg backup/old/yolov2-tiny_40000.weights rtsp://210.119.85.77:1554/video1 -i 0
#./darknet detector demo cfg/coco.data cfg/yolov2-tiny.cfg yolov2-tiny.weights rtsp://210.119.85.78:554/video1 -i 0
./darknet detector demo cfg/coco.data cfg/yolov3-tiny.cfg yolov3-tiny.weights rtsp://210.119.85.78:554/video1 -i 0 -http_port 8090 -dont_show
