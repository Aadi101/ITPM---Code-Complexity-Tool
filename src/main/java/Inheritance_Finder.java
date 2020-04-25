

import java.io.Console;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.spi.http.HttpContext;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samanmali
 */
public class Inheritance_Finder {
    
    private String FILE_NAME;
        public static String[] KEYWORDS = { "extends", "implements", ":" };
        public List<Inheritance> completeList = new ArrayList<>();
        public int totalDirect = 0;
        public int totalIndirect = 0;
        public int totalCi = 0;
        
        public Inheritance_Finder()  //Constructor
        {

        }
        
        public void SetFileName(String fileName)
        {
            this.FILE_NAME = fileName;
        }
        
        public void ProcessFile()
        {

            this.FILE_NAME = "lol.java";
            System.out.println("tiktok");

            try
            {
                // Create an instance of StreamReader to read from a file.
                // The using statement also closes the StreamReader.
               // String PATH_TO_UPLOADED_FILE = HttpContext.Current.Server.MapPath("~/uploadedFiles/" + this.FILE_NAME);
                String line;
                
                FileInputStream st = new FileInputStream ("test.txt");
                
                InputStreamReader sr = new InputStreamReader(st);
                
//                    while((line= sr.read()) != null){
//                            System.out.println(line);
//                    }
                    
                    // Read and display lines from the file until the end of 
                    // the file is reached.
//                    while ((line = sr.ReadLine()) != null)
//                    {
//                        
//                        this.Identify(line);
//                    }
                
                
            }
            catch (Exception e)
            {
                // Let the user know what went wrong.
                System.out.println("The file could not be read:");
                System.out.println(e.getMessage());
            }
        }
            //Detect Method

        public void Identify(String line1)
        {
            int direct = 0;
            int indirect = 0;
            int ci = 0;

            String[] KEYWORDS = { "extends", "implements", ":" };

            String[] WORDS = line1.split(line1);

            //Check if this line contains keywords

            for (int position = 0; position < WORDS.length; position++)
            {
                for (String keyword : KEYWORDS)
                {
                    if (WORDS[position] == keyword )//A Keyword on the line is found
                    {
                        
                        for (int temp = position + 1; temp < WORDS.length; temp++)//Checking words after keywords
                        {
                            if (WORDS[temp] == ",")
                            {
                                if (direct == 0)
                                {
                                    direct = direct + 2;//One defined Class found
                                    this.totalDirect = this.totalDirect + direct;
                                }
                                else
                                {
                                    direct = direct + 1;
                                    this.totalDirect = this.totalDirect + direct;
                                }
                            }
                            else if (direct == 0 && WORDS[temp] == "{")
                            {
                                direct = direct + 1;
                                this.totalDirect = this.totalDirect + direct;
                            }
                        }
                        ci = direct + indirect;
                        this.totalCi = this.totalCi + ci;
                        
                        
                        completeList.add(new Inheritance(line1, indirect, direct, ci));
                    }
                }
                //Calculate Ci value 
            }
            if( ci == 0)
            {
                completeList.add(new Inheritance(line1, indirect, direct, ci) );
            }
        }
}
