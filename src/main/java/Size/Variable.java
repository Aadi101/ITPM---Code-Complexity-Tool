/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Size;

import Commons.Weights;

/**
 *
 * @author ISHU
 */
public class Variable {

    private String codeLine = "public class Ashan{";
    private boolean insideClass = false;
    private boolean insideMethod = false;
    private int wvs = 0;
    private int npdtv = 0;
    private int ncdtv = 0;

    public String getCodeLine() {
        return codeLine;
    }

    public void setCodeLine(String codeLine) {
        this.codeLine = codeLine;
    }

    public boolean isInsideClass() {
        return insideClass;
    }

    public void setInsideClass(boolean insideClass) {
        this.insideClass = insideClass;
    }

    public boolean isInsideMethod() {
        return insideMethod;
    }

    public void setInsideMethod(boolean insideMethod) {
        this.insideMethod = insideMethod;
    }

    public int getWvs() {
        return wvs;
    }

    public void setWvs(int wvs) {
        this.wvs = wvs;
    }

    public int getNpdtv() {
        return npdtv;
    }

    public void setNpdtv(int npdtv) {
        this.npdtv = npdtv;
    }

    public int getNcdtv() {
        return ncdtv;
    }

    public void setNcdtv(int ncdtv) {
        this.ncdtv = ncdtv;
    }

    public void classDeclaration() {
        if (codeLine.contains("class")) {
            insideClass = true;
        }
    }

    public void methodDeclaration() {
        Size size = new Size();
        size.setTextLine(codeLine);
        if (size.isMethodDeclarationFound()) {
            insideClass = false;
            insideMethod = true;
        }
    }

    public void findVariable() {
        this.classDeclaration();
        this.methodDeclaration();

        Size size = new Size();
        size.setTextLine(codeLine);

        if (!codeLine.contains("import")) {
            if (size.isVariableOrObjectOrDataStructure()) {
                if (insideClass) {
                    wvs += Weights.globalVariable;
                    if (size.getSumOfPrimitiveVariables() > 0) {
                        npdtv += Weights.primitiveDataType;
                    } else {
                        ncdtv += Weights.compositeDataType;
                    }
                } else {
                    wvs += Weights.localVariable;
                    if (size.getSumOfPrimitiveVariables() > 0) {
                        npdtv += Weights.primitiveDataType;
                    } else {
                        ncdtv += Weights.compositeDataType;
                    }
                }
            }
        }
    }
}
