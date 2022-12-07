import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/*
            Please ensure that your input file is located at the home directory of the user account processing this code
            REVIEW LINES 23, 24, 25, & 26 FOR MORE INFO ON INPUT FILES
*/

public class Lab2_Part4 {

    public static void main(String[] args){
        ArrayList<voter> master = new ArrayList<>();
        input(master);
        sortList(master);
        output(master);
    }

    public static void input(ArrayList<voter> master){
        try{
            String data = null;
                                                            // String path = "Your path to your test file";
                                                            // I created this program on VS Code within my Kali VM
                                                            // The home directory for your device will be different than it is for me
            String path = System.getProperty("user.dir").toString().concat("/ncvoter48.txt");
            System.out.println(path);
            File infile = new File(path);
            Scanner inline = new Scanner(infile);
            String[] dataArray;
            while(inline.hasNextLine()){
                data = inline.nextLine();
                dataArray = data.split("\t");
                master.add(new voter(
                dataArray[5].replace("\"", "").replace(" ", "").replace("\t", ""),
                dataArray[6].replace("\"", "").replace(" ", "").replace("\t", ""),
                dataArray[4].replace("\"", "").replace(" ", "").replace("\t", ""),
                dataArray[16].replace("\"", "").replace(" ", "").replace("\t", ""),
                dataArray[17].replace("\"", "").replace(" ", "").replace("\t", ""),
                dataArray[18].replace("\"", "").replace(" ", "").replace("\t", ""),
                dataArray[19].replace("\"", "").replace(" ", "").replace("\t", ""),
                dataArray[20].replace("\"", "").replace(" ", "").replace("\t", ""),
                dataArray[21].replace("\"", "").replace(" ", "").replace("\t", ""),
                dataArray[15].replace("\"", "").replace(" ", "").replace("\t", ""),
                dataArray[29].replace("\"", "").replace(" ", "").replace("\t", ""),
                dataArray[28].replace("\"", "").replace(" ", "").replace("\t", ""),
                dataArray[31].replace("\"", "").replace(" ", "").replace("\t", "")));
            }
            //System.out.println(master.get(0).getFirstName()+" "+master.get(0).getAge());
            master.remove(0);
            //System.out.println(master.get(0).getFirstName()+" "+master.get(0).getAge());
            inline.close();
        }
        catch(IOException e){
            System.out.println(e.getCause()+"\n");
        }
        catch(Exception e){
            System.out.println(e+"\n");
        }

    }

    public static void sortList(ArrayList<voter> master){
        Collections.sort(master, voter.voterComparitor);
    }

    public static void output(ArrayList<voter> master){
        File outFileCSV = new File("voter_output.csv");
        try{
            FileWriter testfile = new FileWriter(outFileCSV);
            testfile.write("first_name,middle_name,last_name,mail_addr,mail_city,mail_state,zip_code,gender_code,party_cd,age_at_year_end");
            for(int i = 0; i<master.size(); i++){
                if(checkForConvertable(master.get(i).getAge())){
                    testfile.write("\n"+master.get(i).getFirstName()+",");
                    testfile.write(master.get(i).getMiddleName()+",");
                    testfile.write(master.get(i).getLastName()+",");
                    testfile.write(master.get(i).getAddress()+",");
                    testfile.write(master.get(i).getCity()+",");
                    testfile.write(master.get(i).getState()+",");
                    testfile.write(master.get(i).getZip()+",");
                    testfile.write(master.get(i).getGender()+",");
                    testfile.write(master.get(i).getPoliticalParty()+",");
                    testfile.write(master.get(i).getAge());
                }
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

    public static boolean checkForConvertable(String init){
        try{
            if(Integer.parseInt(init) > 100){
                return true;
            }
            else{
                return false;
            }
        }
        catch (NumberFormatException e){
            System.out.println(e);
            return false;
        }
    }
}
