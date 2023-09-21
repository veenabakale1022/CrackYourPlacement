class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for (String part : parts) {
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!part.isEmpty() && !part.equals(".")) {
                stack.push(part);
            }
        }
        
        StringBuilder simplifiedPath = new StringBuilder();
        for (String part : stack) {
            simplifiedPath.append("/").append(part);
        }
        
        return simplifiedPath.length() == 0 ? "/" : simplifiedPath.toString();
      
    }
}
