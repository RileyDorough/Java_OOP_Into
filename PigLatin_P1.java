import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class PigLatin_P1 {
    public static void main(String[] args){

        try{
                                                            // String path = "Your path to your test file";
                                                            // I created this program on VS Code within my Kali VM
                                                            // The home directory for your device will be different than it is for me
            String path = System.getProperty("user.dir").toString().concat("/in.txt");
            System.out.println(path);
            File infile = new File(path);
            Scanner inline = new Scanner(infile);
            String word = null;
            ArrayList<String> compilation = new ArrayList<>();        

            while(inline.hasNext()){
                word = inline.next();
                System.out.print(word+": ");
                System.out.println(getSpecialCharacterCount(word));
                if (getSpecialCharacterCount(word)){
                    if (startsWithVowlCheck(word)){
                        System.out.println("\t\tStarts with vowls");
                        prepareToOutput(1,word,compilation);
                    }
                    if (startsWithConsonantCheck(word)){
                        System.out.println("\t\tStarts with consonants");
                        prepareToOutput(2,word,compilation);
                    }
                }
                if (!getSpecialCharacterCount(word)){
                    if (startsWithVowlCheck(word)){
                        System.out.println("\t\tStarts with vowls");
                        prepareToOutput(3,word,compilation);
                    }
                    if (startsWithConsonantCheck(word)){
                        System.out.println("\t\tStarts with consonants");
                        prepareToOutput(4,word,compilation);
                    }
                }
            }
            inline.close();
            output(compilation);
        }
        catch(IOException e){
            System.out.println(e.getCause()+"\n");
        }
        catch(Exception e){
            System.out.println(e+"\n");
        }
    }

    public static void prepareToOutput(int ID, String words, ArrayList<String> compilation){
        char[] letters = words.toCharArray();
        

        if(ID==1){
            String newWord = "";
            for(int i = 0; i<(letters.length-1); i++){
                newWord += letters[i];
            }
            int end = letters.length;
            newWord += "ay" + letters[end-1];
            System.out.println(newWord);
            compilation.add(newWord);
        }

        if(ID==2){
            int end = letters.length;
            String newWord = "";
            for(int i=1; i<(end-1); i++){
                newWord += letters[i];
            }
            newWord += letters[0] + "ay" + letters[end-1];
            compilation.add(newWord);
            System.out.println(newWord);
        }

        if(ID==3){
            String newWord = words+"ay";
            System.out.println(newWord);
            compilation.add(newWord);
        }

        if(ID==4){
            int end = letters.length;
            String newWord = "";
            for(int i=1; i<end; i++){
                newWord += letters[i];
            }
            newWord += letters[0] + "ay";
            compilation.add(newWord);
            System.out.println(newWord);
        }
    }

    public static void output(ArrayList<String> words){
 
        File outFile = new File("out.txt");

        try{
            FileWriter testfile = new FileWriter(outFile);
            for(int i=0; i<words.size(); i++){
                testfile.write(words.get(i)+" ");
            }

            testfile.close();
        }

        catch(IOException e){
            System.out.println(e.getCause()+"\n");
        }
        catch(Exception e){
            System.out.println(e+"\n");
        }
    }

    public static Boolean getSpecialCharacterCount(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false;
        }
        Pattern p = Pattern.compile("[^A-Za-z]");
        Matcher m = p.matcher(s);
        //boolean b = m.matches();
        boolean b = m.find();
        if (b) { 
            return true;
        }
        else {
            return false;
        }
    }

    public static Boolean startsWithVowlCheck(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false;
        }
        Pattern p = Pattern.compile("^a|^e|^i|^o|^u", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(s);
        //boolean b = m.matches();
        boolean b = m.find();
        if (b) { 
            return true;
        }
        else {
            return false;
        }
    }

    public static Boolean startsWithConsonantCheck(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false;
        }
        Pattern p = Pattern.compile("^[^a|^e|^i|^o|^u]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(s);
        //boolean b = m.matches();
        boolean b = m.find();
        if (b) { 
            return true;
        }
        else {
            return false;
        }
    }
}

