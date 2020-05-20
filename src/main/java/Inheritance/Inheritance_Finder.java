package Inheritance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Samanmali
 */
public class Inheritance_Finder {

    private static final List<String> keywords = Arrays.asList("extends ", "implements ", ",", ":");

    public static void main(String[] args) throws Exception {

        int ndi = 0, nIndi = 0, ci = 0, tot = 0, total = 0, count = 0;

        try {
            File file = new File("C:\\Users\\Samanmali\\Documents\\DaysPerMonth.txt");
            BufferedReader breader = new BufferedReader(new FileReader(file));
            String line1;
            while ((line1 = breader.readLine()) != null) {

                String[] words = line1.split("\\s+");
                
                String superclass;
                for (int i = 0; i < words.length; i++) {

                    if ("class".equals(words[i])) {

                        System.out.println(words[i + 1].toString() + " Direct Inheritance = " + directInheritance(words[i + 1].toString()));
                        ndi = directInheritance(words[i + 1].toString());
                        superclass = words[i + 1].toString();

                        if (words.length > 4) {
                            if ("extends".equals(words[i + 2])) {
                                System.out.println(words[i + 1] + " Indirect Inheritance = " + indeirectInheritance(words[i + 3], words[i + 1]));
                                nIndi = indeirectInheritance(words[i + 3], words[i + 1]);
                            }
                        } else {
                            nIndi = 0;
                            System.out.println(words[i + 1] + " Indirect Inheritance = " + nIndi);
                        }

                        total = ndi + nIndi;
                        System.out.println(words[i + 1] + " total = " + total);
                        ci = ndi + nIndi;
                        System.out.println(words[i + 1] + " Ci = " + ci);
                        tot = ci + tot;

                        String k;
                        k = words[i + 1];
                        count++;
                        ArrayList<String> out = new ArrayList<>();

                        out.add(k);
                        out.add(Integer.toString(ndi));
                        out.add(Integer.toString(nIndi));
                        out.add(Integer.toString(ci));
                        out.add(Integer.toString(total));
                        System.out.println("\n" + out + "\n");
                    }
                }
            }
            System.out.println("Total CI = " + tot);

            breader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int indeirectInheritance(String extendclass, String classname) {
        String line = null;
        int indi = 0;

        try {
            File file = new File("C:\\Users\\Samanmali\\Documents\\DaysPerMonth.txt");
            BufferedReader breader = new BufferedReader(new FileReader(file));
            while ((line = breader.readLine()) != null) {

                String[] words1 = line.split("\\s+");

                int di = 0;

                if (directInheritance(classname) == 0) {
                    indi = 0;
                }
                if (directInheritance(classname) == 1) {

                    if (directInheritance(extendclass) == 0) {
                        indi = 0;
                    } else {
                        indi = 1;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return indi;
    }

    public static int directInheritance(String classname) {

        int di = 0;
        try {

            File file = new File("C:\\Users\\Samanmali\\Documents\\DaysPerMonth.txt");
            BufferedReader breader11 = new BufferedReader(new FileReader(file));
            String line1;

            while ((line1 = breader11.readLine()) != null) {
                String[] word = line1.split("\\s+");
                for (int x = 0; x < word.length; x++) {
                    if ("class".equals(word[x])) {
                        if (word.length > 4) {
                            if (classname.equals(word[x + 1])) {
                                di++;
                            }
                        }
                    }
                }
            }
            breader11.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return di;
    }

}
