/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author riosk
 */
public final class GeneralTicket extends Ticket implements TotalCostForTicket {
    private double totalCost;
    public GeneralTicket(int Theater, int Seat)
    {
        super(Theater, Seat, false);
        totalCost = calculateTotalPrice();
    }
    @Override
    public double calculateTotalPrice()
    {
        return basePrice * (1 + taxRate);
    }
    @Override
    public String toString()
    {
        return super.toString() + " GENERAL ADMISSION the price is $" + totalCost;
        
    }

    
}
