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
public class Extraction {

    public ArrayList<Integer> calcDepth(ArrayList<String> arr){
        
        ArrayList<Integer> depthInfo = new ArrayList();
        String line = null;
        int depth = 0;
        
        for(int i = 0; i < arr.size(); i++){
            line=arr.get(i);
            
            if(line.contains("{"))
                depth++;
            if(line.contains("}"))
                depth--;
            
            depthInfo.add(depth);
        }
        
        return depthInfo;
    }
    
    public ArrayList<String> extractFunctionNames(ArrayList<String> contentArr, ArrayList<Integer> depthArr, String cname){
        String line = "";
        int depth = 0;
        ArrayList<String> functions = new ArrayList();
        String className = cname;
        
        System.out.println("--Extracting Functions");
        for(int i = 0; i < contentArr.size(); i++){
            line = contentArr.get(i).toLowerCase();
            depth = depthArr.get(i);
            String[] tkns = line.split(" ", line.length());//Tokenize words using 'space' as delimiting character
            
            if((tkns[0].equals("public")||tkns[0].equals("private")||
                    tkns[0].equals("protected"))&& depth>1/*!line.contains("class")*/){
                System.out.println("--- FunctionLine : "+line);
                
                if(line.contains(" static ")){
                    System.out.println("--- Static signature : "+line+" --> "+tkns[3].substring(0, tkns[3].indexOf("("))+"\n");
                    functions.add(tkns[3].substring(0, tkns[3].indexOf("(")).trim());
                    continue;
                }

                if(line.contains(" "+className+"(" ) || line.contains(" "+className+" (")){
                            System.out.println("--- <--> Constructor <-->");
                            functions.add(tkns[1].substring(0,tkns[1].indexOf("(")).trim());

                }else{
                        System.out.println("--- Normal signature : "+tkns[2].substring(0,tkns[2].indexOf("("))+"\n");
                        functions.add(tkns[2].substring(0,tkns[2].indexOf("(")).trim());
                }
            }
        }

        return functions;
    }
    
    public ArrayList<String> extractFunctionBody(ArrayList<String> wholeFileArr, ArrayList<Integer> depthArr, String functionName){
        ArrayList<String> body = new ArrayList();
        String line = "";
        int depth = 0;
        boolean matched = false;
        
        for(int i= 0 ; i < wholeFileArr.size(); i++){
            line = wholeFileArr.get(i).toLowerCase();
            depth = depthArr.get(i);
            //System.out.println("|||| depth : "+depth+ " |||| name to search : "+functionName+" !!!! line : "+line);
            if(line.contains(functionName.trim()) && depth==2){
                //body.add(line);
                //System.out.println("|||| depth : "+depth+ " |||| name to search : "+functionName+" !!!! line : "+line);
                //System.out.println("!!--!! Matched");
                matched=true;
            }
            
            if(line.contains("}") && depth == 1){
                //break;
                matched=false;
                //insideF = false;
            }
            
            if(matched){
                //System.out.println(line);
                body.add(line);
            }
        }
        
        body.add("}");//Adding last } since it is skipped in the checking
        //System.out.println("!!!! body size : "+body.size());
        return body;
    }
    
    public ArrayList<String> extractRecursiveFunctionNames(Method[] _methods){
            //System.out.println("##Executing extractRecursiveFunctionNames()");
            ArrayList<String> Names = new ArrayList();
            int count = 0;
            
            //System.out.println("##_methods.length "+ _methods.length);
            for(int i = 0; i < _methods.length; i++){
            
                String name = _methods[i].MethodName;
                //System.out.println("##mName : "+name);
                ArrayList<String> mContent = new ArrayList();
                
                mContent = _methods[i].getMethod();
                //System.out.println("name : "+name+" : mContent : "+mContent);
                //System.out.println("##mContent.size() : "+mContent.size());
                
                for(int j = 0; j < mContent.size(); j++){
                    //System.out.println("Checking whether line contains fName|"+name+" : "+mContent.get(j));
                    if(mContent.get(j).contains(name)){
                        count++;
                    }
                }
                if(count>1){
                    Names.add(name);
                }
                count=0;
            }
            
            return Names;
    }
    
    public ArrayList<String> extractRegularFunctionNames(ArrayList<String> functionList, ArrayList<String> recursiveList){
        ArrayList<String> regularFunctions = new ArrayList();
        
        for(int i =0; i < functionList.size(); i++){
            String fName = functionList.get(i);
            
            if(!recursiveList.contains(fName)){
                regularFunctions.add(fName);
            }
        
        }
        
        return regularFunctions;
    }
    
    public ArrayList<String> extractGlobalVariables(ArrayList<String> ClassContent, ArrayList<Integer> _depth){
    
        ArrayList<String> vars = new ArrayList();
        
        for(int i = 0 ; i < ClassContent.size(); i++){
        
            String line = ClassContent.get(i);
            int depth = _depth.get(i);
            
            if(depth!=1){
                continue;
            }
            //int,float,char,long,double,boolean,String
            if(line.contains("int")||line.contains("float")||
               line.contains("char")||line.contains("long")||
               line.contains("double")||line.contains("boolean")||line.contains("String")){
                String firstHalf = line.substring(0,line.indexOf("="));
                String []tkns = firstHalf.split(" ");
                int size = tkns.length;
                
                vars.add(tkns[size-1]);
            }
        }
        return vars;
    }
    
    //This may becaome redandant
    public ArrayList<String> initMethodContent(ArrayList<String> content, ArrayList<Integer> depthArrOri){
        ArrayList<String>methods = new ArrayList();
        ArrayList<Integer>depthArr = depthArrOri;
        
        String line = "";
        int depth=0;
        
        //initialize depth values > 2 to 2 to isolate function content to be extracted
        for(int i = 0; i < depthArr.size(); i++){
            depth = depthArr.get(i);
            if (depth>2){
                depthArr.set(i, 2);
            }
        }
        
        return methods;
    }
}
