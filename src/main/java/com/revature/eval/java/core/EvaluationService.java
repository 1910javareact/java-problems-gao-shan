package com.revature.eval.java.core;

import java.util.*; /*this is Sam's change*/

import java.io.*;
import java.lang.Math;

import java.time.temporal.Temporal;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	
	
	public String reverse(String string) {
		int i;
		String x = "";
		for (i = string.length()-1; i >= 0; i--) {
			x += string.charAt(i);
		}
		return x;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		StringBuilder acro = new StringBuilder("");
		String[] phrases = phrase.split("[-\\s]");
		for (String s : phrases) {
//			if (s.contains("[.,;:-_]?")) {
//				String[] sbstr = s.split("[.,;:-_]?");
//			}
			char[] x = s.toCharArray();
			acro.append(x[0]);
		}
		String rS = new String(acro);
		rS = rS.toUpperCase();
		return rS;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
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
			if ((this.getSideOne() == this.getSideTwo()) && (this.getSideOne() == this.getSideThree())){
				return true;
			} else {
				return false;
			}
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if ((this.getSideOne() == this.getSideTwo()) && (this.getSideOne() != this.getSideThree())) {
				return true;
			}
			if ((this.getSideTwo() == this.getSideThree()) && (this.getSideOne() != this.getSideThree())) {
				return true;
			}
			if ((this.getSideThree() == this.getSideOne()) && (this.getSideOne() != this.getSideTwo())) {
				return true;
			}
			return false;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if ((this.getSideOne() != this.getSideTwo()) && (this.getSideThree() != this.getSideOne()) && (this.getSideTwo() != this.getSideThree())) {
				return true;
			} else {
				return false;
			}
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
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
		string = string.toUpperCase();
		HashMap<Character, Integer> alphabetMap = new HashMap<>();
		alphabetMap.put('A', 1);
		alphabetMap.put('E', 1);
		alphabetMap.put('L', 1);
		alphabetMap.put('I', 1);
		alphabetMap.put('O', 1);
		alphabetMap.put('U', 1);
		alphabetMap.put('N', 1);
		alphabetMap.put('R', 1);
		alphabetMap.put('S', 1);
		alphabetMap.put('T', 1);
		alphabetMap.put('D', 2);
		alphabetMap.put('G', 2);
		alphabetMap.put('B', 3);
		alphabetMap.put('C', 3);
		alphabetMap.put('M', 3);
		alphabetMap.put('P', 3);
		alphabetMap.put('F', 4);
		alphabetMap.put('H', 4);
		alphabetMap.put('V', 4);
		alphabetMap.put('W', 4);
		alphabetMap.put('Y', 4);
		alphabetMap.put('K', 5);
		alphabetMap.put('J', 8);
		alphabetMap.put('X', 8);
		alphabetMap.put('Q', 10);
		alphabetMap.put('Z', 10);

		int returnValue = 0;
		
		for (int i = 0; i < string.length(); i++) {
			char x = string.charAt(i);
			int y = alphabetMap.get(x);
			returnValue += y;
		}
		 
		return returnValue;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that tstring = string.toUpperCase();hey can be sent SMS messages.
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
	public String cleanPhoneNumber(String string) throws IllegalArgumentException {
		// TODO Write an implementation for this method declaration
		//iterate through string to find first non-1 number; return substring from that index
		//create new string that iterates through new substring, adding only values integer values to it; return that
		StringBuilder validNums = new StringBuilder("");
		String num = "1234567890";
		String nonNums = "!@#$%^&*(\'\")_-+=.,<>";
		String whiteSpace = " ";
		char[] input = string.toCharArray();
		for (char c : input) {
			String s = c+"";
			if (num.contains(s)) {
				validNums.append(c);
			}
		}
		String returnString = new String(validNums);
		if (returnString.charAt(0) == 1) {
			char[] stringChar = returnString.toCharArray();
			StringBuilder sb = new StringBuilder("");
			for (int i = 1; i < returnString.length(); i++) {
				sb.append(stringChar[i]);
			}
			returnString = sb.toString();
		} 
		if (returnString.length() != 10) {
			throw new IllegalArgumentException("String is not of valid length, or contains non-numeric characters");
		}
		
		return returnString;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		Map<String, Integer> wordMap = new HashMap<>();
		string = string.toLowerCase();
		String[] spaceStrings = string.split("\\s*(=>|,|\\s)\\s*");
		Integer i = 1;
		for (String s : spaceStrings) {
			if (wordMap.containsKey(s)){
				Integer x = wordMap.get(s);
				x++;
				wordMap.remove(s);
				wordMap.put(s,x);
			} else {
				wordMap.put(s,i);
			}
			
		}
		return wordMap; 
	}

	/**
	 * 7. Implement a binary search algorithm.
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
			return 0;
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
	 * 8. Implement a program that translates from English to Pig Latin.
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
	public String toPigLatin(String string) {
		String suffix = "ay";
		String[] stringArray = string.split(" ");
		String vowels = "yaeiou";
		StringBuilder pigWord = new StringBuilder("");
		
		for (String s : stringArray) {
			int i = 0; 
			for (int m = 0; m < s.length(); m++) {
				String c = s.charAt(m)+"";
				if (vowels.contains(c)) {
					if ((m == 0)) {
						if ((s.charAt(m)=='y')) {
							i++;
							break;
						} 
					}
					break;
				} else if ((s.charAt(m)=='q')&&(s.charAt(m+1)=='u')) {
					i = 2;
					break;
				} else {
					i++;
				}
			}
			for (int k = i; k < s.length(); k++) {
				pigWord.append(s.charAt(k));
			}
			for (int l = 0; l < i; l++) {
				pigWord.append(s.charAt(l));
			}
			pigWord.append(suffix).append(" ");
		}
		String pigWordS = pigWord.toString();
		pigWordS = pigWordS.trim();

		return pigWordS;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
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
		double inputD = input;
		String inputsb = Integer.toString(input);
		int e = inputsb.length();
		double exponent = e;
		double product = 0;
		for (int i = 0; i < e; i++) {
			String s = inputsb.charAt(i) + "";
			double x = Double.parseDouble(s);
			double y = Math.pow(x, exponent);
			product += y;
		}
		
		System.out.println(product + " this is the product");
		if (product == inputD) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible eby itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> primeExponentCheck(long l, long m, List<Long> primes) { //m is mantissa, or i from given method
		double kD = 2;
		double iD = m;
		double lD = l;
		double mD = 2;
		if (Math.pow(iD, kD) <= lD) {
			for (; Math.pow(iD, kD) <= lD;) {
				
				if (Math.pow(iD, kD) == lD) {
					while (mD <= kD); {
						primes.add(wrapLong(m));
						mD++;
					} 
					return primes;
				}
				kD++;
			}
			return primes;
		}
		return primes;
	}
	public Long wrapLong(long l) {
		Long lL = new Long(l);
		return lL;
	}
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		List<Long> primeLongFactors = new ArrayList<>();
		if (l > 1L) { //put validation for 2 as prime into main for loop to auto meet test req
			for (long i = 2L; i < l;) { //iterate through all numbers less than l
				if ((l%i == 0)) {
					for (long j = 2L; j < i; j++) { //test up to l = j-1 & l = i - 1
//						if ((l == 2)|(i==2)) { //oddest prime; also passes isPrime test
//							primeLongFactors.add(wrapLong(2));
//						}
						if ((i%j == 0)&&(j>=2)) {
							break;
						} else if ((i%2 == 0)&&(j>2)) {
							break;
						}
						if ((j == i -1L)|(j+1L==i)|(i==2)){
							double m = i;
							double k = 2D;
							double n = l;
							System.out.println(Math.pow(m,k));

							while (Math.pow(m, k) <= n) {
								System.out.println(Math.pow(m,k));
								double listSize = primeLongFactors.size();
								if (Math.pow(m, k) == n) {
									double p = k;
									while(p-1 > 0) {
										primeLongFactors.add(wrapLong(i));
										p--; //different variable still does
									}
									double newListSize = primeLongFactors.size();
									if (listSize != newListSize) {
										break;
									}
								}
								k++;
							}
							primeLongFactors.add(wrapLong(i)); //implement primeExponentCheck below; i is prime
							//must use for loop to add values from a List to another List (enhanced for)
						} 
					}
				} 
				i++; //increment i here to use less chars in below block
				if ((i==l)&&(primeLongFactors.isEmpty())) { //passes isPrime test
					primeLongFactors.add(wrapLong(i));
				}
			}
			return primeLongFactors;
		} 
		return primeLongFactors;
	}
	

//	
//	public List<Long> calculatePrimeFactorsOf(long l) {
//		List<Long> returnList = new ArrayList<>();
//		long j = 2; 
//		while (j<=l) {
//			if ((l%j == 0)) {
//				if (returnList.isEmpty()) {
//					//handle 2
//					returnList.add(j);
//				} else {
//					//otherwise, check if it j is prime
//					for (long k = 2; k <= j; k++) {
//						if (j%k == 0) {
//							if (k==2) {
//								returnList.add(k);
//							} else if ((j%k!=0L)&&(k == j-1L)) {
//									returnList.add(j);
//								if (l%j == 0L) {
//									returnList.add(j);
//								}
//							} else {
//								break;
//							}
//						}
//					}
//				}
//			} j++;
//		}
//		System.out.println(returnList.toString());
//		return returnList;
//	}
		// TODO Write an implementation for this method declaration
//		List<Long> primeLongFactors = new ArrayList<>();
		/**
		 * see if it is divisible by smallest prime number (divide it)
		 * repeat until 
		 * 
		 * a numbers factors are all of the factors of any numbers that can be multiplied to equal the first
		 * also where the factors of the number have factors themselves 
		 * 8's factors are also the factors of the numbers inside it that can be broken down further
		 * 
		 * 
		 * 12%2==0
		 * 6%2==0
		 * 3%2==1
		 * .add(2)
		 * .add(2)
		 * 
		 * relatively prime numbers are numbers that have no common factors between them, but their factors are primes
		 * 
		 * 8x1
		 * 4x2 = 
		 * 2x4
		 * 1x8
		 * 
		 */
//	

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
		//create arrray object
		String alph = "abcdefghijklmnopqrstuvwxyz";
		String ALPH = alph.toUpperCase();

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this metmapIndex++hod declaration
			char[] sChar = string.toCharArray();
			StringBuilder appendChar = new StringBuilder();
			for (char c : sChar) {
				String s = c+"";
				if (alph.contains(s)) {
					int i = alph.indexOf(s);
					int j = i + key + 26;
					int l = j%26;
					appendChar.append(alph.charAt(l));
				} else if (ALPH.contains(s)) {
					int i = ALPH.indexOf(s);
					int j = i + key + 26;
					int l = j%26;
					appendChar.append(ALPH.charAt(l));
				} else {
					appendChar.append(s);
				}
			}
			return appendChar.toString();
		}
	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and impleString alph = "abcdefghijklmnopqrstuvwxyz";
		char[] alphabet = alph.toCharArray();ment them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) throws IllegalArgumentException {
		// TODO Write an implementation for this method declaration
		if (i<1)
			throw new IllegalArgumentException("0 is not a valid argument!");
		if (i>0) {
			int j = 2;
			int counter = 1;
			while (counter != i) {
				for(int k = 2; k < j; k++) {
					if((j%k == 0)||(j%2==0)) {
						break;
					} else if ((k == j-1)){
						counter++;
						if (counter == i) {
							return j;
						}
					}
				}
				j++;
			}
			return j;
		 }
		
		return 0;
	}
	
	
	
	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
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
	 * monoalphabetic su	}
