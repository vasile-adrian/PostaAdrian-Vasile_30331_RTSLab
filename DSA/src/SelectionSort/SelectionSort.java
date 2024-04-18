package SelectionSort;

public class SelectionSort {
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

        for(int lastUnsortedIndex = intArray.length-1; lastUnsortedIndex > 0;
            lastUnsortedIndex--){
            int largest = 0; //index of the first element in the unsorted partition
            //we take it zero because it doesn't matter since we are ordering it anyway.
            for(int i=0; i<=lastUnsortedIndex; i++){
                if(intArray[i] > intArray[largest])
                    largest = i;
            }
            if(largest!=lastUnsortedIndex)
                swap(intArray,largest,lastUnsortedIndex);
        }

        for(int i = 0; i< intArray.length; i++)
            System.out.print(intArray[i]+" ");
    }

}
