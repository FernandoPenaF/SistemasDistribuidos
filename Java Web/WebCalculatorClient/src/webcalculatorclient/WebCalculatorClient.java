/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcalculatorclient;

import webservicesclient.ComplexNumber;

/**
 *
 * @author Fernando
 */
public class WebCalculatorClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber();
        ComplexNumber c2 = new ComplexNumber();
        ComplexNumber res;
        
        c1.setI(3);
        c1.setJ(4);
        c2.setI(-1);
        c2.setJ(10);
        
        res = add(c1,c2);
        System.out.println(res.getI());
        System.out.println(res.getJ());
    }

    private static ComplexNumber add(webservicesclient.ComplexNumber a, webservicesclient.ComplexNumber b) {
        webservicesclient.Calculator_Service service = new webservicesclient.Calculator_Service();
        webservicesclient.Calculator port = service.getCalculatorPort();
        return port.add(a, b);
    }
    
}
