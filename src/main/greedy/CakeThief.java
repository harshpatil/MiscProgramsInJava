package main.greedy;

/*
    https://www.interviewcake.com/question/java/cake-thief?
 */
public class CakeThief {

    public static class CakeType {

        int weight;
        int value;

        public CakeType(int weight, int value) {
            this.weight = weight;
            this.value  = value;
        }
    }

    public static void main(String[] args){

        int bagSize = 20;
        CakeType[] cakeType = new CakeType[3];
        cakeType[0] = new CakeType(7, 160);
        cakeType[1] = new CakeType(3, 90);
        cakeType[2] = new CakeType(2, 15);

        System.out.println("Maximum profit can be achieved is " + maxDuffelBagValue(cakeType, bagSize));
    }

    private static long maxDuffelBagValue(CakeType[] cakeTypes, int bagSize) {
        long[] bestWeightCapacities = new long[bagSize+1];
        for(int currentCapacity=0; currentCapacity<=bagSize; currentCapacity++){
            long maxCapacity = 0L;
            for(CakeType cakeType : cakeTypes){
                if (cakeType.weight == 0 && cakeType.value != 0) {
                    throw new InfinityException();
                }

                if(cakeType.weight <= currentCapacity) {
                    long capacity = cakeType.value + bestWeightCapacities[currentCapacity - cakeType.weight];
                    maxCapacity = Math.max(capacity, maxCapacity);
                }
            }
            bestWeightCapacities[currentCapacity]=maxCapacity;
        }
        return bestWeightCapacities[bagSize];
    }

    static class InfinityException extends RuntimeException {
        public InfinityException() {
            super("Max value is infinity!");
        }
    }
}
