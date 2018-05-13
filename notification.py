#!/usr/bin/python
#-*- coding: utf-8 -*-
import sys
from time import localtime, strftime

import firebase_admin
from firebase_admin import credentials
from firebase_admin import messaging
from firebase_admin import datetime


def main(datas):
    cred = credentials.Certificate('service-account.json')
    default_app = firebase_admin.initialize_app(cred)
    
    # This registration token comes from the client FCM SDKs.
    #registration_token = 'ANDROID_CLIENT_TOKEN'
    topic = 'capstone'
    message_body = datas[2] + '   Person : ' + datas[0] + ', Accuracy : ' + datas[1]
    message_title = 'Notification!'
    
    # See documentation on defining a message payload.
    message = messaging.Message(
        android=messaging.AndroidConfig(
            ttl=datetime.timedelta(seconds=3600),
            priority='normal',
            notification=messaging.AndroidNotification(
                title=message_title,
                body=message_body,
                icon='',
                color='#f45342',
                sound='default'
            ),
        ),
        data={
            'score': '850',
            'time': '2:45',
        },
        webpush=messaging.WebpushConfig(
            notification=messaging.WebpushNotification(
                title=message_title,
                body=message_body,
                icon='',
            ),
        ),
        topic=topic
        #token=registration_token
    )
    
    # Send a message to the device corresponding to the provided
    # registration token.
    response = messaging.send(message)
    # Response is a message ID string.
    print 'Successfully sent message:', response
  

# person count, accuracy
if __name__ == "__main__":
    main([sys.argv[1], sys.argv[2], strftime("%Y-%m-%d %I:%M:%S", localtime())])