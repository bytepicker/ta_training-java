package com.epam.tat.listprocessor.impl;

import com.epam.tat.listprocessor.IListProcessor;
import com.epam.tat.listprocessor.exception.ListProcessorException;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Function Description:
 * Complete the functions below. All methods must work with list of String.
 *
 * In case of incorrect input values or inability to perform an action, the method should throw an appropriate
 * exception.
 *
 */

enum Letter {
	Vowel, Consonant
}

public class ListProcessor implements IListProcessor {

	/**
	 * Find the second by length string in a list.
	 *
	 * Ex.:
	 * From list:
	 * {"a", "aa", "aaaaa", "aaaa", "aaa"}
	 * will be return "aaaa"
	 *
	 * @param list - input data
	 * @return second by length string in the input list
	 */
	@Override
	public String getSecondStringByLength(List<String> list) {
		checkListForNullOrEmpty(list);
		if(list.size() < 2) throw new ListProcessorException("Only one value");
		if(list.stream().distinct().count()==1) throw new ListProcessorException("Only identical values");

		Collections.sort(list, Comparator.comparingInt(String::length));
		return list.get(list.size() - 1 - 1);
	}

	/**
	 * Sort list by string length.
	 *
	 * Ex.:
	 * From list:
	 * {"a", "aa", "aaA", "aAa", "aaa", "Aa"}
	 * will be return
	 * {"a", "Aa", "aa", "aAa", "aaA", "aaa"}
	 *
	 * @param list - input data
	 * @return sort list by string length
	 */
	@Override
	public List<String> getSortedListByLength(List<String> list) {
		checkListForNullOrEmpty(list);
		Collections.sort(list, Comparator.comparingInt(String::length));
		return list;
	}

	/**
	 * Sort list or array by count of vowels in string.
	 * If the number of vowels in several words is the same, the order is alphabetical.
	 *
	 * Ex.:
	 * From list:
	 * {"Puma", "Nike", "Timberland", "Adidas"}
	 * will be return
	 * {"Nike", "Puma", "Adidas", "Timberland"}
	 *
	 * @param list - input data
	 * @return sort list by string length
	 */
	@Override
	public List<String> getSortedListByCountOfVowels(List<String> list) {
		checkListForNullOrEmpty(list);
        if(list.size() == 1) return list;

		// no vowels in list
		if(list.stream().allMatch(str -> countInString(Letter.Vowel, str.toString()) == 0)){
			throw new ListProcessorException("No vowels in strings");
		}

		return list.stream().sorted(Comparator
				.comparingInt(str -> countInString(Letter.Vowel, str.toString()))
				.thenComparing(Object::toString)).collect(Collectors.toList());
	}

	/**
	 * Sort list or array by count of consonants in string.
	 * If the number of consonants in several words is the same, the order is alphabetical.
	 *
	 * Ex.:
	 * From list:
	 * {"Puma", "Nike", "Timberland", "Adidas"}
	 * will be return
	 * {"Nike", "Puma", "Adidas", "Timberland"}
	 *
	 * @param list - input data
	 * @return sort list by string length
	 */
	@Override
	public List<String> getSortedListByCountOfConsonants(List<String> list) {
		checkListForNullOrEmpty(list);
		if(list.size() == 1) return list;

		// no consonants in list
		if(list.stream().allMatch(str -> countInString(Letter.Consonant, str.toString()) == 0)){
			throw new ListProcessorException("No consonants in strings");
		}

		return list.stream().sorted(Comparator
				.comparingInt(str -> countInString(Letter.Consonant, str.toString()))
				.thenComparing(Object::toString)).collect(Collectors.toList());
	}

	/**
	 * Change by places first and last symbols in each second string of list.
	 *
	 * Ex.:
	 * From list:
	 * {"Puma", "Nike", "Timberland", "Adidas"}
	 * will be return
	 * {"Puma", "eikN", "Timberland", "sdidaA"}
	 *
	 * @param list - input data
	 * @return sort list by string length
	 */
	@Override
	public List<String> changeByPlacesFirstAndLastSymbolsInEachSecondStringOfList(List<String> list) {
		checkListForNullOrEmpty(list);
		if(list.size() < 2) throw new ListProcessorException("Only one value");

		for (String sb : list ) {
			if(list.indexOf(sb) % 2 != 0) list.set(list.indexOf(sb), swapChars(sb));
		}

		return list;
	}

	/**
	 * Revert strings of list.
	 *
	 * Ex.:
	 * From list:
	 * {"Puma", "Nike", "Timberland", "Adidas"}
	 * will be return
	 * {"amuP", "ekiN", "dnalrebmiT", "sadidA"}
	 *
	 * @param list - input data
	 * @return sort list by string length
	 */
	@Override
	public List<String> reverseStringsOfList(List<String> list) {
		checkListForNullOrEmpty(list);
		return list.stream().map(o-> new StringBuffer(o).reverse().toString()).collect(Collectors.toList());
	}

	/**
	 * Throwing exceptions check
	 *
	 * @param list - input data
	 */
	private void checkListForNullOrEmpty(List<String> list) {
		if(list == null) throw new ListProcessorException("Null list");
		if(list.isEmpty()) throw new ListProcessorException("Empty list");
	}

	/**
	 * Swapping first and last chars in String
	 *
	 * @param str - input string
	 * @return new String with swapped chars
	 */
	private String swapChars(String str){
		if(str == null) throw new ListProcessorException("String is null");
		if(str.isEmpty()) return str;

		StringBuilder sb = new StringBuilder(str);
		char first = sb.charAt(0);
		char last = sb.charAt(sb.length()-1);
		sb.setCharAt(0, last);
		sb.setCharAt(sb.length()-1, first);

		return sb.toString();
	}

	private static boolean charIsVowel(char c) {
		return "aeiou".contains(String.valueOf(c));
	}

	private static boolean charIsConsonant(char c) {
		return "bcdfghjklmnpqrstvwxyz".contains(String.valueOf(c));
	}

	/**
	 * Count vowels or consonants in String
	 *
	 * @param lookingFor - vowel / consonant
	 * @param str - input data
	 * @return counter
	 */
	private int countInString(Letter lookingFor, String str){
		int counter = 0;

		for(char ch : str.toCharArray()){
			if(lookingFor == Letter.Vowel && charIsVowel(Character.toLowerCase(ch))) {	counter++;	}
			if(lookingFor == Letter.Consonant && charIsConsonant(Character.toLowerCase(ch))) {	counter++;	}
		}

		return counter;
	}
}
