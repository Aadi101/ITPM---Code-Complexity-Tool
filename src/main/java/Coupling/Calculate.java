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
public class Calculate {
    int Nmcmd = 0;
    int Nmcrmd = 0;
    int Nrmcrmd = 0;
    int Nrmcmd = 0;
    int Nmrgvd = 0;
    int Nrmrgvd = 0;
    
    ArrayList <String> regularFunctions = new ArrayList();
    ArrayList <String> recursiveFunctions = new ArrayList();
    
    ArrayList <String> globalVars = new ArrayList();
    
    //ArrayList <String> regularToGlobalVariables = new ArrayList();
    //ArrayList <String> recursiveToGlobalVariables = new ArrayList();
    
    Method[] Methods;
    
    public Calculate(ArrayList<String> _regularFunctions, 
                        ArrayList<String> _recursiveFunctions, 
                        Method[] _Methods,
                        ArrayList<String> _globalVars){
        this.regularFunctions = _regularFunctions;
        this.recursiveFunctions = _recursiveFunctions;
        this.Methods = _Methods;
        this.globalVars = _globalVars;
    }
    
    public int Nmcrms_regularToRecursive(){
        int Nmcrms = 0;
        
        for(int i = 0 ; i < this.regularFunctions.size(); i++ ){
        
                String name = this.regularFunctions.get(i);
                
                for(int j = 0 ; j < Methods.length; j++){
                    //System.out.println("---------\n seach for name : "+name);
                    //System.out.println("Full methodName : "+Methods[j].MethodName);
                    
                    if(name.equals(Methods[j].MethodName)){
                       // System.out.println("skip");
                        continue;
                    }
                    
                    ArrayList<String> methodContent = new ArrayList();
                    methodContent = Methods[j].getMethod();
                    
                    for(int k=0; k < methodContent.size() ;k++){
                        if(methodContent.get(k).contains(" "+name)){//other wise method() and getmethod() will be same
                            System.out.println("Hit: "+methodContent.get(k));
                            Nmcrms++;
                        }
                    }
                }
        }

        return Nmcrms;
    }
    
    public int Nmcms_regularToRegular(){
        int Nmcms = 0;
        
        for(int i = 0 ; i < this.regularFunctions.size(); i++ ){
        
                String name = this.regularFunctions.get(i);
                for(int j = 0 ; j < Methods.length; j++){
                    //System.out.println("---------\n seach for name : "+name);
                    //System.out.println("Full methodName : "+Methods[j].MethodName);
                    
                    if(name.equals(Methods[j].MethodName)){
                        //System.out.println("skip");
                        continue;
                    }
                    
                    ArrayList<String> methodContent = new ArrayList();
                    methodContent = Methods[j].getMethod();
                    
                    int x = calculateHits(methodContent, name);
                    Nmcms = Nmcms +x;
                
                }
        }
        
        
        return Nmcms;
    }
    
    public int Nrmcrms_recursiveToRecursive(){
    
        int nrmcrms = 0;
        
        for(int i = 0 ; i < this.recursiveFunctions.size(); i ++){
            
            String name = this.recursiveFunctions.get(i);
            
            for(int j=0; j < this.Methods.length; j++){
            
                if(name.equals(Methods[j].MethodName)){
                    continue;
                }
                
                ArrayList<String> content = new ArrayList();
                content = Methods[j].getMethod();
                
                int x = calculateHits(content,name);
                nrmcrms = nrmcrms + x;
            
            }
        }
        
        return nrmcrms;
    }
    
    public int Nrmcms_recursiveToRegular(){
    
        int nrmcms = 0;
        
        for(int i = 0 ; i < this.recursiveFunctions.size(); i++){
        
            String name = this.recursiveFunctions.get(i);
            
            for(int j = 0; j < this.Methods.length; j++){
                
                ArrayList<String> function = new ArrayList();
                function = this.Methods[j].getMethod();
                
                for(int k = 0; k < this.regularFunctions.size(); k++){
                    
                    if(!Methods[j].MethodName.equals(this.regularFunctions.get(k))){
                        int x = calculateHits(function, this.regularFunctions.get(k));
                        nrmcms = nrmcms+x;
                    }
                    
                }
                
            }
        
        
        }
        return nrmcms;
    }
    
    public int Nmrgvs_regularToGlobalVariables(){
        int count = 0;
        
        for(int i =0; i < this.regularFunctions.size(); i++){
        
            String regFuncName = this.regularFunctions.get(i);
            
            for(int j = 0; j < this.Methods.length; j++){
                if(regFuncName.equals(this.Methods[j].MethodName)){
                    
                    ArrayList<String> func = new ArrayList();
                    func = this.Methods[j].getMethod();
                    
                    for(int k =0 ; k < this.globalVars.size(); k++){
                        int x = calculateHits(func,this.globalVars.get(k));
                        count = count + x;
                    }

                }
            }
        }

        return count;
    }
    
