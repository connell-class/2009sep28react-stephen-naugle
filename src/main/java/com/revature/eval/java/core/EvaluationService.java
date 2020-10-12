package com.revature.eval.java.core;

import java.lang.reflect.Array;
import java.rmi.server.Operation;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	} 

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter                     //Complete
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		
		char letter;
		
		String anym = "";
		
		for(int i=0; i<phrase.length(); i++) {
			letter = phrase.charAt(i);
			if(i == 0) {
				anym = anym + Character.toUpperCase(phrase.charAt(i));
			}
			if(letter == ' ' ||  letter == '-') {
				anym = anym + Character.toUpperCase(phrase.charAt(i + 1));
			}
		}
		
		return anym; 
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An                      //Complete
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;
		
		public Triangle() {
			super();
		}
		
		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}
		
		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
		// TODO Write an implementation for this method declaration
			double sumSide = sideOne + sideTwo +sideThree;
			if(sumSide / 3 == sideOne && sumSide / 3 == sideTwo && sumSide / 3 == sideTwo) {
				return true;
			} else
				return false;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if(sideOne == sideTwo || sideTwo == sideOne || sideOne == sideTwo || sideThree == sideOne) {
				return true;
			} else
			return false;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if(sideOne != sideTwo && sideTwo != sideThree && sideOne != sideThree) {
				return true;
			} else
			return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.                          //Complete
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		
		//use switch for upper and lower case letters
		
		int score = 0; 
		
		for(int i = 0; i < string.length(); i++) {
			char character = string.charAt(i);
			switch(character) {
			case 'a':
			case 'A':
			case 'e':
			case 'E':
			case 'i':
			case 'I':
			case 'o':
			case 'O':
			case 'u':
			case 'U':
			case 'l':
			case 'L':
			case 'n':
			case 'N':
			case 'r':
			case 'R':
			case 's':
			case 'S':
			case 'T':
			case 't':
				score += 1;
				break;
			case 'D':
			case 'd':
			case 'G':
			case 'g':
				score += 2;
				break;
			case 'B':
			case 'b':
			case 'C':
			case 'c':
			case 'M':
			case 'm':
			case 'P':
			case 'p':
				score += 3;
				break;
			case 'F':
			case 'f':
			case 'H':
			case 'h':
			case 'V':
			case 'v':
			case 'W':
			case 'w':
			case 'Y':
			case 'y':
				score += 4;
				break;
			case 'K':
			case 'k':
				score += 5;
				break;
			case 'J':
			case 'j':
			case 'X':
			case 'x':
				score += 8;
				break;
			case 'Q':
			case 'q':
			case 'Z':
			case 'z':
				score += 10;
				break;
				
			}
			
		}
		
		
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.                  //Complete
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		
		int numLength = 10; // providing a standard for the length of our final number
		
//		String digit = "";
		
		string = string.replace(" ", "").replace("(", "").replace(")", "").replace("-", "").replace(".", "");
		
		if(string.length() > numLength) {
			throw new IllegalArgumentException("Number cannot be greater than " + numLength + " digits.");
		}
		
		else if (string.contains(":") || string.contains("@") || string.contains("!")) {
			throw new IllegalArgumentException("Number must contain only numeric values");
		}
		
		
		return string;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.            //Complete
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration

		//		Map<String, I> counter = new Map<String>();
		
		HashMap<String,Integer> counter = new HashMap<>();
		
		Scanner parse = new Scanner(string);
		
		parse.useDelimiter("[^a-zA-Z]+");
		
		String parsed = "";
		
		while(parse.hasNext()) {
			parsed = parse.next();
			
			if(counter.containsKey(parsed)) {
				counter.put(parsed, counter.get(parsed) + 1);
			} else {
				counter.put(parsed, 1);
			}
		}
		
		parse.close();
		
		return counter;
	}

	/**
	 * 7. Implement a binary search algorithm.											//Complete
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			
			//create boundaries of the index
			
			int index = sortedList.size() - 1;
			int left = 0;
			int right = sortedList.size() - 1;
			
			while(left <= right) {
				int mid = (left + right) / 2;
				if (t.equals(sortedList.get(mid))) {
					index = sortedList.indexOf(t);
					break;
				}
				if (sortedList.indexOf(t) < mid) {
					right = mid - 1;
				} else if(sortedList.indexOf(t) > mid) {
					left = mid + 1;
				}
			
//			for(int i = 0; i <= sortedList.size(); i++) {
//				return (int) sortedList.get(i);
//			}
//			
			
			
			}
			
			return index;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.                         //1 test left //Completed
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {    //public String had []
		// TODO Write an implementation for this method declaration 
		// if a word begins with a vowel -> add an "ay" to the end of the word
		// if a word begins with a consonant sounds -> move it to the end of the word, then add "ay" at the end
		
		Scanner parse = new Scanner(string);
		
		StringBuilder word = new StringBuilder();
		
		Character[] vowels = {'a', 'e', 'i', 'o', 'u'};
		
		List<Character> vowelList = Arrays.asList(vowels);
		
		//create index of vowel
		
		int vowelInd = -1;
		
		String parsed;
		
		while(parse.hasNext()) {
			parsed = parse.next();
			
			vowelInd = -1;
			for(int i = 0; i < parsed.length(); i++) {
				if (vowelList.contains(parsed.charAt(i)) && !(i != 0 && parsed.charAt(i) == 'u' && parsed.charAt(i -1) == 'q' )) {
					vowelInd = i;
					break;
				}		
		}

		if (vowelInd != -1) {
			word.append(parsed.substring(vowelInd));
			word.append(parsed.substring(0, vowelInd));
			word.append("ay");
		} else {
			word.append(parsed);
		}
		
		if (parse.hasNext()) {
			word.append(' ');
		}
		}
		parse.close();
		
		return word.toString();
	}
		
//		StringBuilder translate = new StringBuilder();
//		String[] string1 = null;
//		String[] translator = {};
//		
//		
//		
//		String pigL = "ay";
//		
//		for(int i = 0; i < string1.length; i++) {
//			if(translator[0] == pigL) {
//				translate.append(pigL);
//		}
		
//		if(string1.startsWith("a")) {
//			translate.append(pigL);
		
			
		
	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each              //Complete
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		
		int exp = String.valueOf(input).length();
		int initial = input;
		int sum = 0;
		
		while(initial != 0) {
			int num = initial % 10;
			sum += Math.pow(num, exp);
			initial = initial / 10;
			
		}
		
		if (sum == input) {
			return true;
		} else {
			return false;
		}
		
	}
		
		
//		int arr = new int[];
//		
//		for (int i = 0; i < arr.length; i++) {
//			arr = arr[i];
//		}
		

	/**
	 * 10. Compute the prime factors of a given natural number.               //working
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */

	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		
		LinkedList<Long> prime = new LinkedList<>();

		ArrayList<Long> primeNum = calculatePrimes(l);
	
		long num = 0;
	
		while (l > 1) {
			
			for (int i=0; i<primeNum.size(); i++) {
				num = primeNum.get(i);
				
				if (l % num == 0) {
					prime.add(num);
					l /= num;
					break;
				}
			}
		}
		
		return prime;                   //return prime       //return for numero 10
	}
	
	
	// need to create a method to calculate prime numbers
