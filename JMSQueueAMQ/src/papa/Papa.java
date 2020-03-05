/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papa;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author sdist
 */
public class Papa implements Serializable{
    private int ttl;
    private int id;
    
    public Papa(int id) {
        Random r = new Random();
        this.ttl = r.nextInt(10) + 1;
        this.id = id;
    }

    public Papa(int ttl, int id) {
        this.ttl = ttl;
        this.id = id;
    }
    
    public int getTtl() {
        return ttl;
    }

    public void decrementTtl() {
        this.ttl = this.ttl - 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Papa{" + "ttl=" + ttl + ", id=" + id + '}';
    }
    
}
