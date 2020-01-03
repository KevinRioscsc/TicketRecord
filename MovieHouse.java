/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author riosk
 */
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
public class MovieHouse {
    private ArrayList <Ticket> theater0 = new ArrayList<> ();
    private ArrayList <Ticket> theater1 = new ArrayList<> ();
    private ArrayList <Ticket> theater2 = new ArrayList<> ();
    private PrintWriter outputWriter;
    private String movieHouseName;
    public static double premium = 3.50;
    private boolean [][] theaterSeats =new boolean[3][];
public MovieHouse(String name, int Seat0, int Seat1, int Seat2)
{
    movieHouseName = name;
    theaterSeats[0] = new boolean[Seat0];
    theaterSeats[1] = new boolean[Seat1];
    theaterSeats[2] = new boolean[Seat2];
}
public void setOutputWriter(PrintWriter outputWriter)
{
    this.outputWriter = outputWriter;
}
public void startsales(int Theater)
{
    Random generator = new Random(Theater*5 + 10);
    int Seattobesold;
    Seattobesold = generator.nextInt(theaterSeats[Theater].length/2) + theaterSeats[Theater].length/2;
    int status;
    int number;
    for(int i = 0; i < Seattobesold; i++)
    {
        number = generator.nextInt(Seattobesold);
        if(i % 3 == 0)
           status = sellTicket(new ReservedTicket(Theater, number));
        else
        {
          status = sellTicket(new GeneralTicket(Theater, number));
        }
        if(status != 0)
        {
            i = i - 1;
        }
	
    }
}
public int sellTicket(Ticket ticketsell)
{
    int theaternumb = ticketsell.getTheater();
    int seatnumb = ticketsell.getSeat();
    if(theaternumb > 2 || theaternumb < 0)
    {
        return 1;
    }
    else if(seatnumb > theaterSeats[theaternumb].length -1 || seatnumb < 0)
    {
        return 2;
    }
    else if(theaterSeats[theaternumb][seatnumb] == true)
    {
        return 3;
    }
    else
    {
       theaterSeats[theaternumb][seatnumb] = true;
       ticketsell.setSold(true);
       if(theaternumb == 0)
       {
           theater0.add(ticketsell);
       }
       else if(theaternumb == 1)
       {
           theater1.add(ticketsell);
       }
       else
       {
           theater2.add(ticketsell);
       }
       return 0;
    }
    
}
public void PrintSeatMap()throws IOException
{
   outputWriter.print("Welcome to the " + movieHouseName);
   for(int i = 0; i < 3; i++)
   {
       outputWriter.print("\nTheater " + i + " SeatMap\n");
       for(int j = 0; j < theaterSeats[i].length; j++)
       {
           if(j%10 == 0)
           {
               outputWriter.print("\n");
           }
           if(theaterSeats[i][j]== true)
           {
               outputWriter.print("S");
               
           }
           else
           {
               outputWriter.print("V");
           }
           //outputWriter.print("\n");
       }
       //outputWriter.print("\n");
   }
   
}
public void PrintSaleRecord()throws IOException
{
    outputWriter.print("\nThe Ticket Record for Theater 0 \n");
    for(int i =0 ; i < theater0.size(); i ++)
    {
        outputWriter.print(theater0.get(i) + "\n");
    }
    outputWriter.print("\nThe Ticket record for Theater 1 \n");
    for(int j = 0; j < theater1.size(); j ++)
    {
        outputWriter.print(theater1.get(j) + "\n");
        
                
    }
    outputWriter.print("\nThe ticket Record for Theater 2 \n");
    for(int g =0 ; g < theater2.size(); g ++)
    {
        outputWriter.print(theater2.get(g)+ "\n");
    }
    
}
/*
public int sellTicket(Ticket ticket)
	{
		int seatNum = ticket.getSeatNumber();
		int theaterNum = ticket.getTheaterNumber();
		if (theaterNum > 2 || theaterNum < 0)
		{
			//System.out.printf("Theater doesn't exist\n");
			return 1; //theater doesn't exist
		}
		else if(seatNum > theaterSeats[theaterNum].length -1 || seatNum < 0)
		{
			//System.out.printf("Seat doesn't exist\n");
			return 2;// seat number doesn't exist
		}
		else if (theaterSeats[theaterNum][seatNum] == true)
		{
			//System.out.printf("Seat is taken\n");	
			return 3; // seat taken
		}
		else 
		{
			theaterSeats[theaterNum][seatNum] = true;
			ticket.setSold(true);
			if (theaterNum == 0)
				theater0.add(ticket);
			else if (theaterNum == 1)
				theater1.add(ticket);
			else 
				theater2.add(ticket);
			return 0;
		}
	}
	
	*/			

}
