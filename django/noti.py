#!/usr/bin/python3

import pusher

pusher_client = pusher.Pusher(
  app_id='519012',
  key='8d89288291f4357868aa',
  secret='e6ca82cf1ead2dd5ebbe',
  cluster='ap1',
  ssl=True
)

#pusher_client.trigger('my-channel', 'my-event', {'message': 'hello world'})
pusher_client.trigger('capstone', 'my-event', {'message': 'Object Detecting!'})