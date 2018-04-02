#!/bin/bash
./darknet detector demo ./cfg/coco.data ./cfg/yolov3.cfg ./yolov3.weights http://210.119.85.77:1080/video1 -i 0# -out_filename res.mp4