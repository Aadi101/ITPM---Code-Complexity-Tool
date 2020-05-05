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
public class ClassObj {
    
    private String ClassName;
    private ArrayList FileContent = new ArrayList<String>();
    private ArrayList DeclaredFunctionNames = new ArrayList<String>();
    private ArrayList DepthInfo = new ArrayList<Integer>();
    
    private ArrayList recursiveFunctions = new ArrayList<String>();
    private ArrayList regularFunctions = new ArrayList<String>();
    
    private ArrayList GlobalVariables = new ArrayList<String>();

    
    private Method[] Methods;
    
    public void initMethodArray(int num){
        this.Methods = new Method[num];
    }
    
    public void assignMethodContent(ArrayList<String> mContent, int methodNumber, String mName){
        //System.out.println("!!!! assignMethodContent() : "+mContent.size());
        this.Methods[methodNumber]= new Method(mContent, mName);
    }
    
    public void setClassName(String Name){
        this.ClassName = Name.toLowerCase();
    }
    
    public void setContent(ArrayList<String> content){
        this.FileContent = content;
    }
    
    public void setFunctions(ArrayList<String> functions){
        this.DeclaredFunctionNames = functions;
    }
    
    public void setRecursiveFunctions(ArrayList<String> recFunctionsList){
        this.recursiveFunctions = recFunctionsList;
    }
    
    public void setRegularFunctions(ArrayList<String> regularFunctionsList){
        this.regularFunctions = regularFunctionsList;
    }
    
    public void setDepthInfo(ArrayList<Integer> depth){
        this.DepthInfo = depth;
    }
    
    public void setGlobalVariables(ArrayList<String> Variables){
        this.GlobalVariables = Variables;
    }
    
    
    public String getName(){
        return this.ClassName;
    }
    
    public Method[] getAllMethods(){
        return this.Methods;
    }
    
    public ArrayList<String> getRegularFunctionsList(){
        return regularFunctions;
    }
    
    public ArrayList<String> getRecursiveFunctionsList(){
        return recursiveFunctions;
    }
    
    public String getFunctionName(int num){
        return this.DeclaredFunctionNames.get(num).toString();
    }
    
    public ArrayList<String> getContent(){
        return this.FileContent;
    }
    
    public ArrayList<String> getFunctions(){
        return this.DeclaredFunctionNames;
    }
    
    public ArrayList<Integer> getDepthInfo(){
        return this.DepthInfo;
    }
    
    public ArrayList<String> getGlobalVariables(){
        return this.GlobalVariables;
    }
    
    public int getMethodCount(){
        return this.DeclaredFunctionNames.size();
    }
    
}
