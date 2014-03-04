package part1.utils;

import java.util.ArrayList;

/**
 * Helped class to quickly and easily manipulate strings in different structures.
 * 
 * @author mike
 *
 */
public class StringManipulator
{
    // Converts a String to an ArrayList of String's.
    public static ArrayList<String> stringToList(String s)
    {
	ArrayList<String> als = new ArrayList<String>();
	
	for(int i = 0; i < s.length(); i++)
	    als.add(String.valueOf(s.charAt(i)));
	
	return als;
    }
    
    // Converts a String to an Array of String's.
    public static String[] stringToArray(String s)
    {
	String[] as = new String[s.length()];
	
	for(int i = 0; i < s.length(); i++)
	    as[i] = String.valueOf(s.charAt(i));
	
	return as;
    }
    
    // Converts an Array of String's to a single String.
    public static String arrayToString(String[] s)
    {
	StringBuilder builder = new StringBuilder();
	for(String a : s)
	    builder.append(a);
	
	return builder.toString();
    }
    
    // Converts an ArrayList of String's to a single String.
    public static String listToString(ArrayList<String> s)
    {
	StringBuilder builder = new StringBuilder();
	for(String a : s)
	    builder.append(a);
	
	return builder.toString();
    }
}
