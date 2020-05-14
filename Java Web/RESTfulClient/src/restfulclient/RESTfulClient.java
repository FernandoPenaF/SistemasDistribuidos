/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restfulclient;

import webservicesclients.RestfulClient;

/**
 *
 * @author Fernando
 */
public class RESTfulClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RestfulClient client = new RestfulClient();
        Object response = client.getHtml();
        System.out.println("Respuesta del GET: " + response);
        client.putHtml("Jose");
        // do whatever with response
        client.close();
    }
    
}
