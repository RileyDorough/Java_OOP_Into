public class stable_P2 {
    public static void main(String[] args){
        Horse horse1 = new Horse("Lightning", "White", 2016);
        Horse horse2 = new Horse("Spazzy", "Brown", 2013);
        RaceHorse raceHorse1 = new RaceHorse("Blitz", "Speckle", 2017, 8);
        RaceHorse raceHorse2 = new RaceHorse("Glue", "Black", 2011, 12);

        System.out.println(horse1.getName()+"'s Details [ Color: "+horse1.getColor()+" | Birth Year: "+horse1.getBirthYear()+ " ]\n");

        horse1.setName("Faster than lighning");
        System.out.println("- Updating Horse info -");
        System.out.println(horse1.getName()+"'s Details [ Color: "+horse1.getColor()+" | Birth Year: "+horse1.getBirthYear()+ " ]\n");

        System.out.println("- Horse info Dump -");
        System.out.println(horse2);

        System.out.println("\n - Race Horse Info -");
        System.out.println(raceHorse1.getName()+"'s Details [ Color: "+raceHorse1.getColor()+" | Birth Year: "+raceHorse1.getBirthYear()+ " | Races Won: "+raceHorse1.getRacesWon()+" ]\n");
        System.out.println(raceHorse2.getName()+"'s Details [ Color: "+raceHorse2.getColor()+" | Birth Year: "+raceHorse2.getBirthYear()+ " | Races Won: "+raceHorse2.getRacesWon()+" ]\n");
        System.out.println("Glue just won another race! \n");
        raceHorse2.setRacesWon(raceHorse2.getRacesWon()+1);
        System.out.println(raceHorse2.getName()+"'s Details [ Color: "+raceHorse2.getColor()+" | Birth Year: "+raceHorse2.getBirthYear()+ " | Races Won: "+raceHorse2.getRacesWon()+" ]\n");
        
    }
}


class Horse {

    Horse(String name, String color, int birthYear){
        setName(name);
        setColor(color);
        setBirthYear(birthYear);
    }

    private String name;
    private String color;
    private int birthYear;

    public void setName(String n){
        name = n;
    }
    public void setColor(String c){
        color = c;
    }
    public void setBirthYear(int by){
        birthYear = by;
    }
    public String getName(){
        return name;
    }
    public String getColor(){
        return color;
    }
    public int getBirthYear(){
        return birthYear;
    }
}

class RaceHorse extends Horse{
    RaceHorse(String name, String color, int birthYear, int racesWon) {
        super(name, color, birthYear);
        setRacesWon(racesWon);
    }

    private int racesWon = 0;

    public void setRacesWon(int rw){
        racesWon = rw;
    }
    public int getRacesWon(){
        return racesWon;
    }

}
