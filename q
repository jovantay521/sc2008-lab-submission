[1mdiff --git a/src/RFC865UDPClient.java b/src/RFC865UDPClient.java[m
[1mindex 52cfa4f..a1a5bf9 100644[m
[1m--- a/src/RFC865UDPClient.java[m
[1m+++ b/src/RFC865UDPClient.java[m
[36m@@ -14,8 +14,9 @@[m [mpublic class RFC865UDPClient {[m
 [m
             // Specify the server address and port (localhost and port 13 in this case)[m
             // InetAddress serverAddress = InetAddress.getByName("localhost");  //alternative        [m
[31m-            InetAddress localhost = InetAddress.getLocalHost();[m
[31m-            InetAddress serverAddress = localhost;[m
[32m+[m[32m            // InetAddress localhost = InetAddress.getLocalHost();[m
[32m+[m[32m            InetAddress LAB_IP = InetAddress.getByName("swlab2-c.scse.ntu.edu.sg");[m
[32m+[m[32m            InetAddress serverAddress = LAB_IP;[m
             int serverPort = 13;[m
 [m
             // Create a request message (empty in this case)[m
