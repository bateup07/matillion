package com.matillion.project;

public class FirstPart
{
    public static void main( String[] args )
    {
        String s1 = "D23W8MCCIZQOP9";
        String s2 = "D236862CEZQOPS";

        System.out.println(misMatchedChar(s1,s2));
        System.out.println(combine("Hannah","Douglas"));


    }

    private static String combine(String s1, String s2) {
        StringBuilder output = new StringBuilder();
        int i = 0;
        for (; i < s1.length(); ++i) {
            output.append(s1.charAt(i));
            if (i < s2.length()) {
                output.append(s2.charAt(i));
            }
        }
        if (i < s2.length()) {
            for (; i < s2.length();++i) {
                output.append(s2.charAt(i));
            }
        }
        return output.toString();
    }

    private static int misMatchedChar(String s1, String s2) {
        int count = 0;
        int minLength = Math.min(s1.length(),s2.length());
        char[] c1  = s1.toCharArray();
        char[] c2  = s2.toCharArray();

        for (int i = 0; i < minLength; i++) {
            if (c1[i] != c2[i]) {
                count++;
            }
        }
        return count;
    }
}