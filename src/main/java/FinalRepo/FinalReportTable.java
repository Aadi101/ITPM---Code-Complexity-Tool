/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalRepo;

import Commons.Weights;
import ControlStructure.CalculateControlStruct;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class FinalReportTable extends javax.swing.JFrame {

    Stack ccsStack = new Stack();
    int currentCcs = 0;
    String[] lines ;
    int parentIindex = 0;
    ArrayList<String> classNames = new ArrayList<>();

    /**
     * Creates new form FinalReportTable
     */
    public FinalReportTable(String code) {
        initComponents();
        lines = code.split("\n");
        calculateFinalValues();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Line no", "Program statements", "Cs", "Cv", "Cm", "Ci", "Ccp", "Ccs", "TCps"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setMinWidth(500);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(500);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1039, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void calculateFinalValues() {
       int index = 1;
       int totalCi = 0;
       for(String line : lines){
           
           int ccs = this.calculateControlStructs(line);
           int ci = this.calculateInheritance(line);
           //Add other functions========================================================================================
           int cs=0;
           int cv=0;
           int cm=0;
           int ccp=0;
           
           totalCi += ci;
           Object[] row = new Object[]{index++, line, cs, cv, cm, ci, ccp, ccs};
           DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
           model.addRow(row);
       }
//        System.out.println(val);
    }

    private int calculateControlStructs(String line){
        
                    CalculateControlStruct calculateControlStruct = new CalculateControlStruct();
                    Object[] row;
                    int weight = 0;
                    int nc = 0;
                    int ccpps = 0;
                    int ccs = 0;
                    int totalccs = 0;
                    String codeSegment = calculateControlStruct.getControllerCodeSegment(line);
                    String type = calculateControlStruct.getGontrolStructureType(codeSegment);
                    int closingTagCount = calculateControlStruct.numberOfClosingTags(line);
                    int openingTagCount = calculateControlStruct.numberOfOpeningTags(line);
                    System.out.println(codeSegment);

                    if (closingTagCount > 0) {
                        for (int i = 0; i < closingTagCount; i++) {
                            currentCcs = (int) ccsStack.pop();
                        }
                    }
                    if (type.isEmpty()) {
                        if (openingTagCount > 0) {
                            ccsStack.push(currentCcs);
                        }
                        row = new Object[]{ccs};
//                this.lineComplexityTableModel.addRow(new Object[]{lineObj.lineNumber, lineObj.statement, null, null, null, 0});
                    } else {
                        weight = calculateControlStruct.getWeight(type);
                        nc = calculateControlStruct.getNumberOfConditions(codeSegment);
                        ccpps = (int) ccsStack.lastElement();
                        ccs = (weight * nc) + ccpps;
                        currentCcs = ccs;
                        totalccs += ccs;
                        if (openingTagCount > 0) {
                            ccsStack.push(currentCcs);
                        }
                        row = new Object[]{ccs};
                    }

        
        return totalccs;
    }
    
    
    private int calculateInheritance(String line){
        
        int ndi = 0, nIndi = 0, ci = 0, tot = 0, total = 0, count = 0;
                String[] words = line.split("\\s+");

                String superclass;
                    for (int i = 0; i < words.length; i++) {

                        if ("class".equals(words[i])) {

                            ndi = directInheritance(words[i + 1].toString(), line);
                            superclass = words[i + 1].toString();

                            if (words.length > 4) {
                                if ("extends".equals(words[i + 2])) {

                                    nIndi = indeirectInheritance(words[i + 3], words[i + 1], line);
                                }
                            } else {
                                nIndi = 0;
                                System.out.println(words[i + 1] + " Indirect Inheritance = " + nIndi);
                            }

                            String k;
                            k = words[i + 1];
                            
                            classNames.add(k);
                            int weigthDueToInherit = this.calculateWeightDueToNumOfInheritance(k);
                            count++;
                            ArrayList<String> out = new ArrayList<>();
                            ndi *= weigthDueToInherit;
                            nIndi *= weigthDueToInherit;
                            total = ndi + nIndi;
                            System.out.println(words[i + 1] + " total = " + total);
                            ci = ndi + nIndi;
                            System.out.println(words[i + 1] + " Ci = " + ci);

                            tot = ci + tot;             
                        }
                    }
                    return ci;   
    }
    
    public int directInheritance(String classname, String line) {

        int di = 0;
        try {
                String[] word = line.split("\\s+");
                for (int x = 0; x < word.length; x++) {
                    if ("class".equals(word[x])) {
                        if (word.length > 4) {
                            if (classname.equals(word[x + 1])) {
                                di++;
                            }
                        }
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return di;
    }

    public int indeirectInheritance(String extendclass, String classname, String line) {
        int indi = 0;

        try {

                String[] words1 = line.split("\\s+");

                int di = 0;
                // for (int x =0; x < words1.length ; x++) {

                if (directInheritance(classname, line) == 0) {
                    indi = 0;
                }
                if (directInheritance(classname, line) == 1) {

                    if (directInheritance(extendclass, line) == 0) {
                        indi = 0;
                    } else {
                        indi = 1;
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return indi;
    }
    
    
    public int calculateWeightDueToNumOfInheritance(String className) {
        int weight = 0;
      
        int numOfFounds = 0;
        for (int i = 0; i < classNames.size(); i++) {
            if (className.equals(classNames.get(i))) {
                numOfFounds += 1;
            }
        }
        switch (numOfFounds) {
            case 0:
                return Weights.oneUserDefinedInheritance;
            case 1:
                return Weights.twoUserDefinedInheritance;
            case 2:
                return Weights.threeUserDefinedInheritance;
            default: {
                if (numOfFounds > 3) {
                    return Weights.moreThanThreeUserDefinedInheritance;
                }
            }
        }
        return Weights.noInheritance;
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FinalReportTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinalReportTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinalReportTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinalReportTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinalReportTable(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
