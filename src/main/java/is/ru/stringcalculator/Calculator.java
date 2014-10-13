package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text) {
		if(text.equals("")){
			return 0;
		}
        	else if (text.length() > 3 && text.substring(0, 2).equals("//") ) {
        		String delimiter = text.substring(2, 3);
        		text = (text.substring(4)).replaceAll(delimiter, ",") ;
        		return sum(splitNumbers(text) );
        	}
		else if(text.contains(",") || text.contains("\n") ) {
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers) {
	    	return numbers.split("(,)|(\n)");
	}
      
        private static int sum(String[] numbers) {
 	    	int total = 0;
            	for(String number : numbers) {
			if(toInt(number) < 0) {
	        		throw new RuntimeException("Negatives not allowed: " + number);
	        	}
	        	else {
	        		total += toInt(number);
	        	}
	 	}
		return total;
        }
}
