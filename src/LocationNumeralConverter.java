import java.util.ArrayList;

/**
 * LocationNumeralConverter.java
 *
 * Class used to:
 * - Convert decimals into abbreviated location numerals
 * - Convert location numerals into decimals
 * - Convert potentially extended location numerals into abbreviated location numerals
 *
 * Code Challenge for Core-Apps LLC
 * Created by Edison Jimenez on 5/10/16.
 */
class LocationNumeralConverter {
    private ArrayList<Character> lowercaseLetters;

    // Constructor
    LocationNumeralConverter() {
        // Generate an ArrayList containing 26 lowercase characters (a-z)
        lowercaseLetters = new ArrayList<Character>();
        for (int i = 0; i < 26; i++) {
            lowercaseLetters.add((char) (97 + i));
        }
    }

    /**
     * Method to convert decimals into abbreviated location numerals
     * @param decimal int value greater than zero
     * @return String containing the location numeral or an empty string if parameter is not valid
     */
    String toLocationNumeral(int decimal) {

        String locationNumeral = "";

        if (isValidInput(decimal)) {

            // Convert the decimal to binary
            String binary = Integer.toBinaryString(decimal);

            // Use the binary value to get the letters corresponding to each 1
            for (Integer x = 0; x < binary.length(); x++) {

                // Iterate through the binary string. For each character with a value of 1,
                // get the location numeral value and prepend the String
                if (binary.charAt(x) == '1') {
                    locationNumeral = lowercaseLetters.get(binary.length() - 1 - x) + locationNumeral;
                }
            }
        }

        return locationNumeral;
    }

    /**
     * Method to convert a location numeral into a decimal value
     * @param locationNumeral String containing the location numeral
     * @return int corresponding to the value or 0 if parameter is not valid
     */
    int toDecimal(String locationNumeral) {

        int decimalValue = 0;

        if (isValidInput(locationNumeral)) {

            for (int i = 0; i < locationNumeral.length(); i++) {
                char c = locationNumeral.charAt(i);
                decimalValue += (int) Math.pow(2, lowercaseLetters.indexOf(c));
            }
        }

        return decimalValue;
    }

    /**
     * Method used to convert an extended location numeral into an abbreviated location numeral
     * @param locationNumeral String containing the extended location numeral
     * @return String containing the abbreviated location numeral or an empty String if parameter is not valid
     */
    String toAbbreviatedNumeral(String locationNumeral) {
        String abbreviatedNumeral = "";

        if (isValidInput(locationNumeral)) {
            // Solution  using the methods already written above
            abbreviatedNumeral = toLocationNumeral(toDecimal(locationNumeral));
        }

        return abbreviatedNumeral;
    }

    /**
     * Method used to validate params
     * @param input String containing the input in question
     * @return boolean whether or not the string meets all the validation criteria
     */
    private static boolean isValidInput(String input) {
        boolean validInput = false;

        if (input == null) {
            validInput = false;
        }
        else if (input.isEmpty()) {
            validInput = false;
        }
        else if (!input.matches(".*[^a-z].*")) {
            validInput = true;
        }

        return validInput;
    }

    /**
     * Method used to validate params
     * @param input int containing the input in question
     * @return boolean whether or not the string meets all the validation criteria
     */
    private static boolean isValidInput(int input) {
        return input > 0;
    }
}
