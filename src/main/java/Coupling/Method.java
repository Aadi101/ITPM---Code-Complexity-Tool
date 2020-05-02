/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coupling;

import java.util.ArrayList;

/**
 *
 * @author Tharindu
 */
public class Method {
    private ArrayList<String> content = new ArrayList();
    
    public Method(ArrayList<String> arr){
        this.content=arr;
    }
    
    public ArrayList<String> getMethod(){
        return this.content;
    }
}
