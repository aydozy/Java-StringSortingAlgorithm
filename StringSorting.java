import java.util.*;

//-----------------------------------------------------
//Title: StringSorting Class
//Author: Ayda Nil Özyürek
//Description: in this class we were asked to sort the first array using
//             the string sorting algorithm according to a certain rule -computation.
//------------------------------------------------

public class StringSorting {

	// assigns an integer value according to the alphabetical position of the
	// strings
	public static int getIntValue(String str) {

		int value = 0;

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			int charValue = ch - 'a' + 1;
			value = value * 26 + charValue;
		}
		return value;
	}

	// It takes two arrays of strings, calculates the distance between the
	// corresponding elements, and sorts the strings according to the specific
	// conditions. A new array is then used to store the resulting sorting strings
	// and returns it.
	public static String[] sortStrings(String[] firstArray, String[] secondArray) {
		String[] sortedArray = new String[firstArray.length];

		for (int i = 0; i < firstArray.length; i++) {

			int distance = Math.abs(getIntValue(firstArray[i]) - getIntValue(secondArray[i]));

			if (distance % 2 == 0) {
				sortedArray[i] = sortStringBySecondArray(firstArray[i], secondArray[i]);
			} else {
				sortedArray[i] = sortStringLexicographically(firstArray[i]);
			}
		}

		return sortedArray;
	}

	// sorts the str string based on the order of characters in the secondStr string
	public static String sortStringBySecondArray(String str, String secondStr) {
		StringBuilder sortedString = new StringBuilder();

		for (int i = 0; i < secondStr.length(); i++) {
			char ch = secondStr.charAt(i);
			int count = str.length() - str.replace(String.valueOf(ch), "").length();
			for (int j = 0; j < count; j++) {
				sortedString.append(ch);
			}
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (secondStr.indexOf(ch) == -1) {
				sortedString.append(ch);
			}
		}

		return sortedString.toString();
	}

	// Sorts the characters in the input string str in ascending order according to
	// Unicode values and returns a sorted string as output.
	public static String sortStringLexicographically(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

	public static void main(String[] args) {

		// get input from user

		// In order to provide flexibility in the dynamic storage and manipulation of
		// input strings, List<String> is used instead of arrays. The use of lists makes
		// it easier to resize, add, and remove items compared to arrays that have a
		// fixed size when created.
		Scanner scanner = new Scanner(System.in);
		List<String> firstList = new ArrayList<>();
		List<String> secondList = new ArrayList<>();

		System.out.println("First Array:");
		String input = scanner.nextLine();
		String[] firstArray = input.split(" ");
		firstList.addAll(Arrays.asList(firstArray));

		System.out.println("Second Array:");
		input = scanner.nextLine();
		String[] secondArray = input.split(" ");
		secondList.addAll(Arrays.asList(secondArray));

		String[] sortedArray = sortStrings(firstArray, secondArray);

		System.out.println("Sorted Array:");
		for (String str : sortedArray) {
			System.out.print(str + " ");
		}

	}

}