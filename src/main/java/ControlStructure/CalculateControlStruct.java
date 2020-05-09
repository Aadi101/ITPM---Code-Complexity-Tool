/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlStructure;

import Commons.Weights;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Asus
 */
public class CalculateControlStruct {

    public String getControllerCodeSegment(String statement) {
        String codeSegment = "";
        Matcher findIf = Pattern.compile("^[ \\t]*if *.*").matcher(statement);
        Matcher findFor = Pattern.compile("^[ \\t]*for *.*").matcher(statement);
        Matcher findWhile = Pattern.compile("^[ \\t]*while *.*").matcher(statement);
        Matcher findSwitch = Pattern.compile("^[ \\t]*switch *.*").matcher(statement);
        Matcher findSwitchCase = Pattern.compile("^[ \\t]*case *.*").matcher(statement);
        if (findIf.find()) {
            codeSegment = findIf.group();
        } else if (findFor.find()) {
            codeSegment = findFor.group();
        } else if (findWhile.find()) {
            codeSegment = findWhile.group();
        } else if (findSwitch.find()) {
            codeSegment = findSwitch.group();
        } else if (findSwitchCase.find()) {
            codeSegment = findSwitchCase.group();
        }
        return codeSegment;
    }

    public String getGontrolStructureType(String statement) {
        String codeType = "";
        Matcher findIf = Pattern.compile("^[ \\t]*if *.*").matcher(statement);
        Matcher findFor = Pattern.compile("^[ \\t]*for *.*").matcher(statement);
        Matcher findWhile = Pattern.compile("^[ \\t]*while *.*").matcher(statement);
        Matcher findSwitch = Pattern.compile("^[ \\t]*switch *.*").matcher(statement);
        Matcher findSwitchCase = Pattern.compile("^[ \\t]*case *.*").matcher(statement);
        if (findIf.find()) {
            codeType = "if";
        } else if (findFor.find()) {
            codeType = "for";
        } else if (findWhile.find()) {
            codeType = "while";
        } else if (findSwitch.find()) {
            codeType = "switch";
        } else if (findSwitchCase.find()) {
            codeType = "case";
        }
        return codeType;
    }

    public int numberOfClosingTags(String statement) {
        int numberOfClosing = 0;
        Matcher findClosing = Pattern.compile("[ \\t]*\\}").matcher(statement);
        while (findClosing.find()) {
            numberOfClosing++;
        }
        return numberOfClosing;
    }

    public int numberOfOpeningTags(String statement) {
        int numberOfOpening = 0;
        Matcher findOpening = Pattern.compile("[ \\t]*\\{[ \\n]*").matcher(statement);
        while (findOpening.find()) {
            numberOfOpening++;
        }
        return numberOfOpening;
    }

    public int getWeight(String controlStructureType) {
        int wtcs = 0;
        
        switch (controlStructureType) {
            case "if":
                wtcs = Weights.ifControlStructure;
                break;
            case "for":
                wtcs = Weights.forWhileControlStructure;
                break;
            case "while":
                wtcs = Weights.forWhileControlStructure;
                break;
            case "switch":
                wtcs = Weights.switchControlStructure;
                break;
            case "case":
                wtcs = Weights.caseControlStructure;
                break;
        }
        return wtcs;
    }

    public int getNumberOfConditions(String codeStatement) {
        int totalConditions = 0;
        Matcher findConditions = Pattern.compile("(>|<|<=|>=|==|!=)").matcher(codeStatement);
        while (findConditions.find()) {
            totalConditions++;
        }
        return totalConditions == 0 ? 1 : totalConditions;
    }
}
