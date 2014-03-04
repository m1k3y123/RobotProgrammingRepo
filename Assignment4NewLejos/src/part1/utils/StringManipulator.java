package part1.utils;

import java.util.ArrayList;

public class StringManipulator
{
    public static ArrayList<String> stringToList(String s)
    {
	ArrayList<String> als = new ArrayList<String>();
	
	for(int i = 0; i < s.length(); i++)
	    als.add(String.valueOf(s.charAt(i)));
	
	return als;
    }
    
    public static String[] stringToArray(String s)
    {
	String[] as = new String[s.length()];
	
	for(int i = 0; i < s.length(); i++)
	    as[i] = String.valueOf(s.charAt(i));
	
	return as;
    }
    
    public static String arrayToString(String[] s)
    {
	StringBuilder builder = new StringBuilder();
	for(String a : s)
	    builder.append(a);
	
	return builder.toString();
    }
    
    public static String listToString(ArrayList<String> s)
    {
	StringBuilder builder = new StringBuilder();
	for(String a : s)
	    builder.append(a);
	
	return builder.toString();
    }
}
