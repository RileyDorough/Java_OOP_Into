import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
            Please ensure that your input file is located at the home directory of the user account processing this code
            REVIEW LINES 25, 26, 27, & 28 FOR MORE INFO ON INPUT FILES
*/

public class extraCredit_P3 {

    public static void main(String[] args){
        ArrayList<voter_P3> master = new ArrayList<>();
        input(master);
        //sortList(master);
        output(master);
    }

    public static void input(ArrayList<voter_P3> master){
        FileInputStream inputStream = null;
        Scanner inline = null;
        try{
            //String data = null;
                                                            // String path = "Your path to your test file";
                                                            // I created this program on VS Code within my Kali VM
                                                            // The home directory for your device will be different than it is for me
            String path = System.getProperty("user.dir").toString().concat("/ncvoter36.txt");
            inputStream = new FileInputStream(path);
            System.out.println(path);
            //File infile = new File(path);
            inline = new Scanner(inputStream, "UTF-8");
            String[] dataArray;
            inline.nextLine();
            int test;
            //System.out.println("\n\n"+data+"\n\n");
            while(inline.hasNextLine()){
                //data = inline.nextLine();
                dataArray = inline.nextLine().split("\t");
                test = Integer.parseInt(dataArray[31].replace("\"", "").replace(" ", "").replace("\t", ""));
                if ((test >= 100) && (!"REMOVED".equals(dataArray[12].replace("\"", "").replace(" ", "").replace("\t", "").replace("\n", "")))){
                                      
                    for (int i=0; i< dataArray.length; i++){
                        System.out.print(dataArray[i]);
                    }
                    System.out.println("\n\n"+dataArray[12].replace("\"", "")+"\n\n");

                    master.add(new voter_P3(
                    dataArray[5].replace("\"", "").replace(" ", "").replace("\t", ""),
                    dataArray[6].replace("\"", "").replace(" ", "").replace("\t", ""),
                    dataArray[4].replace("\"", "").replace(" ", "").replace("\t", ""),
                    //dataArray[12].replace("\"", "").replace(" ", "").replace("\t", ""),
                    dataArray[12].replace("\"", "").trim(),
                    dataArray[20].replace("\"", "").replace(" ", "").replace("\t", ""),
                    dataArray[21].replace("\"", "").replace(" ", "").replace("\t", ""),
                    dataArray[15].replace("\"", "").replace(" ", "").replace("\t", ""),
                    dataArray[29].replace("\"", "").replace(" ", "").replace("\t", ""),
                    dataArray[28].replace("\"", "").replace(" ", "").replace("\t", ""),
                    dataArray[31].replace("\"", "").replace(" ", "").replace("\t", "")));
                }
            }
            //System.out.println(master.get(0).getFirstName()+" "+master.get(0).getAge());
            //master.remove(0);
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
    
    public static void sortList(ArrayList<voter_P3> master){
        Collections.sort(master, voter_P3.voterComparitor);
    }

    public static void output(ArrayList<voter_P3> master){
        File outFileCSV = new File("L3_voter_output.csv");
        try{
            FileWriter testfile = new FileWriter(outFileCSV);
            testfile.write("first_name,middle_name,last_name,mail_addr,mail_city,mail_state,zip_code,gender_code,party_cd,age_at_year_end,latitude,longitude");
            //testfile.write("\n"+master.size()+" Voters in file");
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
                    testfile.write(master.get(i).getAge()+",");
                    testfile.write(master.get(i).getLatitude()+",");
                    testfile.write(master.get(i).getLongitude());
                }
            }
            testfile.close();
        }

        catch(IOException e){
            System.out.println("\n\n"+e.getCause()+"\n"+e+"\n\n");
        }
        catch(Exception e){
            System.out.println("\n\n"+e+"\n\n");
        }
    }

    public static boolean checkForConvertable(String init){
        try{
            if(Integer.parseInt(init) >= 100){
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



class voter_P3 {
    public String firstName, middleName, lastName, address, city, state, zip, gender, politicalParty, age;

    voter_P3(String fn, String mn, String ln, String addr, String cty, String ste, String zp, String gndr, String pol, String ag){
        firstName = fn;                                     // 5
        middleName = mn;                                    // 6
        lastName = ln;                                      // 4
        if(!addr.isEmpty()){
            address = addr;                                 //12
        }
        if(address == null){
            address = "";
        }
        city = cty;                                         // 20
        state = ste;                                        // 21
        zip = zp;                                           // 15
        gender = gndr;                                      // 29
        politicalParty = pol;                               // 28
        age = ag;                                           // 31
    }
    protected String latitude = "34.0";
    protected String longitude = "-78.000";

    String getFirstName(){ // 5
        return firstName;
    }
    String getMiddleName(){ // 6
        return middleName;
    }
    String getLastName(){ // 4
        return lastName;
    }
    String getAddress(){ // 16, 17, 18, 19
        return address;
    }
    String getCity(){ // 20
        return city;
    }
    String getState(){ // 21
        return state;
    }
    String getZip(){ // 15
        return zip;
    }
    String getGender(){ // 29
        return gender;
    }
    String getPoliticalParty(){ // 28
        return politicalParty;
    }
    String getAge(){ // 31
        return age;
    }
    String getLatitude(){
        return latitude;
    }
    String getLongitude(){
        return longitude;
    }

    void setFirstName(String in){
        firstName = in;
    }
    void setMiddleName(String in){
        middleName = in;
    }
    void setLastName(String in){
        lastName = in;
    }
    void setAddress(String in){
        address = in;
    }
    void setCity(String in){
        city = in;
    }
    void setState(String in){
        state = in;
    }
    void setZip(String in){
        zip = in;
    }
    void setGender(String in){
        gender = in;
    }
    void setPoliticalParty(String in){
        politicalParty = in;
    }
    void setAge(String in){
        age = in;
    }
    void setLatitude(String in){
        latitude = in;
    }
    void setLongitude(String in){
        longitude = in;
    }

    public static Comparator<voter_P3> voterComparitor = new Comparator<voter_P3>() {

        public int compare(voter_P3 v1, voter_P3 v2) {
           String voterName1 = v1.getLastName().toUpperCase();
           String voterName2 = v2.getLastName().toUpperCase();
 
           return voterName1.compareTo(voterName2);

        }
    };

}
