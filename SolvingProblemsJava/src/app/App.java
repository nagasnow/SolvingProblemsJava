package app;

import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");

        //static array
        /*int[] someArray = new int[5];
        System.out.println("Size of someArray " + someArray.length);
        for(int i=0;i<someArray.length;i++) 
        {
            someArray[i] = i;
        }
        for(int i=0;i<someArray.length;i++) 
        {
            System.out.print(someArray[i] + " ");
        }
        System.out.println(); */

        //dynamic array
        /*List<Integer> someVector = new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            someVector.add(i);
        }
        someVector.remove(2);
        for(int i=0;i<someVector.size();i++) {
            System.out.print(someVector.get(i) + " ");
        }*/

        //running PivotIndex
        int[] PivotArray = {1,7,3,6,5,6};
        System.out.println(PivotIndex(PivotArray));
        int[] PivotArray2 = {1, 2, 3};
        System.out.println(PivotIndex(PivotArray2));
    }

    public static int PivotIndex(int[] someIndex) {
        int leftIndex = 0;
        int rightIndex = someIndex.length-1;
        int leftValue = someIndex[0];
        leftIndex++;
        int rightValue = 0;
        while(true) {
            if(leftIndex == rightIndex) {
                if(rightValue == leftValue) {
                    return leftIndex;
                } else {
                    return -1;
                }
            }

            if(leftValue < rightValue)
            {
                leftValue = leftValue + someIndex[leftIndex];
                leftIndex++;
            } else if(rightValue < leftValue) 
            {
                rightValue = rightValue + someIndex[rightIndex];
                rightIndex--;
            }
        }
    }
}