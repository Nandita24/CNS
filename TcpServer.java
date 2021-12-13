import java.net.*;
import java.io.*;

public class TcpServer {

	public static void main(String[] args)
	{
		try
		{
			ServerSocket se = new ServerSocket(1537);
//waits for requests to come in over the network.

			System.out.println("Server waiting");

			Socket server = se.accept();
//Listens for a connection to be made to this socket and accepts it
			System.out.println("Connection established");

BufferedReader k = new BufferedReader (new    InputStreamReader(server.getInputStream()));
// Reads data from the server enables to easily read text with the methods like //readLine(). 
			String filename = k.readLine();

			FileReader f = null;
			BufferedReader ff = null;
// Write the data back to client
DataOutputStream sendToClient = new DataOutputStream(server.getOutputStream());

			File file = new File(filename);
			System.out.println(file);
			
if(file.exists())
			{
				sendToClient.writeBytes("Yes\n");
				f = new FileReader(filename);
				ff = new BufferedReader(f);
				String string;
				while((string = ff.readLine())!=null)
					sendToClient.writeBytes(string+"\n");
			}

			else
			{
				sendToClient.writeBytes("No\n");
			}

			server.close();
			k.close();

			sendToClient.close();
			f.close();

			ff.close();
			se.close();
		}
		catch(Exception ex) {}
		
	}
}
