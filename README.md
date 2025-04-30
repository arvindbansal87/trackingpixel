#trackingpixel
#Steps to run app
#Pending - Capturing the email address of a forwarded recipient is not possible due to security restrictions, and no reliable method could be found.
1.Run the app in your IDE or terminal.

2.Visit in postman: http://localhost:8080/recipient/pixel/url?email=abc@gmail.com → Copy the generated code snippet  .

3.Paste it into the body of an email and send it to any Gmail recipient.

4.Open the email and click the link. the pixel request will record the open event.

5.You may also forward the email to another recipient and repeat steps 2 through 4.

6.Check logs: http://localhost:8080/events → You'll see time, IP, location, and user agent.

7.Check logs for perticular pixel id http://localhost:8080/events/{pixelId} //8e2baf2d-d0ff-44e6-8510-ce2ead83aa4b
