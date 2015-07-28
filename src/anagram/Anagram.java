/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anagram;

/**
 *
 *
 * Java Anagram Program
 * @author Sheehan Toufiq
 * 
 * Problem:
 * The program needs to take an input file as an input, read each word, find 
 * the anagrams throughout the entire file, and print the output to a file names 
 * output.txt as the word and it's anagram on the same line. Words without 
 * anagrams should be printed without any anagrams on a new line.
 * 
 * When determining if two words are anagrams, the program must treat upper and 
 * lower case letters as equivalent and ignore punctuation marks. However, the 
 * program must display words with their original capitalization and 
 * punctuation. 
 * The “word” is assumed to be any series of nonblank characters; words may be 
 * separated by any number of white-space characters. Any number of words may 
 * appear on a line, including none. You may assume that no word is more than 
 * 12 characters long. And maximum number of words would be 50. 
 * 
 * The program must work even if the input file is empty. If this is the case 
 * print a message saying that “the input file is empty” and then terminate the 
 * program. 
 * 
 * The program must test the number of characters per word. If a word consist 
 * of more than 12 characters, the program should ignore that word and continue.
 * That word would also be ignored in the total number of words of 50. 
 * The program must also test the number of words. If there are more than 50 
 * words, print a message saying that “there are more than 50 words in the 
 * input file” and then terminate the program 
 * 
 * Challenges: 
 * The challenges include, using an efficient algorithm and data structure. 
 * 
 * Algorithm: 
 * Step 1:  prompt for input file 
 * Step 2:  read input file 
 * Step 3:  test to see if input file invalid (not empty or does not exist) 
 * Step 4:      if yes 
 * Step 5:          terminate 
 * Step 6:      read each word 
 * Step 7:          ignore if more than 12 characters 
 * Step 8:          ignore trailing punctuation 
 * Step 9:          set to tokens array 
 * Step 10:         test to see if input file contains more than 50 words 
 * Step 11:         if yes 
 * Step 12:             terminate 
 * Step 13:     set input = tokens array 
 * Step 14:     make input lower case 
 * Step 15:     remove input punctuation 
 * Step 16:     set each input word to signature array 
 * Step 17:         sort characters alphabetically 
 * Step 18:     set the index of each signature and token equal to each other 
 * Step 19:     use bubble sort algorithm to sort each signature alphabetically 
 * Step 20:     compare each word is signature array with following word 
 * Step 21:         if equal 
 * Step 22:             append token[i] and token[i+1] to output 
 * Step 23:         if not equal 
 * Step 24:             append token[i] to output 
 * Step 25:     print output to console 
 * Step 26:     print output to file called output.txt 
 * Step 27:  end
 * 
 * These are the global variables for the entire program:
 * globalVariables:
 *      input = ""
 *      signatures array
 *      tokens array    
 *      output = ""
 *      count = 0
 *
 * @param {string} fileName - input file
 * @return void
 * This method creates the anagrams by reading each word, setting it to a tokens
 * array, testing if it is a valid file calling the getSignature() 
 * method for each word, then calling the bubbleSort() method to sort the 
 * signatures array
 * 
 * createAnagrams(fileName):
 *	set fileName = new File
 *	try
 *          while fileName has tokens
 *		read next token
 *              if characters less than 12
 *                  increment count
 *              if tokens greater than 50
 *                  terminate
 *              set token[i] = input
 *              make input lowercase
 *              set input = getSignature(input)
 *		set signatures[i] to input
 *              increment i
 *	catch
 *          if fileName is empty
 *          terminate
 *	call bubbleSort(tokens, signatures)
 *	for each count
 *          if signatures[k] equals signatures[k+1]
 *              output = append tokens[k] and tokens[k+1]
 *          else
 *              output = append tokens[k]
 * end createAnagrams
 *
 * @param {string} input - single word from tokens[i]
 * @return {string} signature - returns alphabetized signature of each signatures[i]
 * This method gets the signature of a input string by sorting the characters 
 * alphabetically and returns the new string
 * 
 * getSignature(input):
 *	set char[] chars = each character from input 
 *	set j = 0
 *	for each character
 *          if character not letter
 *		continue
 *          else
 *		set sig[j] = chars[]
 *		increment j
 *	sort sig alphabetically
 *	set String = sig
 *	return String
 * end getSignature
 *
 * @param {string[]} tokens - tokens[] array
 * @param {string[]} signatures - signatures[] array
 * @return void
 * This method sorts the signatures array alphabetically along with it's 
 * corresponding tokens array index using the bubble sort algorithm 
 * 
 * bubbleSort(tokens, signatures):
 *	for each count
 *          if count+1 > count
 *              set tempA = tokens[count]
 *		set tempB = signatures[count]
 *		set tokens[count] = tokens[count+1]
 *		set signatures[count] = signatures[count+1]
 *		set tokens[count+1] = tempA
 *		set signatures[count+1] = tempB
 * end bubbleSort
 *
 * @param {string} outputFile - filename to write output to
 * @return void
 * This method prints output to a file and console
 * 
 * printAnagrams(outputFile):
 *	try
 *          set out = set filewriter(outputFile)
 *          print output to console
 *          print output to out
 *	catch
 *          IOexception
 *          terminate
 * end printAnagrams
 *
 * @param args Unused
 * @return void
 * This method is the main method that prompts user for input and calls methods
 * 
 * main:
 *	prompt for input file
 *	read input file
 *	set fileName = input file
 *	call createAnagrams(fileName)
 *	call printAnagrams("output.txt")
 *	terminate
 * end main
 *
 * Algorithms used: Bubble Sort Algorithm (bubbleSort() method)
 * Data Structures used: Arrays (tokens[], signatures[], content[], sig[])
 * 
*/

