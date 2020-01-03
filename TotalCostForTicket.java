/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author riosk
 */
public interface TotalCostForTicket {

    /**
     *
     */
    double taxRate = 0.09;
    abstract double calculateTotalPrice();

    
}
