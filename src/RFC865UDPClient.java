import java.net.*;

// Name: Tay Jovan
// Group: SCSC
// IP Address: 10.96.184.167

public class RFC865UDPClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        
        try {
            // Create a datagram socket
            socket = new DatagramSocket();

            // Specify the server address and port (lab address and port 17)
            // InetAddress serverAddress = InetAddress.getByName("localhost");  //alternative        
            InetAddress localhost = InetAddress.getLocalHost();
            InetAddress lab_ip_address = InetAddress.getByName("swlab2-c.scse.ntu.edu.sg");
            InetAddress serverAddress = lab_ip_address;
            int serverPort = 17;

            // Create a request message (empty in this case)
            String message = "TAY JOVAN, SCSC, " + localhost.getHostAddress();
            System.out.println("Message: " + message);
            byte[] requestData = message.getBytes();

            // Create a request packet
            DatagramPacket requestPacket = new DatagramPacket(requestData, requestData.length, serverAddress, serverPort);

            // Send the request to the server
            socket.send(requestPacket);
            System.out.println("Packet sent\nWaiting response...");

            // Receive the response from the server
            byte[] responseData = new byte[256];
            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length);
            socket.receive(responsePacket);
            System.out.println("Received response");

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
