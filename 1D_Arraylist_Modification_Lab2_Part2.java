import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Lab2_Part2 {
	public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Random rand = new Random();
        for(int i = 0; i < 8; i++){
            arr.add(rand.nextInt(101));
        }
        for(int i = 0; i < arr.size(); i++){
            System.out.print(i+"\t");
            if(i == arr.size()-1){
                System.out.println("");
            }
        }
        for(int i = 0; i < arr.size(); i++){
            System.out.print(arr.get(i)+"\t");
            if(i == arr.size()-1){
                System.out.println("");
            }
        }
        alterArray(getUserInput(), arr);
    }

    public static char getUserInput() {
        Scanner usrStream = new Scanner(System.in);
        Character usrChoice = ' ';
        while(!(usrChoice=='A'||usrChoice=='D'||usrChoice=='C')){
            System.out.print("Add, Delete, Change (A,D,C)? ");
            usrChoice = usrStream.next().charAt(0);
        }
        //usrStream.close();
        return usrChoice;
    }

    public static void alterArray(char usrChoice, ArrayList<Integer> arr){
        Scanner getIntVal = new Scanner(System.in);
        int range = -1;
        int newVal = -1;

        if(usrChoice=='A'){
            while(range>arr.size() || range<0){
                System.out.print("What column would you like to insert to? ");
                range = getIntVal.nextInt();
            }
            while(newVal < 0 || newVal > 100){
                System.out.print("What is the value for column "+range+"? ");
                newVal = getIntVal.nextInt();
            }
            arr.add(range, newVal);
            for(int i = 0; i < arr.size(); i++){
                System.out.print(i+"\t");
                if(i == arr.size()-1){
                    System.out.println("");
                }
            }
            for(int i = 0; i < arr.size(); i++){
                System.out.print(arr.get(i)+"\t");
                if(i == arr.size()-1){
                    System.out.println("");
                }
            }
        }

        else if(usrChoice=='D'){
            while(range>=arr.size() || range<0){
                System.out.print("What column would you like to delete? ");
                range = getIntVal.nextInt();
            }
            arr.remove(range);
            for(int i = 0; i < arr.size(); i++){
                System.out.print(i+"\t");
                if(i == arr.size()-1){
                    System.out.println("");
                }
            }
            for(int i = 0; i < arr.size(); i++){
                System.out.print(arr.get(i)+"\t");
                if(i == arr.size()-1){
                    System.out.println("");
                }
            }
        }

        else if (usrChoice=='C'){
            while(range>=arr.size() || range<0){
                System.out.print("What column would you like to change? ");
                range = getIntVal.nextInt();
            }
            while(newVal < 0 || newVal > 100){
                System.out.print("What is the new value for column "+range+"? ");
                newVal = getIntVal.nextInt();
            }
            arr.set(range, newVal);
            for(int i = 0; i < arr.size(); i++){
                System.out.print(i+"\t");
                if(i == arr.size()-1){
                    System.out.println("");
                }
            }
            for(int i = 0; i < arr.size(); i++){
                System.out.print(arr.get(i)+"\t");
                if(i == arr.size()-1){
                    System.out.println("");
                }
            }
        }
        range = newVal = -1;
        getIntVal.close();
    }
}