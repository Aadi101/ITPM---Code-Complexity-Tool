/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coupling;

import java.util.ArrayList;


public class Method {
    
    String MethodName ;
    private ArrayList<String> content = new ArrayList();
    private ArrayList<Integer> depth = new ArrayList();
    
    
    public Method(ArrayList<String> arr, String mName){
        this.content=arr;
        this.MethodName = mName;
    }
    
    
    public void setMethodDepth(ArrayList<Integer>arr){
        this.depth = arr;
    }
    
    
    
    public ArrayList<String> getMethod(){
        return this.content;
    }
    
    public ArrayList<Integer> getMethodDepth(){
        return this.depth;
    }
    
    public Integer getMethodLineDepth(int LineNo){
        return this.depth.get(LineNo);
    }
}
