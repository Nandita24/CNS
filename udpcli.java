import java.util.*;
import java.net.*;

public class udpcli {

	public static void main(String[] args) {
		try
		{
			DatagramSocket client = new DatagramSocket();
			int serverSocket = 1537;
			InetAddress host = InetAddress.getByName("127.0.0.1");
			
			String message = "Text Message";
//convert the String input into the byte array.
			byte[] sendMessage = message.getBytes();
			DatagramPacket request = new DatagramPacket(sendMessage, sendMessage.length, host, serverSocket);
			client.send(request);
	

//create a DatgramPacket to receive the data
		
			byte[] buffer = new byte[1000]; // Clear the buffer after every message.
		DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			client.receive(reply);
			
		System.out.println("Client received:\n "+new String(reply.getData()));
			
			client.close();
		}
       catch(Exception ex) {}
}
}