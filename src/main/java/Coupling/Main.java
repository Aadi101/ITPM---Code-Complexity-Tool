/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coupling;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class Main extends javax.swing.JFrame {

    public ClassObj classes[]; //ClassObj cobj = new ClassObj();
    DefaultTableModel model;
    int selectedIndex;
    
    public int Wmcms;
    public int Wrmcrms;
    public int Wmcrms;
    public int Wrmcms;
    public int Wmrgvs;
    public int Wrmrgvs;
    public int Wmcmd;
    public int Wmcrmd;
    public int Wrmcrmd;
    public int Wrmcmd;
    public int Wmrgvd; 
    public int Wrmrgvd;
    public int Wr;
    
    EditWeights ew;
    
    //Used when single file is selected from the main GUI
    public String fpath;
    /** 
     * Creates new form Main
     */
    public Main() {
        initComponents();
        model = new DefaultTableModel();
        jTable1.setModel(model);
        model.addColumn("Class Name");
        ew = new EditWeights();
        jButton3.setEnabled(false);

    }
    
    public Main(String _fpath){
        initComponents();
        model = new DefaultTableModel();
        jTable1.setModel(model);
        model.addColumn("Class Name");
        ew = new EditWeights();
        
        if(!_fpath.isEmpty()){
            jButton1.setEnabled(false);
            jTextField1.setText(_fpath);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        selectedFile = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Source Path :");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Browse ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Analyze");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Classes");

        selectedFile.setText("Selected File");
        selectedFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedFileActionPerformed(evt);
            }
        });

        jButton4.setText("Full Project");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Lemon", 0, 30)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Coupling Complexity");

        jButton5.setText("Print Functions");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Edit Weights");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton3.setText("Clear Selection");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(88, 88, 88)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                            .addComponent(selectedFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(63, 63, 63)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectedFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton3.setEnabled(false );
        jTextField1.setText("");
        String fpath = "";
        //jTextField1.setText("C:\\Users\\Tharindu\\Desktop\\A");
        JFileChooser fileChooser = new JFileChooser();
        //fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("ZIP FILES", "zip", "zip");
        fileChooser.setFileFilter(filter);
        int option = fileChooser.showOpenDialog(this);
        if(option == JFileChooser.APPROVE_OPTION){
           File file = fileChooser.getSelectedFile();
           jTextField1.setText(file.getAbsolutePath());
           fpath = file.getAbsolutePath();
        }else{
          jTextField1.setText(null);
        }
        
        //Execute only for zip files
        if(fpath.contains(".zip")){
            String zipFilePath = fpath;
            String destDirectory = fpath.substring(0,fpath.lastIndexOf("\\"));
            System.out.println("destDirectory : "+destDirectory);
            unzip unzipper = new unzip();
            try {
                unzipper.unzip(zipFilePath, destDirectory);
                System.out.println("Done");
            } catch (Exception ex) {
                // some errors occurred
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        updateWeights();
        String FolderPath = jTextField1.getText().toString();
        
        if(!FolderPath.contains(".java")){
            if(FolderPath.contains(".zip")){
                FolderPath = FolderPath.substring(0,FolderPath.lastIndexOf("\\"));
            }
            //C;\\User\\Desktop\\CC\\aa.zip
            getFileContent gfc = new getFileContent();
            Extraction ex = new Extraction();

            List <File> FL = gfc.getFileList(FolderPath);
            int NoOfFiles = FL.size();

            classes = new ClassObj[NoOfFiles];

            for(int i = 0; i < NoOfFiles; i++){
                System.out.println(" -------------- Starting class "+i+" init process -------------- ");
                System.out.println("Location : "+FL.get(i).toString());

                System.out.println("Extracting class name from file");
                String cName = gfc.getClassNameFromFilePath(FL.get(i).toString());
                System.out.println("Extracting name from file - Done.");

                classes[i] = new ClassObj();
                classes[i].setClassName(cName);
                System.out.println("Class obj initialized and name assigned : successful");

                System.out.println("Set file content to class obj");
                classes[i].setContent(gfc.readFileToArrayList(FL.get(i).toString()));
                System.out.println("content set : Done");

                System.out.println("Calculating depth");
                classes[i].setDepthInfo(ex.calcDepth(classes[i].getContent()));
                System.out.println("Depth info set : Done");

                System.out.println("Setting function list to obj");
                classes[i].setFunctions(ex.extractFunctionNames(classes[i].getContent(), classes[i].getDepthInfo(),cName.toLowerCase()));
                System.out.println("Functions set insert: Done");

                System.out.println("Initalizing MethodArray");
                classes[i].initMethodArray(classes[i].getMethodCount());
                System.out.println("InitMethodArray : Done | "+classes[i].getMethodCount()+" methods.");


                for(int j = 0; j < classes[i].getMethodCount(); j++){
                    System.out.println("--- Method :"+j+" -> "+classes[i].getFunctionName(j));
                    classes[i].assignMethodContent(ex.extractFunctionBody(classes[i].getContent(), classes[i].getDepthInfo(), classes[i].getFunctionName(j)), j,classes[i].getFunctionName(j));
                }


                classes[i].setRecursiveFunctions(ex.extractRecursiveFunctionNames(classes[i].getAllMethods()));
                classes[i].setRegularFunctions(ex.extractRegularFunctionNames(classes[i].getFunctions(), classes[i].getRecursiveFunctionsList()));

                System.out.println("recursiveCount : " + classes[i].getRecursiveFunctionsList().size());
                System.out.println("regularCount : " + classes[i].getRegularFunctionsList().size());
                System.out.println(classes[i].getRecursiveFunctionsList());
                System.out.println(classes[i].getRegularFunctionsList());

                System.out.println(" -------------- Class "+i+" Complete --------------  \n");


            }

            int rowCount = model.getRowCount();
            if(rowCount>0){
                for(int i = 0; i<rowCount; i++){
                    model.removeRow(0);
                }
            }

            for(int i=0; i < classes.length; i++){
                model.addRow(new Object[]{classes[i].getName()});//This line can be a false positive in function detection (),{
            }
            System.out.println("Count end ::::: "+model.getRowCount());
        
        }
        else{//if selected is a single java file 
            processesSingleFile(FolderPath);
            int rowCount = model.getRowCount();
            if(rowCount>0){
                for(int i = 0; i<rowCount; i++){
                    model.removeRow(0);
                }
            }

            for(int i=0; i < classes.length; i++){
                model.addRow(new Object[]{classes[i].getName()});//This line can be a false positive in function detection (),{
            }
            System.out.println("Count end ::::: "+model.getRowCount());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public String processesSingleFile(String FilePath){
    
            getFileContent gfc = new getFileContent();
            Extraction ex = new Extraction();

            //List <File> FL = gfc.getFileList(FolderPath);
            int NoOfFiles = 1;

            classes = new ClassObj[NoOfFiles];

            for(int i = 0; i < NoOfFiles; i++){
                System.out.println(" -------------- Starting class "+i+" init process -------------- ");
                //System.out.println("Location : "+FL.get(i).toString());

                System.out.println("Extracting class name from file");
                String cName = gfc.getClassNameFromFilePath(FilePath);
                System.out.println("Extracting name from file - Done.");

                classes[i] = new ClassObj();
                classes[i].setClassName(cName);
                System.out.println("Class obj initialized and name assigned : successful");

                System.out.println("Set file content to class obj");
                classes[i].setContent(gfc.readFileToArrayList(FilePath));
                System.out.println("content set : Done");

                System.out.println("Calculating depth");
                classes[i].setDepthInfo(ex.calcDepth(classes[i].getContent()));
                System.out.println("Depth info set : Done");

                System.out.println("Setting function list to obj");
                classes[i].setFunctions(ex.extractFunctionNames(classes[i].getContent(), classes[i].getDepthInfo(),cName.toLowerCase()));
                System.out.println("Functions set insert: Done");

                System.out.println("Initalizing MethodArray");
                classes[i].initMethodArray(classes[i].getMethodCount());
                System.out.println("InitMethodArray : Done | "+classes[i].getMethodCount()+" methods.");


                for(int j = 0; j < classes[i].getMethodCount(); j++){
                    System.out.println("--- Method :"+j+" -> "+classes[i].getFunctionName(j));
                    classes[i].assignMethodContent(ex.extractFunctionBody(classes[i].getContent(), classes[i].getDepthInfo(), classes[i].getFunctionName(j)), j,classes[i].getFunctionName(j));
                }


                classes[i].setRecursiveFunctions(ex.extractRecursiveFunctionNames(classes[i].getAllMethods()));
                classes[i].setRegularFunctions(ex.extractRegularFunctionNames(classes[i].getFunctions(), classes[i].getRecursiveFunctionsList()));

                System.out.println("recursiveCount : " + classes[i].getRecursiveFunctionsList().size());
                System.out.println("regularCount : " + classes[i].getRegularFunctionsList().size());
                System.out.println(classes[i].getRecursiveFunctionsList());
                System.out.println(classes[i].getRegularFunctionsList());

                System.out.println(" -------------- Class "+i+" Complete --------------  \n");
        }
            
        return "";
    }
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        selectedIndex = jTable1.getSelectedRow();
    }//GEN-LAST:event_jTable1MouseClicked

    private void selectedFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedFileActionPerformed
        updateWeights();
        int index = jTable1.getSelectedRow();
        System.out.println("Selected row : "+index);
        
        Calculate calc = new Calculate(classes[index].getRegularFunctionsList(),
                                        classes[index].getRecursiveFunctionsList(),
                                        classes[index].getAllMethods(),
                                        classes[index].getGlobalVariables());
        
        int Nrmcrms = calc.Nrmcrms_recursiveToRecursive();
        int Nmcms = calc.Nmcms_regularToRegular();
        int Nmcrms = calc.Nmcrms_regularToRecursive();
        int Nrmcms = calc.Nrmcms_recursiveToRegular();
        
        int Nmrgvs = calc.Nmrgvs_regularToGlobalVariables();
        int Nrmrgvs = calc.Nrmrgvs_recursiveToGlobalVariables();
        
        //Weights
//        int Wrmcrms = 1;
//        int Wmcms = 1;
//        int Wmcrms = 1;
//        int Wrmcms = 1;
//        int Wmrgvs = 1;
//        int Wrmrgvs = 1;
        
        //Calculating Complexity
        Nrmcrms = Nrmcrms * Wrmcrms;
        Nmcms = Nmcms * Wmcms;
        Nmcrms = Nmcrms * Wmcrms; 
        Nrmcms = Nrmcms * Wrmcms;
        Nmrgvs = Nmrgvs * Wmrgvs; 
        Nrmrgvs = Nrmrgvs * Wrmrgvs;
        
        System.out.println("Nmcms Nrmcrms Nmcrms Nrmcms Nmrgvs Nrmrgvs : "+Nmcms+" "+Nrmcrms+" "+Nmcrms+" "+Nrmcms+" "+Nmrgvs+" "+Nrmrgvs);
        
        calc.CC(selectedIndex, classes);
        
        int Nmcmd = calc.getNmcmd();
        int Nmcrmd = calc.getNmcrmd();
        int Nrmcrmd = calc.getNrmcrmd();
        int Nrmcmd= calc.getNrmcmd();
        int Nmrgvd = calc.getNmrgvd();
        int Nrmrgvd = calc.getNrmrgvd();
        
        //Weights
//        int Wmcmd = 3;
//        int Wmcrmd = 4;
//        int Wrmcrmd = 5;
//        int Wrmcmd= 4;
//        int Wmrgvd = 2;
//        int Wrmrgvd = 2;
         
        
        Nmcmd = Nmcmd * Wmcmd;
        Nmcrmd = Nmcrmd * Wmcrmd;
        Nrmcrmd = Nrmcrmd * Wrmcrmd;
        Nrmcmd = Nrmcmd * Wrmcmd;
        Nmrgvd = Nmrgvd * Wmrgvd;
        Nrmrgvd = Nrmrgvd * Wrmrgvd ;
        
        System.out.println("Nmcmd Nmcrmd Nrmcrmd Nrmcmd Nmrgvd Nrmrgvd : "+ Nmcmd+","+Nmcrmd+","+Nrmcrmd+","+Nrmcmd+","+Nmrgvd+","+Nrmrgvd);
        
        int cc[]= new int[]{Nmcms,Nrmcrms,Nmcrms,Nrmcms,Nmrgvs,Nrmrgvs,Nmcmd,Nmcrmd,Nrmcrmd,Nrmcmd,Nmrgvd,Nrmrgvd};
        
        int tot = Nmcms + Nrmcrms + Nmcrms + Nrmcms + Nmrgvs + Nrmrgvs + Nmcmd  + Nmcrmd + Nrmcrmd + Nrmcmd + Nmrgvd + Nrmrgvd ;
        
//      Nmcms,Nrmcrms,Nmcrms,Nrmcms,Nmrgvs,Nrmrgvs,Nmcmd,Nmcrmd,Nrmcrmd,Nrmcmd,Nmrgvd,Nrmrgvd

//      ___________________________________________________________________________________________
        //////////////////////////        Setting up results page        //////////////////////////

        SingleFileResult sfr = new SingleFileResult();
        sfr.setFileName(classes[index].getName());
        
        DefaultTableModel model1 = new DefaultTableModel();
        sfr.jTable1.setModel(model1);
        model1.addColumn("Nmcms"); model1.addColumn("Nrmcrms"); model1.addColumn("Nmcrms"); model1.addColumn("Nrmcms"); model1.addColumn("Nmrgvs"); model1.addColumn("Nrmrgvs"); model1.addColumn("Nmcmd"); model1.addColumn("Nmcrmd"); model1.addColumn("Nrmcrmd"); model1.addColumn("Nrmcmd"); model1.addColumn("Nmrgvd"); model1.addColumn("Nrmrgvd"); model1.addColumn("Ccp");
        
        model1.addRow(new Object[]{Nmcms,Nrmcrms,Nmcrms,Nrmcms,Nmrgvs,Nrmrgvs,Nmcmd,Nmcrmd,Nrmcrmd,Nrmcmd,Nmrgvd,Nrmrgvd,tot});
        sfr.setVisible(true);
    }//GEN-LAST:event_selectedFileActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int Index = jTable1.getSelectedRow();
        Method [] m;
        
        m = classes[Index].getAllMethods();
        
        for(int i = 0; i < m.length ; i++){
        
            System.out.println("----");
            
            System.out.println("Name: "+m[i].MethodName);
            System.out.println(m[i].getMethod());
            
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    int totalCom ;
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        updateWeights();
        int size = classes.length;
        
        ArrayList<String> complexities = new ArrayList();
        //complexities.add("Nrmcrms,Nmcms,Nmcrms,Nrmcms,Nmrgvs,Nrmrgvs,Nmcmd,Nmcrmd,Nrmcrmd,Nrmrgvd,Nmrgvd,Nrmcmd");
        
        SingleFileResult sfr = new SingleFileResult();
        DefaultTableModel model1 = new DefaultTableModel();
        sfr.jTable1.setModel(model1);
        
        model1.addColumn("File Name");model1.addColumn("Nmcms"); model1.addColumn("Nrmcrms"); model1.addColumn("Nmcrms"); model1.addColumn("Nrmcms"); model1.addColumn("Nmrgvs"); model1.addColumn("Nrmrgvs"); model1.addColumn("Nmcmd"); model1.addColumn("Nmcrmd"); model1.addColumn("Nrmcrmd"); model1.addColumn("Nrmcmd"); model1.addColumn("Nmrgvd"); model1.addColumn("Nrmrgvd"); model1.addColumn("Ccp");
        
        
        //Do the same thing over all the classes
        for(int a = 0 ; a<size; a++){
        
            Calculate calc = new Calculate(classes[a].getRegularFunctionsList(),
                                        classes[a].getRecursiveFunctionsList(),
                                        classes[a].getAllMethods(),
                                        classes[a].getGlobalVariables());
        
            int Nrmcrms = calc.Nrmcrms_recursiveToRecursive();
            int Nmcms = calc.Nmcms_regularToRegular();
            int Nmcrms = calc.Nmcrms_regularToRecursive();
            int Nrmcms = calc.Nrmcms_recursiveToRegular();

            int Nmrgvs = calc.Nmrgvs_regularToGlobalVariables();
            int Nrmrgvs = calc.Nrmrgvs_recursiveToGlobalVariables();

            //Weights
//            int Wrmcrms = 1;
//            int Wmcms = 1;
//            int Wmcrms = 1;
//            int Wrmcms = 1;
//            int Wmrgvs = 1;
//            int Wrmrgvs = 1;

            //Calculating Complexity
            Nrmcrms = Nrmcrms * Wrmcrms;
            Nmcms = Nmcms * Wmcms;
            Nmcrms = Nmcrms * Wmcrms; 
            Nrmcms = Nrmcms * Wrmcms;
            Nmrgvs = Nmrgvs * Wmrgvs; 
            Nrmrgvs = Nrmrgvs * Wrmrgvs;

            System.out.println("Nrmcrms Nmcms Nmcrms Nrmcms Nmrgvs Nrmrgvs : "+Nrmcrms+" "+Nmcms+" "+Nmcrms+" "+Nrmcms+" "+Nmrgvs+" "+Nrmrgvs);

            calc.CC(selectedIndex, classes);

            int Nmcmd = calc.getNmcmd();
            int Nmcrmd = calc.getNmcrmd();
            int Nrmcrmd = calc.getNrmcrmd();
            int Nrmcmd= calc.getNrmcmd();
            int Nmrgvd = calc.getNmrgvd();
            int Nrmrgvd = calc.getNrmrgvd();

            //Weights
//            int Wmcmd = 3;
//            int Wmcrmd = 4;
//            int Wrmcrmd = 5;
//            int Wrmcmd= 4;
//            int Wmrgvd = 2;
//            int Wrmrgvd = 2;
//            
            Nmcmd = Nmcmd * Wmcmd;
            Nmcrmd = Nmcrmd * Wmcrmd;
            Nrmcrmd = Nrmcrmd * Wrmcrmd;
            Nrmcmd = Nrmcmd * Wrmcmd;
            Nmrgvd = Nmrgvd * Wmrgvd;
            Nrmrgvd = Nrmrgvd * Wrmrgvd ;

            int total = Nmcms + Nrmcrms + Nmcrms + Nrmcms + Nmrgvs + Nrmrgvs + Nmcmd + Nmcrmd + Nrmcrmd + Nrmcmd + Nmrgvd + Nrmrgvd;
            totalCom += total;
            System.out.println("lololol :" + totalCom);
            System.out.println("Nmcmd Nmcrmd Nrmcrmd Nrmcmd Nmrgvd Nrmrgvd : "+ Nmcmd+","+Nmcrmd+","+Nrmcrmd+","+Nrmcmd+","+Nmrgvd+","+Nrmrgvd);
            //(Nrmcrms+","+Nmcms+","+Nmcrms+","+Nrmcms+","+Nmrgvs+","+Nrmrgvs+","+Nmcmd+","+Nmcrmd+","+Nrmcrmd+","+Nrmrgvd+","+Nmrgvd)
            complexities.add(Nrmcrms+","+Nmcms+","+Nmcrms+","+Nrmcms+","+Nmrgvs+","+Nrmrgvs+","+Nmcmd+","+Nmcrmd+","+Nrmcrmd+","+Nrmrgvd+","+Nmrgvd);
        
            model1.addRow(new Object[]{classes[a].getName(),Nmcms,Nrmcrms,Nmcrms,Nrmcms,Nmrgvs,Nrmrgvs,Nmcmd,Nmcrmd,Nrmcrmd,Nrmcmd,Nmrgvd,Nrmrgvd,total});

        }
        sfr.updateLables();
        sfr.UpTotalComplexity(totalCom);
        sfr.setVisible(true);
        System.out.println("Final Complexities");
        
        System.out.println("Nrmcrms,Nmcms,Nmcrms,Nrmcms,Nmrgvs,Nrmrgvs,Nmcmd,Nmcrmd,Nrmcrmd,Nrmrgvd,Nmrgvd,Nrmcmd");
        
        for(int i = 0; i< complexities.size(); i++){
            System.out.println("Class "+i+" :"+complexities.get(i));
        }
        
        int Nrmcrms=0;int Nmcms=0; int Nmcrms=0; int Nrmcms=0; int Nmrgvs= 0; int Nrmrgvs=0;
        int Nmcmd=0 ; int Nmcrmd=0; int Nrmcrmd=0; int Nrmrgvd=0; int Nmrgvd=0; int Nrmcmd=0;
        
        for(int i = 1; i < complexities.size(); i++){
            String x = complexities.get(i);
            String []tkns = x.split(",");
            int _Nrmcrms = Integer.parseInt(tkns[0]);
            int _Nmcms = Integer.parseInt(tkns[0]);
            int _Nmcrms = Integer.parseInt(tkns[0]);
            int _Nrmcms = Integer.parseInt(tkns[0]);
            int _Nmrgvs = Integer.parseInt(tkns[0]);
            int _Nrmrgvs = Integer.parseInt(tkns[0]);
            int _Nmcmd = Integer.parseInt(tkns[0]);
            int _Nmcrmd = Integer.parseInt(tkns[0]);
            int _Nrmcrmd = Integer.parseInt(tkns[0]);
            int _Nrmrgvd = Integer.parseInt(tkns[0]);
            int _Nmrgvd = Integer.parseInt(tkns[0]);
            int _Nrmcmd = Integer.parseInt(tkns[0]);
            
            Nrmcrms = Nrmcrms + _Nrmcrms;
            Nmcms = Nmcms + _Nmcms;
            Nmcrms = Nmcrms + _Nmcrms; 
            Nrmcms = Nrmcms + _Nrmcms;
            Nmrgvs = Nmrgvs + _Nmrgvs;
            Nrmrgvs = Nrmrgvs + _Nrmrgvs;
            Nmcmd = Nmcmd + _Nmcmd;
            Nmcrmd = Nmcrmd + _Nmcrmd;
            Nrmcrmd = Nrmcrmd + _Nrmcrmd;
            Nrmrgvd = Nrmrgvd + _Nrmrgvd;
            Nmrgvd = Nmrgvd + _Nmrgvd;
            Nrmcmd = Nrmcmd + _Nrmcmd;
            
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
            ew.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextField1.setText("");
        jButton3.setEnabled(false);
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    public void updateWeights(){
        Wmcms = ew.Wmcms;
        Wrmcrms = ew.Wrmcrms;
        Wmcrms = ew.Wmcrms;
        Wrmcms = ew.Wrmcms;
        Wmrgvs = ew.Wmrgvs;
        Wrmrgvs = ew.Wrmrgvs;
        Wmcmd = ew.Wmcmd;
        Wmcrmd = ew.Wmcrmd;
        Wrmcrmd = ew.Wrmcrmd;
        Wrmcmd = ew.Wrmcmd;
        Wmrgvd = ew.Wmrgvd;
        Wrmrgvd = ew.Wrmrgvd;
        Wr = ew.Wr;
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
                if ("Default Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton selectedFile;
    // End of variables declaration//GEN-END:variables
}
