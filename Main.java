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
    public String readbychar(String filename) {
        StringBuilder re = new StringBuilder();
        File file = new File(filename);
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                    re.append((char) tempchar);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return re.toString();
    }

    public String removezero(String str) {
        int len = str.length(), i = 0;
        if(str.length()==1){
            if(str.charAt(0)=='0'){
                return str;
            }
        }
        while (i < len-1&& str.charAt(i) == '0') {
            i++;
        }
        return str.substring(i);
    }

    public static void main(String[] args) {
        Main work = new Main();
        String yuanma = work.readbychar(args[0]);
        int len = yuanma.length();
        StringBuilder token = new StringBuilder();
        int i = 0;
        while (i < len) {
            if (Character.isLetter(yuanma.charAt(i))) {
                while (i < len && (Character.isLetter(yuanma.charAt(i)) || Character.isDigit(yuanma.charAt(i)))) {
                    token.append(yuanma.charAt(i));
                    i++;
                }
                switch (token.toString()) {
                    case "BEGIN":
                        System.out.println("Begin");
                        break;
                    case "END":
                        System.out.println("End");
                        break;
                    case "FOR":
                        System.out.println("For");
                        break;
                    case "IF":
                        System.out.println("If");
                        break;
                    case "THEN":
                        System.out.println("Then");
                        break;
                    case "ELSE":
                        System.out.println("Else");
                        break;
                    default:
                        System.out.println("Ident(" + token.toString() + ")");
                        break;
                }
                token.delete(0, token.length());
                continue;
            }
            if (Character.isDigit(yuanma.charAt(i))) {
                while (i < len && Character.isDigit(yuanma.charAt(i))) {
                    token.append(yuanma.charAt(i));
                    i++;
                }
                System.out.println("Int(" + work.removezero(token.toString()) + ")");
                token.delete(0, token.length());
                continue;
            }
            if (yuanma.charAt(i) == ':') {
                if (i + 1 < len && yuanma.charAt(i + 1) == '=') {
                    System.out.println("Assign");
                    i = i + 2;
                    continue;
                } else {
                    System.out.println("Colon");
                    i++;
                    continue;
                }
            }
            if (yuanma.charAt(i)=='+'){
                System.out.println("Plus");
                i++;
                continue;
            }
            if(yuanma.charAt(i)=='*'){
                System.out.println("Star");
                i++;
                continue;
            }
            if(yuanma.charAt(i)==','){
                System.out.println("comma");
                i++;
                continue;
            }
            if(yuanma.charAt(i)=='('){
                System.out.println("LParenthesis");
                i++;
                continue;
            }
            if(yuanma.charAt(i)==')'){
                System.out.println("RParenthesis");
                i++;
                continue;
            }
            if(yuanma.charAt(i)==' '||yuanma.charAt(i)=='\t'||yuanma.charAt(i)=='\n'||yuanma.charAt(i)=='\r'){
                i++;
                continue;
            }
            System.out.println("Unknown");
            break;


        }
    }
}