bstitution cipher. However, this may not have been an issue
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
		static String alph = "abcdefghijklmnopqrstuvwxyz";
		static char[] alphabet = alph.toCharArray();
		static String balph = "zyxwvutsrqponmlkjihgfedcba";
		static char[] balphabet = balph.toCharArray();
		static String num = "1234567890";
		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			string = string.toLowerCase();
			char[] sChar = string.toCharArray();
			StringBuilder appendChar = new StringBuilder("");
			int fiveChar = 0;
			for (char c : sChar) {
				String s = c+"";
				if ((alph.contains(s))) {
					int f = alph.indexOf(c);
					appendChar.append(balphabet[f]);
					fiveChar++;
					if (((fiveChar)%5 == 0)) {
						appendChar.append(" ");
					}
				} else if (num.contains(s)) {
					appendChar.append(c);
					fiveChar++;
					if (((fiveChar)%5 == 0)) {
						appendChar.append(" ");
					}
				}
			}
			//ensure that the last character of the return value is not " "
			if (appendChar.lastIndexOf(" ") == appendChar.length() - 1) {
				String s = new String(appendChar);
				char[] newArray = s.toCharArray();
				StringBuilder newAppendChar = new StringBuilder("");
				for (int i = 0; i < s.length() -1; i++) {
					newAppendChar.append(newArray[i]);
				}
				String t = new String(newAppendChar);
				return t;
			}
			String s = new String(appendChar);
			return s;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			String[] strings = string.split(" ");
			StringBuilder sb = new StringBuilder("");
			for (String s : strings) {
				sb.append(s);
			}
			String concatStrings = new String(sb);
			char[] cArray = concatStrings.toCharArray();
			StringBuilder toReturn = new StringBuilder("");
			for (char c: cArray) {
				String s = c+"";
				if (num.contains(s)) {
					toReturn.append(s);
				} else if (balph.contains(s)) {
					int targetIndex = balph.indexOf(s);
					toReturn.append(alph.charAt(targetIndex));
				}
			}
			String tR = new String(toReturn);
			return tR;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
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
	 * 	}

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
		//format input to a string of numbers
		String num = "1234567890";
		char[] initialInput = string.toCharArray();
		StringBuilder sb = new StringBuilder("");
		for (char c : initialInput) {
			String s = c+"";
			if (num.contains(s)) {
				sb.append(c);
			} else if ((c == ('X'))) {
				sb.append(c);
			}
		}
		
		String s = new String(sb);
		int multiple = 10;
		int[] multiples = new int[10];
		int n;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'X'){
				n = 10;
			} else {
				n = s.charAt(i);
			}
			multiples[i] = n * multiple;
			multiple--;
		}
		int value = 0;
		for (int i: multiples) {
			value += i;
		}
		if ((value%11)==0) {
			return true;
		}
		return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
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
		String alph = "abcdefghijklmnopqrstuvwxyz";
		string = string.toLowerCase();
		Map<Character, Integer> p = new HashMap<>();
		char[] sChar = string.toCharArray();
		Integer i = 0;
		for (char c : sChar) {
			String s = c+"";
			if (alph.contains(s)) {
				Character key = c;
				if (p.containsKey(key) == false) {
					p.put(c, i);
					i++;
				}
			}
		}
		if (p.size() == 26) {
			return true;
		} else {
			return false;
		}
