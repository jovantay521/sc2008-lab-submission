import java.net.*;

public class RFC865UDPServer {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            // Create a datagram socket bound to port 13 (RFC 865 uses port 13)
            socket = new DatagramSocket(13);
            System.out.println("Server listening on port 13...");

            while (true) {
                byte[] buffer = new byte[256];
                DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);

                // Receive client request
                socket.receive(responsePacket);

                // Get client's address and port
                InetAddress clientAddress = responsePacket.getAddress();
                int clientPort = responsePacket.getPort();

                // Convert response data to string and display it
                String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
                System.out.println("Response from client: " + response);

                // Get current date and time
                String dateTimeString = java.time.LocalDateTime.now().toString();

                // Convert the string to bytes
                byte[] data = dateTimeString.getBytes();

                // Create a response packet
                DatagramPacket replyPacket = new DatagramPacket(data, data.length, clientAddress, clientPort);

                // Send the response back to the client
                socket.send(replyPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
