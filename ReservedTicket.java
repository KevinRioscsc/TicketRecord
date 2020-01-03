/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author riosk
 */
public final class ReservedTicket extends Ticket implements TotalCostForTicket {
    private double totalPrice;
    public ReservedTicket(int Theater, int Seats)
    {
        super(Theater, Seats, true);
        totalPrice = calculateTotalPrice();
    }
    @Override
    public double calculateTotalPrice()
    {
      return basePrice + MovieHouse.premium *(1+taxRate);
  
    }
    @Override
    public String toString()
    {
        return super.toString() + " RESERVED SEAT the price is $" + totalPrice;
        
    }

    
}
