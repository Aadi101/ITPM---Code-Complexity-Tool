/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ISHU
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Size {
    private String textLine = "LinkedHashMap<String, String>" ;//"public static int main(){ 789798";
//    private String textLine = "I would \"surely\" like to \"go to school\".";
    private int sumOfKeywords = 0;
    private int sumOfIdentifiers = 0;
    private int sumOfNumeric = 0;
    private int sumOfStringLiterals = 0;
    private int sumOfOperators = 0;
    private String[] splitTextArray;
    private ArrayList<String> classNameList;
    public HashMap<String, String> keyWordsMap = new HashMap<>();
    public HashMap<String, String> primitiveDataTypesMap = new HashMap<>();

    public Size(){
        keyWordsMap.put("public", "1");
        keyWordsMap.put("void", "1");
        keyWordsMap.put("static", "1");
        keyWordsMap.put("class", "1");
        keyWordsMap.put("true", "1");
        keyWordsMap.put("else", "1");
        keyWordsMap.put("default", "1");
        keyWordsMap.put("return", "1");
        keyWordsMap.put("null", "1");
        keyWordsMap.put("break", "1");
        keyWordsMap.put("this", "1");
        primitiveDataTypesMap.put("int", "1");
        primitiveDataTypesMap.put("float", "1");
        primitiveDataTypesMap.put("string", "1");
        primitiveDataTypesMap.put("char", "1");
        primitiveDataTypesMap.put("boolean", "1");
    }

    public void setTextLine(String textLine) {
        this.textLine = textLine;
        splitTextArray = textLine.split("[\\-::.}{)(><,;\\[\\]\\s]");
    }

    public int getSumOfNumeric() {
        return sumOfNumeric;
    }

    public int getSumOfStringLiterals() {
        return sumOfStringLiterals;
    }

    public int getSumOfKeywords() {
        return sumOfKeywords;
    }

    public int getSumOfIdentifiers() {
        return sumOfIdentifiers;
    }

    public int getSumOfOperators() {
        return sumOfOperators;
    }

    public void calculateWeightDueToKeyword(){

        try {
            for (String word : splitTextArray) {
                if (keyWordsMap.containsKey(word)) {
                    sumOfKeywords = sumOfKeywords + 1;
                }
            }
        } catch (Exception e){}
    }

    public void calculateWeightDueToIdentifiers(){
        this.isClassDeclarationFound();
        this.isMethodDeclarationFound();
        this.isVariableOrObjectOrDataStructure();
    }

    public boolean isClassDeclarationFound(){
        try {
            for (int i = 0; i < splitTextArray.length; i++){
                if (splitTextArray[i].equalsIgnoreCase("class")){
                    sumOfIdentifiers += 1;
                    classNameList.add(splitTextArray[(i++)]);
                    return true;
                }
            }
            return false;
        } catch (Exception e){
            return false;
        }
    }

    public boolean isMethodDeclarationFound(){
        try {
            String[] splitTextArrayToFindMethod = textLine.trim().split("[\\-::.}{><,;\\[\\]\\s]");
            for (int i = 0; i < splitTextArrayToFindMethod.length; i++){
                if (keyWordsMap.containsKey(splitTextArrayToFindMethod[i])){
                    if (keyWordsMap.containsKey(splitTextArrayToFindMethod[++i]) || primitiveDataTypesMap.containsKey(splitTextArrayToFindMethod[i])
                            || Character.isUpperCase(splitTextArrayToFindMethod[i].codePointAt(0))){
                        if (splitTextArrayToFindMethod[(++i)].contains("(")){
                            sumOfIdentifiers += 1;
                            return true;
                        } else if(splitTextArrayToFindMethod[(++i)].contains("(")){
                            sumOfIdentifiers += 1;
                            return true;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return false;
        } catch (Exception e){
            return false;
        }
    }

    public boolean isVariableOrObjectOrDataStructure(){
        try {
            String[] splitTextArrayToFindMethod = textLine.trim().split("[\\-::.}{><,;\\[\\]\\s]");
            for (int i = 0; i < splitTextArrayToFindMethod.length; i++){
                if (keyWordsMap.containsKey(splitTextArrayToFindMethod[i])){
                    if (keyWordsMap.containsKey(splitTextArrayToFindMethod[++i]) || primitiveDataTypesMap.containsKey(splitTextArrayToFindMethod[i])
                            || Character.isUpperCase(splitTextArrayToFindMethod[i].codePointAt(0))){
                        if (!splitTextArrayToFindMethod[(++i)].contains("(")){
                            sumOfIdentifiers += 1;
                            return true;
                        } else if(!splitTextArrayToFindMethod[(++i)].contains("(")){
                            sumOfIdentifiers += 1;
                            return true;
                        }
                    }
                }
            }
            return false;//|| splitTextArrayToFindMethod[(i)].contains("<") || splitTextArrayToFindMethod[i].contains("[")
        }catch (Exception e) {
            return false;
        }
    }

    public void numericValueFind(){
        try {
            Pattern pattern = Pattern.compile("\\w+([0-9]+)\\w+([0-9]+)");
            Matcher matcher = pattern.matcher(textLine);
            for(int i = 0 ; i < matcher.groupCount(); i++) {
                if (matcher.find()){
                    sumOfNumeric += 1;
                }
            }
        } catch (Exception e) {

        }
    }

    public void findStringLiterals(){
        try {
            String[] splitString = textLine.trim().split("\"");
            if (splitString.length > 1) {
                sumOfStringLiterals += 1;
            }
        } catch (Exception e) {

        }
    }

    public void findOperators(){
        try {
            String[] splitString = textLine.split(" ");
            for (int i = 0; i < splitString.length; i++){
                if ( splitString[i].equals("+") || splitString[i].equals("-") || splitString[i].equals("*") || splitString[i].equals("/") || splitString[i].equals("%") || splitString[i].contains("&&")
                        || splitString[i].equals("||") || splitString[i].equals("<")|| splitString[i].equals(">") || splitString[i].contains("<=") || splitString[i].contains(">=")
                        || splitString[i].contains("==") || splitString[i].equals("=")|| splitString[i].contains("++") || splitString[i].contains("--") || splitString[i].contains(".")) {
                    sumOfOperators += 1;
                }
            }
        }catch (Exception e){}
    }
}
