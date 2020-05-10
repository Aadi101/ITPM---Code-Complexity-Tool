///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package FinalRepo;
//
//import ControlStructure.CalculateControlStruct;
//import ControlStructure.ControlStruc;
//import java.util.Stack;
//import javax.swing.table.DefaultTableModel;
//
///**
// *
// * @author Asus
// */
//public class FinalReport {
//    String fullCode6 = ControlStruc.jTextArea1.getText();
//    String[] lines = fullCode6.split("\n");
//    public int FinalCalculate(){
//        
//        int lineCount = lines.length;
//        
//        
//        Stack ccsStack = new Stack();
//                int currentCcs = 0;
//                int index = 1;
//                int totalccs = 0;
//                for (String line : lines) {
//                    CalculateControlStruct calculateControlStruct = new CalculateControlStruct();
//                    Object[] row;
//                    int cs = 0;
//                    int cv = 0;
//                    int cm = 0;
//                    int ci = 0;
//                    int ccp = 0;
//                    int ccs = 0;
//                    String codeSegment = calculateControlStruct.getControllerCodeSegment(line);
//                    String type = calculateControlStruct.getGontrolStructureType(codeSegment);
//                    int closingTagCount = calculateControlStruct.numberOfClosingTags(line);
//                    int openingTagCount = calculateControlStruct.numberOfOpeningTags(line);
//                    System.out.println(codeSegment);
//
//                    if (closingTagCount > 0) {
//                        for (int i = 0; i < closingTagCount; i++) {
//                            currentCcs = (int) ccsStack.pop();
//                        }
//                    }
//                    if (type.isEmpty()) {
//                        if (openingTagCount > 0) {
//                            ccsStack.push(currentCcs);
//                        }
//                        row = new Object[]{index++, line, cs, cv, cm, ci, ccp, ccs};
//                        totalccs += ccs;
////                this.lineComplexityTableModel.addRow(new Object[]{lineObj.lineNumber, lineObj.statement, null, null, null, 0});
//                    } else {
////                        weight = calculateControlStruct.getWeight(type);
////                        nc = calculateControlStruct.getNumberOfConditions(codeSegment);
////                        ccpps = (int) ccsStack.lastElement();
////                        ccs = (weight * nc) + ccpps;
//                        currentCcs = ccs;
//                        if (openingTagCount > 0) {
//                            ccsStack.push(currentCcs);
//                        }
//                        row = new Object[]{index++, line, cs, cv, cm, ci, ccp, ccs};
//                    }
//
//
//                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//
//                    model.addRow(row);
//
//                }
//        return 0;
//        
//    }
//    
//}
