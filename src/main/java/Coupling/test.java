/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coupling;


public class test {
    
    public static void concat(String a, String b){
        System.out.println("Print : "+a+"-"+b);
    }
    
    public static void main(String[] args){
        
        String line = "public method(arraylist<string> arr){";
        String find = "method";
        if(line.contains(find)){
            System.out.println("Matched");
        } 
        
        concat(find," is a parameter");
        
        
    }
}
