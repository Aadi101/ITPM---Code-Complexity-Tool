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
                    functions.add(tkns[3].substring(0, tkns[3].indexOf("(")));
                    continue;
                }

                if(line.contains(" "+className+"(" ) || line.contains(" "+className+" (")){
                            System.out.println("--- <--> Constructor <-->");
                            functions.add(tkns[1].substring(0,tkns[1].indexOf("(")).trim()+"\n");

                }else{
                        System.out.println("--- Normal signature : "+tkns[2].substring(0,tkns[2].indexOf("("))+"\n");
                        functions.add(tkns[2].substring(0,tkns[2].indexOf("(")));
                }
            }
        }

        return functions;
    }
    
    public ArrayList<String> extractFunctionBody(ArrayList<String> wholeFileArr, ArrayList<Integer> depthArr, String functionName){
        ArrayList<String> body = new ArrayList();
        String line = "";
        int depth = 0;

        for(int i= 0 ; i < wholeFileArr.size(); i++){
            line = wholeFileArr.get(i);
            depth = depthArr.get(i);
            
            if(line.contains(functionName) && depth>1){
                body.add(line);
            }
            
            if(line.contains("}") && depth == 1){
                break;
            }
        }
        
        return body;
    }
    
    //This may becaome redandant
    public ArrayList<String> initMethodContent(ArrayList<String> content, ArrayList<Integer> depthArrOri){
        ArrayList<String>methods = new ArrayList();
        ArrayList<Integer>depthArr = depthArrOri;
        
        String line="";
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
