/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inheritance;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Samanmali
 */
public class Inheritance_Calculator {
    
    private static Inheritance_Calculator uniqueInstance;
	private static final String inheritedClass = "(public class)\\s([a-zA-Z]+)\\s(extends)\\s([a-zA-Z]+)";
	private static final String normalClass = "(public class)\\s([a-zA-Z]+)";
	
        int weightValue;
	Pattern pattern;
	String [] statementParts;
	ArrayList<String> baseClassToBe;
	int i =0;
        
        public static Inheritance_Calculator getInstance(ArrayList<String> programStatements) {
		if(uniqueInstance == null) {
			uniqueInstance = new Inheritance_Calculator(programStatements);
		}
		return uniqueInstance;
	}
        
        public Inheritance_Calculator(ArrayList<String> programStatements) {
		//this.programStatements = programStatements;
		baseClassToBe = new ArrayList<String> ();
	}
        
}
