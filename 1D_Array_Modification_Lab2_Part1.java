import java.util.Random;
import java.util.Scanner;

public class Lab2_Part1 {
	public static void main(String[] args) {
        int[] arr = new int[8];
        Random rand = new Random();
        for(int i = 0; i < arr.length; i++){
            arr[i]= rand.nextInt(101);
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(i+"\t");
            if(i == arr.length-1){
                System.out.println("");
            }
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+"\t");
            if(i == arr.length-1){
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

    public static void alterArray(char usrChoice, int[] arr){
        int[] newArr = new int[arr.length+1];
        Scanner getIntVal = new Scanner(System.in);
        int range = -1;
        int newVal = -1;

        if(usrChoice=='A'){
            while(range>=newArr.length || range<0){
                System.out.print("What column would you like to insert to? ");
                range = getIntVal.nextInt();
            }
            while(newVal < 0 || newVal > 100){
                System.out.print("What is the value for column "+range+"? ");
                newVal = getIntVal.nextInt();
            }
            for(int i = 0; i < range; i++){
                newArr[i]=arr[i];
            }
            newArr[range]=newVal;
            for(int i = range+1; i < newArr.length; i++){
                newArr[i]=arr[i-1];
            }
            for(int i = 0; i < newArr.length; i++){
                System.out.print(i+"\t");
                if(i == newArr.length-1){
                    System.out.println("");
                }
            }
            for(int i = 0; i < newArr.length; i++){
                System.out.print(newArr[i]+"\t");
                if(i == newArr.length-1){
                    System.out.println("");
                }
            }
        }

        else if(usrChoice=='D'){
            int[] delArr = new int[arr.length-1];
            while(range>=arr.length || range<0){
                System.out.print("What column would you like to delete? ");
                range = getIntVal.nextInt();
            }
            for(int i = 0; i < delArr.length; i++){
                if(i<range){
                    delArr[i]=arr[i];
                }
                if(i>=range){
                    delArr[i]=arr[i+1];
                }
            }
            for(int i = 0; i < delArr.length; i++){
                System.out.print(i+"\t");
                if(i == delArr.length-1){
                    System.out.println("");
                }
            }
            for(int i = 0; i < delArr.length; i++){
                System.out.print(delArr[i]+"\t");
                if(i == delArr.length-1){
                    System.out.println("");
                }
            }
        }

        else if (usrChoice=='C'){
            while(range>=arr.length || range<0){
                System.out.print("What column would you like to change? ");
                range = getIntVal.nextInt();
            }
            while(newVal < 0 || newVal > 100){
                System.out.print("What is the new value for column "+range+"? ");
                newVal = getIntVal.nextInt();
            }
            arr[range]=newVal;
            for(int i = 0; i < arr.length; i++){
                System.out.print(i+"\t");
                if(i == arr.length-1){
                    System.out.println("");
                }
            }
            for(int i = 0; i < arr.length; i++){
                System.out.print(arr[i]+"\t");
                if(i == arr.length-1){
                    System.out.println("");
                }
            }
        }
        range = newVal = -1;
        getIntVal.close();
    }
}