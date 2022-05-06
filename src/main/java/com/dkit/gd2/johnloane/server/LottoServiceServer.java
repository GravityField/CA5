package com.dkit.gd2.johnloane.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class LottoServiceServer
{
    // TODO: Question 3
    //int clientNumber = 0;
    //for every client connection increment clientnumber
    // clientNumber++;
    //Implement a clientHandler
    //public static class ClientHandler implements Runnable   // each ClientHandler communicates with one BusinessObjects.Client
    //    {
    //        BufferedReader socketReader;
    //        PrintWriter socketWriter;
    //        Socket socket;
    //        int clientNumber;
    //
    //        public ClientHandler(Socket clientSocket, int clientNumber)
    //        {
    //            try
    //            {
    //                InputStreamReader isReader = new InputStreamReader(clientSocket.getInputStream());
    //                this.socketReader = new BufferedReader(isReader);
    //
    //                OutputStream os = clientSocket.getOutputStream();
    //                this.socketWriter = new PrintWriter(os, true); // true => auto flush socket buffer
    //
    //                this.clientNumber = clientNumber;  // ID number that we are assigning to this client
    //                this.socket = clientSocket;  // store socket ref for closing
    //
    //            } catch (IOException ex)
    //            {
    //                ex.printStackTrace();
    //            }
    //        }
    //move contents of main to run() for a new runnable everytime the clienthandler is called
    //Start a new thread
    //Thread t = new Thread(new ClientHandler(socket, clientNumber)); // create a new ClientHandler for the client
    //t.start();


    public static void main(String[] args) throws IOException {
        ServerSocket listeningSocket = null;
        Socket dataSocket = null;

        //Set up the listening socket

        listeningSocket = new ServerSocket(50007);

        //Do the main logic of the server

        while(true)
        {
            System.out.println("Starting server");



            Socket socket = listeningSocket.accept();

            OutputStream os = socket.getOutputStream();
            PrintWriter socketWriter = new PrintWriter(os, true);

            InputStreamReader is = new InputStreamReader(socket.getInputStream());
            BufferedReader socketReader = new BufferedReader(is);



            String message;
            System.out.println(socket);
            try
            {
                while((message = socketReader.readLine()) != null)
                {

                    if(message.startsWith("GENERATE%"))
                    {

                        String tokens[] = message.split("%");
                        String generated = "";
                        Random rand = new Random();
                        int quantity = Integer.parseInt(tokens[1]);
                        int[] arr = new int[quantity];
                        for(int i = 0; i < quantity; i++) {
                            arr[i] = rand.nextInt();
                            if(i == quantity - 1) {
                                generated += arr[i];
                            }
                            else
                            {
                                generated += arr[i] + "%";
                            }
                        }

                        socketWriter.println("Generated%" + generated);
                    }
                    else
                    {
                        socketWriter.println("No command chosen");
                    }
                    socket.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }
}
