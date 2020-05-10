/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coupling;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files


public class getFileContent {
    
    public List<File> getFileList(String directoryName) {
        File directory = new File(directoryName);
        
        List<File> resultList = new ArrayList<File>();

        // get all the files from a directory
        File[] fList = directory.listFiles();
        resultList.addAll(Arrays.asList(fList));
        for (File file : fList) {
            if (file.isFile()&&file.getName().contains(".java")) {
                //System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                resultList.addAll(getFileList(file.getAbsolutePath()));
            }
        }

        List<File> rList = new ArrayList<File>();
        File f ;
        String Line;
        for(int i =0; i < resultList.size(); i++){
            f = resultList.get(i);
            Line = f.getAbsolutePath();
            if(Line.contains(".java"))
                rList.add(f);
        }
        
        return rList;
    } 
    
    public ArrayList<String> readFileToArrayList(String fpath){
        //fpath = "file.java";
        ArrayList content = new ArrayList<String>();
        content.clear();
        boolean multiLineComment=false;
        try {
            File myObj = new File(fpath);
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              
              if(data.startsWith("/*")){//Identifying start of block comment
                  multiLineComment = true;
                  if(data.contains("*/")){
                      multiLineComment = false;
                      continue;
                  }
              }
              if(data.endsWith("*/")){//identifying end of block comment
                  multiLineComment = false;
              }
              
              if(multiLineComment){//Skipping comment section
                  continue;
              }
              
              if(!data.startsWith("/")){//removing single line comments
                content.add(data.trim());
              }
               
            }
   
            myReader.close();
          }catch (FileNotFoundException e) {
            System.out.println("File "+fpath+" could not be found");
            e.printStackTrace();
          }
        
        return content;
    }
    
    public String getClassNameFromFilePath(String path){
        return path.substring((path.lastIndexOf("\\")+1),path.lastIndexOf("."));
    }
    
}
