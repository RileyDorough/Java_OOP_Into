import java.util.Comparator;

public class voter {
    public String firstName, middleName, lastName, address, city, state, zip, gender, politicalParty, age;

    voter(String fn, String mn, String ln, String addr1, String addr2, String addr3, String addr4, String cty, String ste, String zp, String gndr, String pol, String ag){
        firstName = fn;                                     // 5
        middleName = mn;                                    // 6
        lastName = ln;                                      // 4
        if(!addr1.isEmpty()){
            address = addr1;                                // 16
        }
        if(!addr2.isEmpty()){
            address = address+" "+addr2;                    // 17
        }
        if(!addr3.isEmpty()){
            address = address+" "+addr3;                    // 18
        }
        if(!addr4.isEmpty()){
            address = address+" "+addr4;                    // 19
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

    public static Comparator<voter> voterComparitor = new Comparator<voter>() {

        public int compare(voter v1, voter v2) {
           String voterName1 = v1.getLastName().toUpperCase();
           String voterName2 = v2.getLastName().toUpperCase();
 
           return voterName1.compareTo(voterName2);

        }
    };

}
