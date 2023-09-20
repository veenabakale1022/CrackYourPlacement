class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
        return "";
    }
    
    // Find the shortest string in the array
    String shortest = strs[0];
    for (String str : strs) {
        if (str.length() < shortest.length()) {
            shortest = str;
        }
    }
    
    // Check each character of the shortest string against the other strings
    for (int i = 0; i < shortest.length(); i++) {
        char c = shortest.charAt(i);
        for (String str : strs) {
            if (str.charAt(i) != c) {
                return shortest.substring(0, i); // Return the common prefix found so far
            }
        }
    }
    
    return shortest;
        
    }
}
