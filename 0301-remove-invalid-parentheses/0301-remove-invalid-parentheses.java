class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> ans = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.add(s);
        visited.add(s);

        boolean found = false;

        while (!q.isEmpty()) {
            
            int size = q.size();

            for (int k = 0; k < size; k++) {
                
                String curr = q.poll();

                if (isValid(curr)) {
                    ans.add(curr);
                    found = true;
                }

                // If a valid string is found at this level,
                // don't generate strings with more removals.
                if (found) {
                    continue;
                }

                for (int i = 0; i < curr.length(); i++) {
                    
                    // Only remove parentheses
                    if (curr.charAt(i) != '(' && curr.charAt(i) != ')') {
                        continue;
                    }

                    String next = curr.substring(0, i) 
                                + curr.substring(i + 1);

                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.add(next);
                    }
                }
            }

            if (found) {
                break;
            }
        }

        return ans;
    }

    public boolean isValid(String s) {
        
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            
            if (s.charAt(i) == '(') {
                count++;
            }
            else if (s.charAt(i) == ')') {
                count--;

                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}