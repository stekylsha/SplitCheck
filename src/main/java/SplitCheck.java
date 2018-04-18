package src.main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Lidiya
 *
 */
public class SplitCheck {

	private Map<String, Integer> result = new HashMap<>();
	private StringBuilder errorMessages = new StringBuilder();
	private boolean showErrors = false;

	public String split(String input) {
		
		// no Input
		if (input == null) { 
			return null;
		}

		StringBuilder output = new StringBuilder();
		
		BufferedReader bufReader = new BufferedReader(new StringReader(input));
		String line = null;
		int lineNimber = 1;

		try {
			while ((line = bufReader.readLine()) != null) {
				String[] tokens = line.split("=");
				
				// skipping blank lines
				if (tokens.length == 0) { 
					lineNimber++;
					continue;
				}

				// only the VALUE is present in the Input
				if (tokens.length == 1) { 
					addMessage(lineNimber, "Incorrect Input", line);
					lineNimber++;
					continue;
				}

				// the VALUE is not numeric.
				if (!isFirstValueNumeric(tokens[0].trim())) { 
					addMessage(lineNimber, "First value is not Integer", line);
					lineNimber++;
					continue;
				}

				List<String> people = Arrays.asList(tokens[1].replaceAll("\\s", "").split(",")).stream()
						.filter(value -> value != null && value.trim().length() > 0).distinct()
						.collect(Collectors.toList());

				
				// missing name(s) in the Input
				if (people.size() == 0) { 
					addMessage(lineNimber, "Incorrect Input", line);
					lineNimber++;
					continue;
				}
				
				
				int shareVal = Integer.parseInt(tokens[0].trim());
				int itemValPerPerson;
				if (shareVal % (people.size()) == 0) {
					itemValPerPerson = shareVal / (people.size());
				} else {
					// supporting indivisible values. Extra $ could be tips..
					itemValPerPerson = (int) Math.ceil((double) shareVal / (people.size()));
				}
				people.forEach(person -> result.put(person.trim(), getCurrentValue(person.trim()) + itemValPerPerson));
				lineNimber++;
			}

			// returning result ONLY if the Input is valid
			if (errorMessages.length() > 0) {
				//
				if(showErrors){
					System.err.println(errorMessages);
				}
				return null;
			}
			
			result.forEach((name, val) -> {
				if (val > 0)
					output.append(name + " = " + val + "\n");
			});
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return output.toString();
	}

	/**
	 * @param person 
	 * @return $ amt which the person owes already due to the previous item(s)
	 */
	private int getCurrentValue(String person) {
		Integer currentAmt = result.get(person);
		if (currentAmt == null)
			return 0;
		else
			return currentAmt;
	}

	/**
	 * @param val
	 * @return True if the value is Integer, False - otherwise 
	 */
	private boolean isFirstValueNumeric(String val) {
		try {
			Integer.parseInt(val);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * @param lineNumber
	 * @param message
	 * @param line
	 * Collecting error messages  
	 */
	private void addMessage(int lineNumber, String message, String line) {
		errorMessages.append("Line #" + lineNumber + " : \"" +line+"\"  Error: "+  message + "\n");
	}
}