    public int Nrmrgvs_recursiveToGlobalVariables(){
        int count = 0;
        
        for(int i =0; i < this.recursiveFunctions.size(); i++){
        
            String regFuncName = this.recursiveFunctions.get(i);
            
            for(int j = 0; j < this.Methods.length; j++){
                if(regFuncName.equals(this.Methods[j].MethodName)){
                    
                    ArrayList<String> func = new ArrayList();
                    func = this.Methods[j].getMethod();
                    
                    for(int k =0 ; k < this.globalVars.size(); k++){
                        int x = calculateHits(func,this.globalVars.get(k));
                        count = count + x;
                    }

                }
            }
        }

        return count;
    }
    
    private int calculateHits(ArrayList<String> list, String find){
    
        int count = 0;
        
        for(int i = 0 ; i < list.size(); i ++){
        
            String line = list.get(i);
            if(line.contains(find)){
                count++;
            }
        }
        
        return count;
    }
    
    public int[] CC(int selected, ClassObj[] classes){
            Nmcmd=Nmcrmd=Nrmcrmd=Nrmcmd=Nmrgvd=Nrmrgvd= 0;
           
            int []nums = new int[4];
            ArrayList<String> fClassMethodRegular = new ArrayList();
            ArrayList<String> fClassMethodRecursive = new ArrayList();
            ArrayList<String> fClassGlobalVariables = new ArrayList();
            //Method []fClassMethodBodies;
        
            fClassMethodRegular = classes[selected].getRegularFunctionsList();
            fClassMethodRecursive = classes[selected].getRecursiveFunctionsList();
            fClassGlobalVariables = classes[selected].getGlobalVariables();
            //fClassMethodBodies = classes[x].getAllMethods();
        
            for(int y = 0; y <classes.length; y++){
                if(classes[selected].getName()==classes[y].getName()){continue;}//Skips same class
                
                ArrayList<String> sClassMethodRegular = new ArrayList();
                ArrayList<String> sClassMethodRecursive = new ArrayList();
                Method [] sClassMethodBodies;

                sClassMethodRegular = classes[y].getRegularFunctionsList();
                sClassMethodRecursive = classes[y].getRecursiveFunctionsList();
                sClassMethodBodies = classes[y].getAllMethods();
                
                Nmcmd = checkFunctionHits(fClassMethodRegular,sClassMethodBodies,sClassMethodRecursive);
                Nmcrmd = checkFunctionHits(fClassMethodRegular,sClassMethodBodies,sClassMethodRegular);
                Nrmcrmd = checkFunctionHits(fClassMethodRecursive,sClassMethodBodies,sClassMethodRegular);
                Nrmcmd = checkFunctionHits(fClassMethodRecursive,sClassMethodBodies,sClassMethodRecursive);
                Nmrgvd = checkFunctionHits(fClassGlobalVariables,sClassMethodBodies,sClassMethodRecursive);
                Nrmrgvd = checkFunctionHits(fClassGlobalVariables,sClassMethodBodies,sClassMethodRegular);
                
                //this part is redandant
                nums[0] = Nmcmd;
                nums[1] = Nmcrmd;
                nums[2] = Nrmcrmd;
                nums[3] = Nrmcmd;
                
            }
            
        return nums;
    }
    
    public int checkFunctionHits(ArrayList<String>main, Method[] method, ArrayList<String> excludeList){
        int count = 0;
        for(int i=0; i<main.size(); i++){
            
            for(int j=0; j<method.length; j++){
                
                if(excludeList.contains(method[j].MethodName)){
                    continue;
                }
                int x = countHits(method[j].getMethod(), main.get(i));
                count = count+x;
            }
    
        }
        
        return count;
    }
    
    private int countHits(ArrayList<String> arr, String find){
        int count = 0;
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i).contains(find)){
                count++;
            }
        }
        return count;
    }
    

    
    public int getNmcmd(){
        return this.Nmcmd;
    }
    
    public int getNmcrmd(){
        return this.Nmcrmd;
    }
    
    public int getNrmcrmd(){
        return this.Nrmcrmd;
    }
    
    public int getNrmcmd(){
        return this.Nrmcmd;
    }
    
    public int getNmrgvd(){
        return this.Nmrgvd;
    }
    
    public int getNrmrgvd(){
        return this.Nrmrgvd;
    }
}
