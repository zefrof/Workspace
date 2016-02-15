import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class SimpleServer {

	public static void main(String[] args) {
		int port = 5678;
		try{
			ServerSocket server = new ServerSocket(port);
			
			Socket client = server.accept();
			BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter output = new PrintWriter(client.getOutputStream());
			
			System.out.println("connected to " + client);
			output.println("Hello!");
			output.flush();
			
			String inp = "";
			while((inp = input.readLine()) != null){
				System.out.println(">> " + inp);
				output.println(">> " + inp);
				output.flush();
			}
			output.close();
			input.close();
			client.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
