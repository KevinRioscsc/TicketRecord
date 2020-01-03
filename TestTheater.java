/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author riosk
 */

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class TestTheater {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        Scanner console = new Scanner(System.in);
        System.out.print("Please enter the name of the movie house: ");
        String name = console.nextLine();
        System.out.print("\nPlease enter the number of seats in theaters 0, 1 and 2 as integers. \n" +
"Minimum 40 seats per theater: ");
        int seat0 = console.nextInt();
        int seat1 = console.nextInt();
        int seat2 = console.nextInt();
        System.out.print("\nEnter the base price of the tickets: ");
        Ticket.basePrice = console.nextDouble();
        
        
        MovieHouse movie = new MovieHouse(name, seat0, seat1, seat2);
        
        System.out.print("Please enter the name of the outputfile: ");
        String outputfilename = console.next();
        File outputFile = new File(outputfilename);
        PrintWriter outputWriter = new PrintWriter(outputFile);
        movie.setOutputWriter(outputWriter);
        
        for(int i = 0; i < 3; i++)
        {
            
            movie.startsales(i);
            
            
        }
        movie.PrintSeatMap();
        movie.PrintSaleRecord();
        outputWriter.close();
  
      
        
    }
    
}
