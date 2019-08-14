package app;

import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
        int[] PivotArray = {1,7,3,6,5,6};
        System.out.println(PivotIndex(PivotArray));
        int[] PivotArray2 = {1, 2, 3};
        System.out.println(PivotIndex(PivotArray2));
    }

    public static int PivotIndex(int[] someIndex) {
        //faster way
        int sum = 0;
        int rightsum;
        int leftsum;
        for(int i = 0; i < someIndex.length; i++) {
            sum = sum + someIndex[i];
        }
        rightsum = sum;
        leftsum = 0;
        for(int i = 0; i < someIndex.length; i++) {
            rightsum = rightsum - someIndex[i];
            leftsum = sum - someIndex[i] - rightsum;
            if(rightsum == leftsum) {
                return i;
            }
        }
        return -1;

        /*slow way
        int leftValue = 0;
        int rightValue = 0;
        for(int i = 1; i < someIndex.length; i++) {
            for(int j = 0; j < i; j++) {
                leftValue = leftValue + someIndex[j];
            }
            for(int k = i+1; k<someIndex.length; k++) {
                rightValue = rightValue + someIndex[k];
            }
            if(leftValue == rightValue) {
                return i;
            }
            leftValue = 0;
            rightValue = 0;
        }
        return -1; */
    }

    public static int largestNumberTwice(int[] someArray) {
        int largestNumber = 0;
        int secondLargestNumber = -1;
        int largestNumberPosition = -1;
        for(int i = 0; i < someArray.length; i++) {
            if(someArray[i] > largestNumber) {
                secondLargestNumber = largestNumber;
                largestNumber = someArray[i];
                largestNumberPosition = i;
            }
            if(someArray[i] < largestNumber && someArray[i] > secondLargestNumber) {
                secondLargestNumber = someArray[i];
            }
        }
        if(largestNumber >= secondLargestNumber*2) {
            return largestNumberPosition;
        }
        return -1;
    }
}