////////////////////////////////////////////////////////////////////////////////
	private ArrayList<Long> calculatePrimes(long l) {			// testing
		ArrayList<Long> primeNumbers = new ArrayList<>();
		
		for (long i=2; i<=l; i++) {
			if (primeBool(i)) {                 // create a boolean method to identify if number is a prime
				primeNumbers.add(i);
			}
		}
		
		return primeNumbers;
	}
	
	// boolean method to determine if the number is prime or not 
	private boolean primeBool(long l) {               
		
		long sqroot = (long) Math.sqrt(l) + 1L;
		
		long factors = 0;               // need to count the number of factors
	
		final long primeFactors = 2;
		
		for (long i=1; i < sqroot && factors <= primeFactors; i++) {
			if (l % i == 0) {
				factors++;
				
				
				if (i * i != l) {
					factors++;
				}
			}
		}
		
		return factors == primeFactors;
	}
		

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;
		
		private static int alphabet = 26;
		
		private static int upperCase = (int) 'A'; 			// need to transition letters to an integer
		
		private static int lowerCase = (int) 'a';          // need both cases transitioned

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			
			StringBuffer result = new StringBuffer();
			
			int character = '\0';
			
			int letterInt = '\0';
			
			for (int i = 0; i < string.length(); i++) {
				letterInt = (int) string.charAt(i);
				
				if (!Character.isAlphabetic(letterInt)) {
					result.append((char) letterInt);
					continue;
				}
				
				if (Character.isUpperCase(letterInt)) {
					character = upperCase;
				} else {
					character = lowerCase;
				}
				
				letterInt -= character;
				
				letterInt += this.key;
				
				letterInt %= alphabet;
				
				if (letterInt < 0) {
					letterInt += alphabet;
				}
				
				
				letterInt += character;
				
				result.append((char) letterInt);
			}
			
			return result.toString();

	}
	}  

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration
		
		int primeNum = 0;
		
		int givenNum = 0;
		
		if (i <= 0 ) {
			throw new IllegalArgumentException("Choose a number greater than 0.");   //testing worked
		}
		
		while (primeNum < i) {
			givenNum++;
		
			
			
			
			if (primeBool(givenNum)) {                  //implement formula to determine prime number
				primeNum++;
			}
		}

		return givenNum;        //return givenNum
	} 

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption     //Some work, some don't
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			
			return cipherResult(string, true);
		}
	

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			
			return cipherResult(string, false);
		}
		
		static int alphabet = 26;
		
		static int lowerCase = ((int) 'z') + 1;         // this creates a base location from which to move our characters
		
		
		private static String cipherResult(String string, boolean encode) {
			
			StringBuilder sb = new StringBuilder();    // using string builder to construct the output string
			
			char c = '\0';    // need a variable to hold the characters we are working through
			
			int charCount = 0;    // need a variable to keep track of the character length
			
			for (int i=0; i<string.length(); i++) {
				c = Character.toLowerCase(string.charAt(i));
				
				if (!Character.isDigit(c) && !Character.isAlphabetic(c)) {    // getting error for non-numeric characters, need to skp those 
					continue;
				}
				
				if (Character.isAlphabetic(c)) {
					c += alphabet;                         //
					c -= 1 + 2 * ((int) c - lowerCase);
				}
			
				charCount++;
				if (encode && charCount % 6 == 0) {            // need to put a space for every 5 characters
					sb.append(" ");
					charCount = 1;
				}
				
				sb.append(c);    // add the character to our string builder to construct the final output
			}
			
			return sb.toString();
		}
		
	}
		
		
	/**
	 * 15. The ISBN-10 verification process is used to validate book identification           //Completed
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		
		int num = 0;
		
		boolean checking = false;
		
		int digitCount = 10;
		
		char c = '\0';
		
		int parsed = 0;
		
		int x = 10;
		
		for (int i = 0; i < string.length() && !checking; i++) {
			c = Character.toLowerCase(string.charAt(i));
			
			if (Character.isDigit(c) || c == 'x') {
				if (c == 'x') {
					parsed = x;
				} else {
					parsed = Character.digit(c, 10);
				}	
				
				num += parsed * digitCount;
				digitCount--;
				
				if (digitCount < 0) {
					checking = true;
				}
			}
			else if (c != '-') {
				checking = true;
			}
		}

		return !checking && num % 11 == 0 && digitCount == 0;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan          //Completed
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		
		if(string == "") {
			return false;
		}
		
		string = string.toUpperCase();
		Set<String> letter = new HashSet<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));
		
		string = string.replaceAll("\\s", "");
		String[] words = string.split("");
		
		for (int i = 0; i < words.length; i++) {
			if(letter.contains(words[i])) {
				letter.remove(words[i]);
			}
		}
		
		if (letter.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.              // Complete
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		
		//use ChronoField
		
		long gigaSec = 1000000000L;
		
		LocalDateTime outputTime = null;
		
		if (given.isSupported(ChronoUnit.SECONDS)) {
			outputTime = LocalDateTime.of(
					given.get(ChronoField.YEAR), 
					given.get(ChronoField.MONTH_OF_YEAR),
					given.get(ChronoField.DAY_OF_MONTH),
					given.get(ChronoField.HOUR_OF_DAY),
					given.get(ChronoField.MINUTE_OF_HOUR),
					given.get(ChronoField.SECOND_OF_MINUTE)
					);
		} else {
			outputTime = LocalDateTime.of(
					given.get(ChronoField.YEAR),
					given.get(ChronoField.MONTH_OF_YEAR),
					given.get(ChronoField.DAY_OF_MONTH), 0, 0, 0
					);
		}
		
		outputTime = outputTime.plusSeconds(gigaSec);
		
		return outputTime;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular      //Complete
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		
		int num = 0;
		
		for (int j = 0; j < i; j++) {
			
			for (int k = 0; k < set.length; k++) {
				if (j % set[k] == 0) {
					num += j;
					
					break;
				}
			}
			
		}
		return num;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.                 // Complete
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		
		int num = 0;    // place to hold number we are working through
		
		int sum = 0;    // holding the aggregate numbers
		
		char c = '\0';  // need a place to hold the characters we will be working with
		
		int digit = 0;    // need a place to hold the numbers we will be working with
		
		boolean check = false;
		
		for(int i = string.length() - 1; i >= 0; i--) {
			c = string.charAt(i);
			
			if(c == ' ') {
				continue;
			
			} else if (!Character.isDigit(c)) {
				check = true;
				break;
			}
			
			digit = Character.digit(c, 10);    // need to make our character into an integer of 10
			
			num++;
			if (num % 2 == 0) {
				digit *= 2;
				
				if (digit >= 10) {
					digit -= 9;
				}
			}
			
			sum += digit;
			
		}		
		return sum % 10 == 0 && !check;
	}

	
	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	
	interface Operation {
		int execute(int i1, int i2);
	}
	
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		
		Scanner scan = new Scanner(string);
		
		ArrayList<Integer> num = new ArrayList<>();
		
		String parse = null;
		
		Operation op = null;
		
		while (scan.hasNext()) {
			parse = scan.next();
			
			if (parse.matches(".*[0-9]+.*")) {
				parse = parse.replaceAll("[^0-9\\-]", "");
				num.add(Integer.parseInt(parse));
				continue;
			}
			
			if (op == null) {
				switch(parse) {
				case "plus" :
					op = (int i1, int i2) -> {return i1 + i2;};
					break;
				case "minus" :
					op = (int i1, int i2) -> {return i1 - i2;};
					break;
				case "multiplied" :
					op = (int i1, int i2) -> {return i1 * i2;};
					break;
				case "divided" :
					op = (int i1, int i2) -> {return i1 / i2;};
					break;
					
				}
			}
		}
		
		scan.close();
		
		if (op == null) {
			throw new IllegalArgumentException("Unable to calculate based on input.");
		}
		
		if (num.size() < 2) {
			throw new IllegalArgumentException("You need at least two numbers to calculate.");
		}
		
		return op.execute(num.get(0), num.get(1));
	} 
}

