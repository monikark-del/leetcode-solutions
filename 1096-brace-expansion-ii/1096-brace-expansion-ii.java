import java.util.*;

class Solution {

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression, 0);
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    private int index = 0;

    private Set<String> parse(String s, int dummy) {
        return union(s);
    }

    // Handles: A,B,C
    private Set<String> union(String s) {
        Set<String> result = new HashSet<>();

        while (index < s.length() && s.charAt(index) != '}') {
            Set<String> part = concat(s);

            result.addAll(part);

            if (index < s.length() && s.charAt(index) == ',') {
                index++;
            } else {
                break;
            }
        }

        return result;
    }

    // Handles: AB C -> concatenate
    private Set<String> concat(String s) {
        Set<String> result = new HashSet<>();
        result.add("");

        while (index < s.length()
                && s.charAt(index) != ','
                && s.charAt(index) != '}') {

            Set<String> current;

            if (s.charAt(index) == '{') {
                index++; // skip '{'

                current = union(s);

                index++; // skip '}'
            } else {
                current = new HashSet<>();
                current.add(String.valueOf(s.charAt(index)));
                index++;
            }

            Set<String> temp = new HashSet<>();

            for (String a : result) {
                for (String b : current) {
                    temp.add(a + b);
                }
            }

            result = temp;
        }

        return result;
    }
}