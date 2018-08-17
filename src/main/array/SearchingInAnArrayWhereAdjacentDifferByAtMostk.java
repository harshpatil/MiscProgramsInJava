package main.array;

/**
 * Created by HarshPatil on 8/17/18.
 */
public class SearchingInAnArrayWhereAdjacentDifferByAtMostk {

    public static void main(String[] args) throws Exception {
        int[] a = {20, 40, 50, 70, 70, 60};
        int k=20;
        int elementToBeSearched = 60;
        findElement(a, elementToBeSearched, k);
    }

    public static void findElement(int a[], int elementToBeSearched, int k){
        int i=0;
        while(i<a.length){
            if(a[i] == elementToBeSearched){
                System.out.println("Element " + elementToBeSearched + " found at position " + (i+1));
                return;
            }
            i=i+ Math.max(1, Math.abs(a[i]-elementToBeSearched)/k);
        }
        System.out.println("Element " + elementToBeSearched + " does not exist");
    }
}
