class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0; // If the needle is empty, return 0.
        }

        int hayLength = haystack.length();
        int needleLength = needle.length();

        for (int i = 0; i <= hayLength - needleLength; i++) {
            // Check if the substring starting at index i matches the needle.
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i; // Return the index where the first occurrence is found.
            }
        }

        return -1;
        
    }
}
