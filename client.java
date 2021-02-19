//package assignment1;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {
   
		public static void main(String[] args) {
			
			if (args.length != 2) {       
				//System.err.println("Usage: java EchoClient <host name> <port number>"); 
				System.exit(1);        
			}
			
			String hostName = args[0]; 
			int portNumber = Integer.parseInt(args[1]);
			
			try {
				Socket echoSocket = new Socket("127.0.0.1", 1387);
				ObjectOutputStream oos = new ObjectOutputStream(echoSocket.getOutputStream());
				PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
				
				Scanner student = new Scanner(System.in);
				
				System.out.println("Welcome to UOIT Sign up! \nPlease type your first Name: ");
				String firstName = student.next();
				out.println(firstName);
				
				System.out.println("Type in your last name: ");
				String lastName = student.next();
				out.println(lastName);
				
				System.out.println("You are signed up! Please enter your current average: ");
				double avg = student.nextInt();
				out.println(avg);
				
				System.out.println("Please choose a program from the list given: ");
				String list = student.next();
				out.println(list);
				
				String userInput;    
				while ((userInput = stdIn.readLine()) != null) {
					out.println(userInput);  
					System.out.println("Echo Server Sent: " + in.readLine());
				}
			
			}
			catch (UnknownHostException e) {           
				System.err.println("Don't know about host " + hostName);         
				System.exit(1);
			}
			catch (IOException e) {       
				System.err.println("Couldn't get I/O for the connection to " + hostName);           
				System.exit(1);
			}
	}
		
	
}
