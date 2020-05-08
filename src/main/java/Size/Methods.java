/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Size;

/**
 *
 * @author ISHU
 */
public class Methods {
    public int cm = 0;
    public int wmrt = 0;
    public int npdtp = 0;
    public int ncdtp = 0;
    private String textLine = "";

    public int getCm() {
        return cm;
    }

    public void setCm(int cm) {
        this.cm = cm;
    }

    public int getWmrt() {
        return wmrt;
    }

    public void setWmrt(int wmrt) {
        this.wmrt = wmrt;
    }

    public int getNpdtp() {
        return npdtp;
    }

    public void setNpdtp(int npdtp) {
        this.npdtp = npdtp;
    }

    public int getNcdtp() {
        return ncdtp;
    }

    public void setNcdtp(int ncdtp) {
        this.ncdtp = ncdtp;
    }

    public String getTextLine() {
        return textLine;
    }

    public void setTextLine(String textLine) {
        this.textLine = textLine;
    }

    public void checkMethods(){
        Size size = new Size();
        size.setTextLine(textLine);
        if (size.isMethodDeclarationFound()){
            if (size.isPrimitiveReturnType()){
                wmrt += 1;
                npdtp += 1;
            } else if (size.isCompositeReturnType()){
                wmrt += 2;
                ncdtp += 1;
            } else if (size.isVoidReturnType()){
                npdtp += 1;
            }
        }
    }
}
