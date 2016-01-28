package com.BusiWave.ChallengingHacks;

/**
* @author Gal Levinshtein 
* @since 2/20/2010
* @version 0.01
* 
* Implement a method that returns whether a String is a palindrome.
* boolean isPalindrome(String s) { return new StringBuilder(s).reverse().toString().equals(s); }
* Imagine that efficiency matters more than readability
*/

public final class Palindrome {
    public static void main(String[] args) {
	
	System.out.println("Checking any string for a palindrome is a word, phrase, number, or other sequence \n" +
			" of characters which reads the same backward or forward. All special characters \n" +
			"(including spaces) removed & lowered case before test run.\n" +
			"====================================================================================");
        System.out.println("'Able was I ere I saw Elba' is " + testPalindrome("Able was I ere I saw Elba") + "a Palindrome");
        System.out.println("'' is " + testPalindrome("") + "a Palindrome");
        System.out.println("acbd is " + testPalindrome("abcd") + "a Palindrome");
        System.out.println("abba is " + testPalindrome("abba") + "a Palindrome");
        System.out.println("abccba is " + testPalindrome("abccba") + "a Palindrome");
        System.out.println("'Madam in Eden, I\'m Adam' is " + testPalindrome("Madam in Eden, I'm Adam") + "a Palindrome");
        System.out.println("'012 345 678 9!$$%' is " + testPalindrome("012 345 678 9!$$%") + "a Palindrome");
        System.out.println("'012345543210' is " + testPalindrome("012345543210") + "a Palindrome");
    }

    static String testPalindrome(String s) {
        if (!isPalindrome(s))
                return "not ";
        return "";
    }
    
    static boolean isPalindrome(String s) {
	
	
	//remove blank spaces
	s = s.replace(" ", "");
	// convert to lower case
	s = s.toLowerCase();
	// remove special chars
	s = s.replaceAll("[^a-zA-Z0-9]", "");
	
        for (int a = 0; a < s.length() / 2; a++)
            if (s.charAt(a) != s.charAt(s.length() - 1 - a))
                return false;
        return true;
    }
}