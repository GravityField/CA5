package com.dkit.gd2.johnloane.client;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class LottoServiceClient
{
    public static void main(String[] args) throws IOException {
        Socket dataSocket = null;


        //Step 1: Establish a channel to communicate

        dataSocket = new Socket("localhost",50007);

        //Step 2: Build the input and output streams
        Scanner socketReader = new Scanner(dataSocket.getInputStream());
        OutputStream os = dataSocket.getOutputStream();
        PrintWriter socketWriter = new PrintWriter(os, true);

        //Step 3: Get input from user
        Scanner in = new Scanner(System.in);
        String command;
        String response;
        System.out.println("Enter how many numbers you want to generate");
        int quantity = in.nextInt();

        command = "GENERATE%" + quantity;
        //Step 4: Send message to server and display the response
        socketWriter.println(command);


        response = socketReader.nextLine();
        System.out.println(response);



        socketWriter.close();
        socketReader.close();
        dataSocket.close();
    }
}
