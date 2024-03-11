package Exercise3;

import java.util.Random;

public class Main {

    public static void main(String[]Args){
        Random rand = new Random();
        int []randArray = new int[10];
        for(int i=0; i<10;i++){
            randArray[i] = rand.nextInt(100);
        }

        for(int i=0; i<10;i++){
            for(int j=i+1; j<10;j++){
                if(randArray[i]>randArray[j]){
                    int aux = randArray[i];
                    randArray[i] = randArray[j];
                    randArray[j] = aux;
                }

            }
        }

        for(int i=0;i<10;i++){
            System.out.print(randArray[i] + ((i==9)?"":", "));
        }
    }



}
