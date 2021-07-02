public static Set<String> getPermutations(String inputString){
    if(inputString.length() <= 1)
        return new HashSet<>(Arrays.asList(inputString));

    String allCharsExceptLast = inputString.substring(0, inputString.length() - 1);
    char lastChar = inputString.charAt(inputString.length() - 1);

    Set<String> permutationsOfAllCharExceptLast = getPermutations(allCharExceptLast);

    Set<String> permutations = new HashSet<>();
    for(String permutationsOfAllCharExceptLast : permutationsOfAllCharsExceptLast){
        for(int position = 0; position <= allCharsExceptLast.length(); position++){
            String permuation = permutationOfAllCharExceptLast.substring(0, position) + lastChar
             + permutationOfAllCharsExceptLast.substring(position);
             permutations.add(permutation);
        }
    }
    return permutations;
}
