package main.string;

/*
    Write a program for String abbreviation by replacing all the characters in between
    the first and last character by the number count of characters in between like
    hello should be  h3o(replace ell 3 characters by 3),
    internationalization as i18n

 */
public class StringAbbreviation {

    public static void main(String[] args){

        String input = "hello";

        StringBuilder abbreviatedString = new StringBuilder();
        abbreviatedString.append(input.charAt(0));
        abbreviatedString.append(input.length()-2);
        abbreviatedString.append(input.charAt(input.length()-1));

        System.out.print("Intput String :: " + input);
        System.out.print("\nAbbreviated String :: " + abbreviatedString);
    }
}
