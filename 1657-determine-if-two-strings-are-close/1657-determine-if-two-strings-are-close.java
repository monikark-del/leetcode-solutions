class Solution {
    public boolean closeStrings(String word1, String word2) {
        
        HashMap<Character,Integer> m1=new HashMap<>();
        HashMap<Character,Integer> m2=new HashMap<>();
        
        if(word1.length()!=word2.length())
        {
            return false;
        }
        for(char i:word1.toCharArray())
        {
            m1.put(i,m1.getOrDefault(i,0)+1);
        }

        for(char i:word2.toCharArray())
        {
            m2.put(i,m2.getOrDefault(i,0)+1);
        }

        for(char i:word2.toCharArray())
        {
            if(!m1.containsKey(i))
            {
                return false;
            }

        }
        ArrayList<Integer> a=new ArrayList<>();

        for(int i: m1.values())
        {
            a.add(i);
        }
        ArrayList<Integer> a2= new ArrayList<>();
        for(int i:m2.values())
        {
            a2.add(i);
        }
        Collections.sort(a);
        Collections.sort(a2);

        return a.equals(a2);
    }
}