package edu.qc.seclass;

class MyCustomString implements MyCustomStringInterface {
    private String s;
    public MyCustomString (String s){
        this.s = s;
    }

    public MyCustomString() {
        s = null;
    }


    /**
     * Returns current string, empty string return null.
     * @return Current string
     */
    @Override
    public String getString() {
        if(s==null) 
        	return null;
        return s;
    }

    /**
     * Sets value 
     * @param string The value to be set
     */
    @Override
    public void setString(String string) {
        s=string;

    }

    /**
     * Returns current string's number, number is defined as a contiguous sequence of digits.
     * 
     * If the current string is empty,  return 0.
     * 
     * @return Number of numbers in the current string
     * @throws NullPointerException If the current string is empty
     */
    @Override
    public int countNumbers() {
        if(s==null) 
        	throw new NullPointerException("The string is empty.");
        else{
            int counter = 0;
            for(int i = 0; i<s.length();i++){
                    if(Character.isDigit(s.charAt(i))){
                        int j=i-1;
                        if(j<0) {
                            counter++;
                        }
                        else {
                            if(!Character.isDigit(s.charAt(j))) 
                            	counter++;
                        }
                }
            }
            return counter;
        }
    }

    /**
     * Returns a string that consists of all and only the characters in positions n, 2n, 3n, 
     * And in the current string, starting from the beginning or the end of the string.
     * The characters in the resulting string should be in the same order and with the
     * same case as in the current string.
     * 
     * If the current string is empty or has less than n characters, the method should return an
     * empty string.
     * 
     * Values n and startFromEnd are passed as parameters. The starting character, whether it is
     * the first one or the last one in the string, is considered to be in Position 1.
     *
     * @param n            Determines the positions of the characters to be returned
     * @param startFromEnd Determines whether to start counting from the end 
     * @throws IllegalArgumentException If "n" <= zero
     * @throws NullPointerException     If the current string is empty and "n" >zero
     */
    @Override
    public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) {
        if(n<=0) 
        	throw new IllegalArgumentException("IllegalArgumentException");
        if(s == null && n >0) 
        	throw new NullPointerException("NullPointerException");
        if(s == null || s.length()<n) 
        	return null;
        
        String result = "";
        if (!startFromEnd) {
            for(int i = n-1; i<s.length() ;i+=n){
                result += Character.toString(s.charAt(i));
            }
        }
        else{
            for(int i = (s.length()-n); i>=0 ;i -= n) {
                result += Character.toString(s.charAt(i));
            }
        }
        return result;
    }

    /**
     * Replace the individual digits in the current string, between startPosition and endPosition,
     * with the corresponding English names of those digits, with the first letter capitalized.
     * The first character in the string is considered to be in Position 1.
     * Unlike for the previous method, digits are converted individually, even if contiguous.
     * 
     * @param startPosition first character 
     * @param endPosition   last character 
     * @throws IllegalArgumentException    If "startPosition" > "endPosition"
     * @throws "MyIndexOutOfBoundsException" If "startPosition" <= "endPosition", but either
     *                                     "startPosition" or "endPosition" are out of
     *                                     bounds (i.e., either less than 1 or greater than the
     *                                     length of the string)
     * @throws NullPointerException        If "startPosition" <= "endPosition", "startPosition" and
     *                                     "endPosition" are greater than 0, and the current
     *                                     string is empty
     */
    @Override
    public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
        if(s==null && startPosition <= endPosition && (endPosition > 0 && startPosition >0)) 
        	throw new NullPointerException("NullPointerException");
        if(startPosition <= endPosition && (startPosition<1 || endPosition > s.length())) 
        	throw new MyIndexOutOfBoundsException("MyIndexOutOfBoundsException");
        if(startPosition > endPosition) 
        	throw new IllegalArgumentException("IllegalArgumentException");
        
        String subs = s.substring(startPosition-1, endPosition);
        subs = subs.replaceAll("0", "Zero");
        subs = subs.replaceAll("1", "One");
        subs = subs.replaceAll("2", "Two");
        subs = subs.replaceAll("3", "Three");
        subs = subs.replaceAll("4", "Four");
        subs = subs.replaceAll("5", "Five");
        subs = subs.replaceAll("6", "Six");
        subs = subs.replaceAll("7", "Seven");
        subs = subs.replaceAll("8", "Eight");
        subs = subs.replaceAll("9", "Nine");

        s = s.substring(0,startPosition-1) + subs + s.substring(endPosition);

    }
}