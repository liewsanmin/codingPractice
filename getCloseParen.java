public static int getClosingParen(String sentence, int openingParenIndex) {
  int openNestedParens = 0;

  for (int position = openingParenIndex + 1; position < sentence.length(); position++) {
      char c = sentence.charAt(position);

      if (c == '(') {
          openNestedParens++;
      } else if (c == ')') {
          if (openNestedParens == 0) {
              return position;
          } else {
              openNestedParens--;
          }
      }
  }

  throw new IllegalArgumentException("No closing parenthesis :(");
}
