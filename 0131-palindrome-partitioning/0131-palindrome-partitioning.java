
class Solution {

    List<List<String>> p = new ArrayList<>();
    ArrayList<String> a = new ArrayList<>();

    void palindrome(int index, String s)
    {
        if(index == s.length())
        {
            p.add(new ArrayList<>(a));
            return;
        }

        for(int j = index; j < s.length(); j++)
        {
            String sub = s.substring(index, j + 1);

            if(isPalindrome(sub))
            {
                a.add(sub);

                palindrome(j + 1, s);

                a.remove(a.size() - 1);
            }
        }
    }

    boolean isPalindrome(String sub)
    {
        int i = 0;
        int j = sub.length() - 1;

        while(i < j)
        {
            if(sub.charAt(i) != sub.charAt(j))
            {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public List<List<String>> partition(String s) {

        palindrome(0, s);

        return p;
    }
}
