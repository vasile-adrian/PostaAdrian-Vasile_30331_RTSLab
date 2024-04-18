package Bubblesort;

public class BubbleSort {

    public static void swap(int[] array, int i, int j){
        if (i==j){
            return;
        }
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    //  Algorithm Complexity: O(n^2)
    public static void main(String[] args){

        int[] intArray = {20, 20 , 35, -15, 7, 55, 1, -22};

        for(int i = intArray.length-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if( intArray[j] > intArray[j+1])
                    swap(intArray, j, j+1);
            }
        }

        for(int i = 0; i< intArray.length; i++)
            System.out.print(intArray[i]+" ");

    }

}