//		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
//		Integer mapIndex = new Integer(0);
//		HashMap<Character, Integer> checkLetterMap = new HashMap<>();
//		for (Integer i = 0; i < string.length(); i++) {
//			Character charI = new Character(string.charAt(i));
//			for (char c : alphabet) {
//				Character charC = new Character(c);
//				if ((charC == charI) && (checkLetterMap.containsKey(charI) != true)) {
//					mapIndex++;
//					checkLetterMap.put(charI, mapIndex);
//				}
//			}
//		}
//		Integer mapSize = new Integer(checkLetterMap.size());
//		Integer alphabetLen = new Integer(26);
//		if (mapSize == alphabetLen) {
//			return true;
//		} else {
//			return false;
//		}
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * SKIP THIS QUESTION
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
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
		//use while loop to iterate through all multiples
		int j = 0;
		List<Integer> multiples = new ArrayList<>();
		while (j < i) {
			for(int k : set) {
				if(j%k == 0) {
					if (multiples.contains(j) == false)
					multiples.add(j);
				}
			}
			j++;
		}
		Integer x = 0;
		for (Integer l : multiples) {
			x += l;
		}
		int r = x;
		return r;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
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
		return false;
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
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		String[] input = string.split("\\s|\\?");
		for (String s : input) {
			System.out.println(s);
		}
		String num = "1234567890";
		Integer[] numArray = new Integer[2];
		int numCount = 0;
		for (String s : input) {
			if (num.contains(s)) {
				Integer n = new Integer(s);
				numArray[numCount] = n;
				numCount++;
			} 
		}
		int a = numArray[0];
		int b = numArray[1];
		System.out.println(a + "this is a");
		for (String s : input) {
			if (s.contains("plus")) {
				return a + b;
			} else if (s.contains("minus")) {
				return a - b;
			} else if (s.contains("divided")) {
				return a / b;
			} else if (s.contains("multiplied")) {
				return a * b;
			}
		}
		return 0;
	}

}
