import java.net.*;
import java.io.*;

public class TcpClient {

	public static void main(String[] args)
	{
		try
		{         //establish a connection
			Socket client = new Socket("localhost", 1537);

 			 // takes input from terminal
BufferedReader k = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter file location:");
			
			String filename = k.readLine();

// sends output to the socket			
DataOutputStream sendToServer = new DataOutputStream(client.getOutputStream());
			
			sendToServer.writeBytes(filename+"\n");

		// read the file contents from the server
//easily read text with the methods like readLine(). 

BufferedReader i = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
String string = i.readLine();
			if(string.equals("Yes"))
			{
				while((string=i.readLine())!=null)
					System.out.println(string);
			}
			else
				System.out.println("File not found");
			
			k.close();
			client.close();
			sendToServer.close();
			i.close();
		}
		catch(Exception ex) {}
	}
}
