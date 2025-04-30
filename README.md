# trackingpixel
# Steps to run app
# Unable to capture the forwarded recipient email. I didn't find any right approach due security.

1.Run the app in your IDE or terminal.

2.Visit in postman:
http://localhost:8080/recipient/pixel/url?email=abc@gmail.com
→ Copy the generated <img src="..."> snippet.
<img src='http://localhost:8080/pixel.png?id=8e2baf2d-d0ff-44e6-8510-ce2ead83aa4b' width='1' height='1' style='display:none;' />

3.Paste it into the body of an email and send it to any Gmail recipient.

4.Open the email and click the link; the pixel request will record the open event..

5.Check logs:
http://localhost:8080/events
→ You'll see time, IP, location, and user agent.

6. Check logs for perticular pixel id
http://localhost:8080/events/{pixelId} //8e2baf2d-d0ff-44e6-8510-ce2ead83aa4b
