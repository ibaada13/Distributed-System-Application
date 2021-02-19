//package assignment1;
import java.net.*;
import java.util.Scanner;
import java.awt.Desktop;
import java.io.*;
public class MTEchoServer {

public static void main(String[] args) throws FileNotFoundException {
        
        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }
         
        int portNumber = Integer.parseInt(args[0]);
        //String hostName = "localhost";
        MTEchoServer es = new MTEchoServer();
        es.run(portNumber);
     }

     public void run(int portNumber) {
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while(true) {
               Socket client = serverSocket.accept();
               Connection cc = new Connection(client);
            }
        } catch(Exception e) {
           System.out.println("Exception: "+e);
        }
    }
         
}

class Connection extends Thread {
    Socket client;
    PrintWriter out;
    BufferedReader in;

    public Connection(Socket s) { // constructor
       client = s;
       

       try {
           out = new PrintWriter(client.getOutputStream(), true);                   
           in = new BufferedReader(
                new InputStreamReader(client.getInputStream()));
       } catch (IOException e) {
           try {
             client.close();
           } catch (IOException ex) {
             System.out.println("Error while getting socket streams.."+ex);
           }
           return;
       }
        this.start(); // Thread starts here...this start() will call run()
    }
 
    public void run() {
    	
    	//String firstName = null;
    	//String lastName = null;
    	double average = 0;
    	Desktop url = Desktop.getDesktop();
    	
    	
    	/*if (firstName.isEmpty()) {
    		System.out.println("Invalid First Name");
    	}
    	else {
    		return;
    	}
    	
    	if (lastName.isEmpty()) {
    		System.out.println("Invalid Last Name");
    	}
    	else {
    		return;
    	}*/
    	
    	if (average >= 85) {
    		System.out.println("Success! Please choose a program from the list below: ");
    		System.out.println("business, engineering, life science, social science");
    	}
    	else {
    		System.out.println("Sorry, your average does not meet the university requirement");
    	}
    	
    	//File list = new File(C:\Users\ibaad\Desktop\assignment1);
    	File list = new File("C:/Users/ibaad/Desktop/programList.txt");
    	try {
			//File list = new File("/Users/ibaad/Desktop/programList.txt");
			
			Scanner scan = new Scanner(list);
			System.out.println(scan.nextLine()); //see if this goes after catch
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	/*if (list == true ) {
    		System.out.println("https://registrar.ontariotechu.ca/");
    	}
    	else {
    		System.out.println("Invalid Program name");
    	}*/
    	
   
    	
      try {
    	  
         String inputLine;
         while ((inputLine = in.readLine()) != null) {
                System.out.println("Received from: "+ client.getRemoteSocketAddress() + " Input: "+inputLine);
                out.println(inputLine);
         }
         
         client.close();
       } 
      
      catch (IOException e) {
           System.out.println("Exception caught...");
           System.out.println(e.getMessage());
       }
    
    }
}

