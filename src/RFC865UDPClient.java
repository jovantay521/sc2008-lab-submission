import java.net.*;

// Name: Tay Jovan
// Group: SCSC
// IP Address:  

public class RFC865UDPClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        
        try {
            // Create a datagram socket
            socket = new DatagramSocket();

            // Specify the server address and port (localhost and port 13 in this case)
            // InetAddress serverAddress = InetAddress.getByName("localhost");  //alternative        
            InetAddress localhost = InetAddress.getLocalHost();
            InetAddress serverAddress = localhost;
            int serverPort = 13;

            // Create a request message (empty in this case)
            String message = "TayJovan, SCSC, " + serverAddress.getHostAddress();
            byte[] requestData = message.getBytes();

            // Create a request packet
            DatagramPacket requestPacket = new DatagramPacket(requestData, requestData.length, serverAddress, serverPort);

            // Send the request to the server
            socket.send(requestPacket);

            // Receive the response from the server
            byte[] responseData = new byte[256];
            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length);
            socket.receive(responsePacket);

            // Convert the response data to a string and display it
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Response from server: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
