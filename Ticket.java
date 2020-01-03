/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author riosk
 */
public abstract class Ticket {

public static double basePrice;
private int theaterNumber;
private int seatNumber;
private boolean TicketSold;
private boolean ReservedTickSold;
public Ticket(int theater, int seat, boolean reserved)
{
    theaterNumber = theater;
    seatNumber = seat;
    ReservedTickSold = reserved;
}
public void setTheater(int i)
{
        theaterNumber = i;
}
public void setSeat(int i)
{
        seatNumber = i;
}
public void setReserved(boolean reserved)
{
    ReservedTickSold = reserved;
}
public void setSold(boolean sold)
{
    TicketSold = sold;
}
public int getTheater()
{
    return theaterNumber;
}
public int getSeat()
{
    return seatNumber;
}
public boolean getReserved()
{
    return ReservedTickSold;
}
public boolean getSold()
{
    return TicketSold;
}
public boolean equals(Ticket x)
{
    if(x.getTheater() == theaterNumber && x.getSeat() == seatNumber)
        return true;
    else
        return false;
}
public String toString()
{
    return "For Theater " + getTheater() + " Seat Number " + getSeat() + " Which is ";
}

    
}