import java.util.*;
import java.io.*;

public class Anagram {

    /**
     * These are the global variables for the entire program:
     * globalVariables:
    */
    private static String input = new String();
    private static String signatures[] = new String[50];
    private static String tokens[] = new String[50];
    private static String output = "";
    private static int count = 0;
    
   /*    
    * @param {string} fileName - input file
    * @return void
    * This method creates the anagrams by reading each word, setting it to a 
    * tokens array, testing if it is a valid filecalling the getSignature() 
    * method for each word, then calling the bubbleSort() method to sort the 
    * signatures array
   */
    public static void createAnagram(String name) {
        File inFile = new File(name);
        Scanner in;
        int i = 0;
        try {
            in = new Scanner(inFile);
            while (in.hasNext()) {
                input = in.next();
                if (input.length() < 12 && input.length() > 0) {
                    count++;
                }
                tokens[i] = input;
                if (count > 50) {
                    System.out.println("The file must have less than 50 words.");
                    System.exit(0);
                }
                input = input.toLowerCase();
                input = getSignature(input);
                signatures[i] = input;
                i++;
            }
            if (count == 0) {
                System.out.println("The input file is empty.");
                System.exit(0);
            }
            in.close();
            bubbleSort(tokens, signatures);
            for (int k = 0; k < count; k++) {
                if (signatures[k].equals(signatures[k+1])) {
                    output += tokens[k] + "\t" + tokens[k+1] + "\n";
                    k++;
                } else {
                    output += tokens[k] + "\n";
                }
            }
            System.out.println(output);
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.exit(0);
        }
    }
    
   /*
    * @param {string} input - single word from tokens[i]
    * @return {string} signature - returns alphabetized of each signatures[i]
    * This method gets the signature of a input string by sorting the characters 
    * alphabetically and returns the new string
    */
    private static String getSignature(String str) {
        char[] content = str.toCharArray();
        char[] sig = new char[12];
        int j = 0;
        for (int i = 0; i < content.length; i++) {
            if (!Character.isLetter(content[i])) {
                continue;
            } else {
                sig[j] = content[i];
                j++;
            }
        }
        Arrays.sort(sig);
        String signature = new String(sig);
        return signature;
    }
    
   /*
    * @param {string[]} tokens - tokens[] array
    * @param {string[]} signatures - signatures[] array
    * @return void
    * This method sorts the signatures array alphabetically along with it's 
    * corresponding tokens array index using the bubble sort algorithm 
    */
    private static void bubbleSort(String[] a1, String[] a2) {
        int i, j;
        String tempA, tempB;
        for(j = 0; j < count-1; j++) {
            for(i = 0; i < count-j-1; i++) {
                if(a2[i].compareTo(a2[i+1]) <= 0) {
                    tempA = a1[i];
                    tempB = a2[i];
                    a1[i] = a1[i+1];
                    a2[i] = a2[i+1];
                    a1[i+1] = tempA;
                    a2[i+1] = tempB;
                }
            }
        }
    }
    
   /*
    * @param {string} outputFile - filename to write output to
    * @return void
    * This method prints output to a file and console
    */
    public static void printAnagrams(String outputFile) {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(outputFile));
            out.println(output);
            System.out.println("Writing to " + outputFile + ":");
            System.out.println(output);
            out.close();
            System.out.println("Write to " + outputFile + " successful!");
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
    }
   
   /*
    * @param args Unused
    * @return void
    * This method is the main method that prompts user for input and calls methods
    * 
    */
    public static void main(String[] args) {
        System.out.print("Please enter the filename: ");
        Scanner in = new Scanner(System.in);
        String fileName = in.next();
        Anagram.createAnagram(fileName);
        Anagram.printAnagrams("output.txt");
        System.exit(0);
    }
}