package main.machineCoding;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
    Braviant Coding Test

    In a given array of elements, search for 3 consecutive integers whose sum is equal
    to given number.
 */
public class SumOfThree {

    ArrayList<Integer> itemList = new ArrayList<>();
    Set<BigInteger> sumList = new HashSet<>();
    BigInteger currentLast3DigitCount=null;

    public static void main(String[] args){

        SumOfThree sumOfThree = new SumOfThree();
        int[] hundred = new int[100];
        for(int i=0;i<100;i++){
            hundred[i]=i;
        }
        sumOfThree.addLast(hundred);

        BigInteger checkSum = new BigInteger("6");
        System.out.println("3 Consecutive items whose sum = " + checkSum + " present? " +sumOfThree.containsSum(checkSum));
        checkSum = new BigInteger("150");
        System.out.println("3 Consecutive items whose sum = " + checkSum + " present? " +sumOfThree.containsSum(checkSum));

        sumOfThree.addLast(new int[] {5});
        sumOfThree.addLast(new int[] {6});
        sumOfThree.addLast(new int[] {7});
        sumOfThree.addLast(new int[] {8});
        sumOfThree.addLast(new int[] {9});
        sumOfThree.addLast(new int[] {10});

        checkSum = new BigInteger("11");
        System.out.println("3 Consecutive items whose sum = " + checkSum + " present? " +sumOfThree.containsSum(checkSum));
    }

    public boolean containsSum(BigInteger sum) {
        return sumList.contains(sum);
    }

    public void addLast(int[] newItemList) {

        for(int i=0; i<newItemList.length; i++){
            itemList.add(newItemList[i]);
            if(currentLast3DigitCount == null && itemList.size()==3){
                BigInteger temp = new BigInteger(String.valueOf(itemList.get(0)))
                                    .add(new BigInteger(String.valueOf(itemList.get(1))))
                                    .add(new BigInteger(String.valueOf(itemList.get(1))));
                sumList.add(temp);
                currentLast3DigitCount = temp;
            }
            else if(currentLast3DigitCount != null && itemList.size() > 3){
                BigInteger temp = currentLast3DigitCount
                        .subtract(new BigInteger(String.valueOf(itemList.get(itemList.size()-4))));
                temp = temp.add(new BigInteger(String.valueOf(itemList.get(itemList.size()-1))));
                sumList.add(temp);
                currentLast3DigitCount = temp;
            }
        }
    }
}
