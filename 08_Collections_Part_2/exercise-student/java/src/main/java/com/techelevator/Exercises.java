package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Exercises {

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"
	 * animalGroupName("rhino") -> "Crash"
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {

		String unknownReturn="unknown";
		if (animalName==null){
			return unknownReturn;
		}

		Map<String, String> animalMap = new HashMap<>();
		animalMap.put("RHINO", "Crash");
		animalMap.put("GIRAFFE", "Tower");
		animalMap.put("ELEPHANT", "Herd");
		animalMap.put("LION", "Pride");
		animalMap.put("CROW", "Murder");
		animalMap.put("PIGEON", "Kit");
		animalMap.put("FLAMINGO", "Pat");
		animalMap.put("DEER", "Herd");
		animalMap.put("DOG", "Pack");
		animalMap.put("CROCODILE", "Float");

		String resultGroup=animalMap.get(animalName.toUpperCase());
		if(resultGroup==null){
			return unknownReturn;
		}

		return resultGroup;
	}

	/*
	 * Given an String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) {
		double returnSaleValue=0.0;

		if (itemNumber==null){
			return returnSaleValue;
		}

		Map<String, Double> skwMap = new HashMap<>();
		skwMap.put("KITCHEN4001", 0.20);
		skwMap.put("GARAGE1070", 0.15);
		skwMap.put("LIVINGROOM", 0.10);
		skwMap.put("KITCHEN6073", 0.40);
		skwMap.put("BEDROOM3434", 0.60);
		skwMap.put("BATH0073", 0.15);

		Double mapReturn =skwMap.get(itemNumber.toUpperCase());
		if (mapReturn==null){
			return returnSaleValue;
		}
//		returnSaleValue=mapReturn;
		return mapReturn;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
		int peterMoney = peterPaul.get("Peter");
		int paulMoney = peterPaul.get("Paul");
		int paulsHalf = peterMoney / 2; // Paul gets the lower half of money if peter has odd amount

		if (paulMoney < 1000) {
			if (peterMoney > 0) {
				peterPaul.put("Paul",  paulMoney + paulsHalf);
				peterPaul.put("Peter",  peterMoney - paulsHalf);
			}
		}
		return peterPaul;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {
		int peterMoney = peterPaul.get("Peter");
		int paulMoney = peterPaul.get("Paul");
		int qPaul = peterPaul.get("Paul") / 4;
		int qPeter = peterPaul.get("Peter") / 4;

		if (peterPaul.get("Peter") >= 5000 && peterPaul.get("Paul") >= 10000) {
			peterPaul.put("Peter", peterMoney - qPeter);
			peterPaul.put("Paul",  paulMoney - qPaul);
			peterPaul.put("PeterPaulPartnership", qPaul + qPeter);
		}
		return peterPaul;
	}


	/*
	 * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {
		Map<String, String> result = new HashMap<String, String>();

		for (String word: words) {
			result.put(word.substring(0, 1),  word.substring(word.length() - 1));
		}
		return result;
	}

	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (String word: words) {
			if (result.containsKey(word)) {
				result.put(word,  result.get(word) + 1);
			}
			else result.put(word,  1);
		}
		return result;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		for (int num: ints) {
			if (result.containsKey(num)) {
				result.put(num,  result.get(num) + 1);
			}
			else result.put(num,  1);
		}
		return result;
	}

	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		for (String word: words) {
			if (result.containsKey(word)) {
				result.put(word,  true);
			}
			else result.put(word,  false);
		}
		return result;
	}

	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
			Map<String, Integer> remoteWarehouse) {
		for (String key2: remoteWarehouse.keySet()) {
			if(mainWarehouse.containsKey(key2)) {
				mainWarehouse.put(key2,  mainWarehouse.get(key2) + remoteWarehouse.get(key2));
			}
			else mainWarehouse.put(key2,  remoteWarehouse.get(key2));
		}
		return mainWarehouse;
	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
	 * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
	 *
	 * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end subString, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {
		Map<String, Integer> doubleX = new HashMap<String, Integer>();

		for (int j = 0; j < words.length; j++) {
			int count = 0;
			for (int i = 0; i < words[j].length() - 2; i++) {
				String end = words[j].substring(words[j].length() - 2);
				String partialStr = words[j].substring(i, i + 2);

				if (end.equals(partialStr)) {
					count++;

				}
			}
			doubleX.put(words[j], count);
		}
		return doubleX;
	}


}
