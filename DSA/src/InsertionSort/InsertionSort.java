package InsertionSort;

public class InsertionSort {

    public static void main(String[] args){

        int[] intArray = {20, 20 , 35, -15, 7, 55, 1, -22};

        for(int firstUnorderedIndex = 1; firstUnorderedIndex < intArray.length;
        firstUnorderedIndex++){
            int i;
            int newElement = intArray[firstUnorderedIndex];
            for(i = firstUnorderedIndex; i > 0 && intArray[i-1] > newElement;
                i--){
                intArray[i] = intArray[i-1];
            }
            intArray[i] = newElement;
        }

        for(int i = 0; i < intArray.length;i++)
            System.out.print(intArray[i] + " ");

    }

}
