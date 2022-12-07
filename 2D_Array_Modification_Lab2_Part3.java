this is bad text

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Lab2_Part3 {
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<ArrayList<Integer>> multiDimentionArray = new ArrayList<>();
        for (int i=0; i<5; i++){
            multiDimentionArray.add(new ArrayList());
        }
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                multiDimentionArray.get(i).add(j, rand.nextInt(101));
            }
        }
        System.out.println();
        for (int i=0; i<5; i++){ //rows

            for (int j=0; j<5; j++){ //columns
                if (i==0 && j==0){
                    for(int k=0; k<5; k++){
                        System.out.print("\t"+k);
                    }
                    System.out.println();
                }
                if (j==0){
                    System.out.print(i+"\t");
                }
                System.out.print(multiDimentionArray.get(i).get(j) + "\t");
                if (j==4){
                    System.out.println();
                }
            }
        }
        alterArray(getUserInput(), multiDimentionArray);
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

    public static void alterArray(char usrChoice, ArrayList<ArrayList<Integer>> arr){
        Scanner getIntVal = new Scanner(System.in);
        int xins = -1;
        int yins = -1;
        int range = -1;
        int newVal = -1;
    
        
        if(usrChoice=='A'){
            while(yins>=arr.size() || yins<0){
                System.out.print("What row would you like to insert to? ");
                yins = getIntVal.nextInt();
            }
            while(xins>=arr.size() || xins<0){
                System.out.print("What column would you like to insert to? ");
                xins = getIntVal.nextInt();
            }
            while(newVal < 0 || newVal > 100){
                System.out.print("What is the value for row "+yins+", column "+xins+"? ");
                newVal = getIntVal.nextInt();
            }
            arr.get(yins).add(xins, newVal);
            for (int i=yins+1; i<5; i++){
                arr.get(i).add(0, arr.get(i-1).get(5));
            }
            for (int i=yins; i<5; i++){ //Remove values pushed outside the array print scope
                arr.get(i).remove(5);
            }
        }

        else if(usrChoice=='D'){

            while(yins>=arr.size() || yins<0){
                System.out.print("What row would you like to delete? ");
                yins = getIntVal.nextInt();
            }
            while(xins>=arr.size() || xins<0){
                System.out.print("What column would you like to delete? ");
                xins = getIntVal.nextInt();
            }
            arr.get(yins).remove(xins);
            for (int i=yins; i<4; i++){
                arr.get(i).add(4, arr.get(i+1).get(0));
                arr.get(i+1).remove(0);
            }
            arr.get(4).add(0);
        }
        
        else if (usrChoice=='C'){
            while(yins>=arr.size() || yins<0){
                System.out.print("What row would you like to change? ");
                yins = getIntVal.nextInt();
            }
            while(xins>=arr.size() || xins<0){
                System.out.print("What column would you like to change? ");
                xins = getIntVal.nextInt();
            }
            while(newVal < 0 || newVal > 100){
                System.out.print("What is the value for row "+yins+", column "+xins+"? ");
                newVal = getIntVal.nextInt();
            }
            arr.get(yins).set(xins, newVal);
        }

        System.out.println();
        for (int i=0; i<5; i++){ //rows

            for (int j=0; j<5; j++){ //columns
                if (i==0 && j==0){
                    for(int k=0; k<5; k++){
                        System.out.print("\t"+k);
                    }
                    System.out.println();
                }
                if (j==0){
                    System.out.print(i+"\t");
                }
                System.out.print(arr.get(i).get(j) + "\t");
                if (j==4){
                    System.out.println();
                }
            }
        }
        range = newVal = -1;
        getIntVal.close();
    }
}


/*
md                          -> v
0.0 > 1.0 > 2.0 > 3.0 > 4.0
0.1 > 1.1 > 2.1 > 3.1 > 4.1
0.2 > 1.2 > 2.2 > 3.2 > 4.2
0.3 > 1.3 > 2.3 > 3.3 > 4.3
0.4 > 1.4 > 2.4 > 3.4 > 4.4
*/