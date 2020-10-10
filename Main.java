import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

/**
 * @Classname work
 * @Description TODO
 * @Date 2020/10/10 21:31
 * @Created by lrf
 */
public class Main {
    public String readbychar(String filename){
        StringBuilder re= new StringBuilder();
        File file = new File(filename);
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                if (((char) tempchar) != '\r') {
                    re.append(tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return re.toString();
    }
    public  String removezero(String str){
        int len = str.length(), i = 0;
        while (i < len && str.charAt(i) == '0') {
            i++;
        }
        return str.substring(i);
    }
    public static void main(String[] args) {
        Main work=new Main();
        String yuanma=work.readbychar(args[0]);
        String []arr=yuanma.split("\\s+");
        int len=arr.length;
        for (String s : arr) {
            if (s.equals("BEGIN")) {
                System.out.println("Begin");
                continue;
            }
            if (s.equals("END")) {
                System.out.println("End");
                continue;
            }
            if (s.equals("FOR")) {
                System.out.println("For");
                continue;
            }
            if (s.equals("IF")) {
                System.out.println("If");
                continue;
            }
            if (s.equals("THEN")) {
                System.out.println("Then");
                continue;
            }
            if (s.matches("^[A-Za-z][A-Za-z0-9]*$")) {
                System.out.println("Ident(" + s + ")");
                continue;
            }
            if (s.matches("^[0-9]+$")) {
                System.out.println("Int(" + work.removezero(s) + ")");
                continue;
            }
            if (s.equals(":")) {
                System.out.println("Colon");
                continue;
            }
            if (s.equals("+")) {
                System.out.println("Plus");
                continue;
            }
            if (s.equals("*")) {
                System.out.println("Star");
                continue;
            }
            if (s.equals("(")) {
                System.out.println("LParenthesis");
                continue;
            }
            if (s.equals(")")) {
                System.out.println("RParenthesis");
                continue;
            }
            if (s.equals(":=")) {
                System.out.println("Assign");
                continue;
            }
            System.out.println("Unknown");
            break;
        }


    }
}
