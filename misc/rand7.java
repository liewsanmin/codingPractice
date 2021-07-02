public static int rand7(){
    while(true){
        int roll1 = rand5();
        int roll2 = rand5();

        int outcomeNumber = (roll1 - 1) * 5 + (roll2 - 1) + 1;

        if(outcomeNumber > 21) continue;

        return outcomeNumber % 7 + 1;
    }
}
