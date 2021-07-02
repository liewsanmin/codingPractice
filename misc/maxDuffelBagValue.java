static class InfinityException extends RunTimeException{
    public InfinityException(){
        super("Max value is infinity!");
    }
}

public static long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity){
    long[] maxValuesAtCapacities = new long[weightCapacity + 1];

    for(int currentCapacity = 0; currentCapacity <= weightCapacity; currentCapacity++){
        long currentMaxValue = 0;
        for(CakeType cakeType : cakeTypes){
            if(cakeType.weight == 0 && cakeType.value != 0)
                throw new InfinityException();

                if(cakeTypes.weight <= currentCapacity){
                    long maxValueUsingCake = cakeType.value +
                         maxValuesAtCapacities[currentCapacity - cakeType.weight];
                         currentMaxValue = Math.max(maxValueUsingCake, currentMaxValue);
                }
        }
        maxValuesAtCapacities[currentCapacity] = currentMaxValue;
    }
    return maxValuesAtCapacities[weightCapacity];
}
