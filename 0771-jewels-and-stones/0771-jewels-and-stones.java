class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        
        HashMap<Character,Integer> m=new HashMap<>();
        for(int i=0;i<jewels.length();i++)
        {
            m.put(jewels.charAt(i),m.getOrDefault(jewels.charAt(i),0)+1);
        }
        
        int count=0;
        for(int i=0;i<stones.length();i++)
        {
            if(m.containsKey(stones.charAt(i)))
            {
                count++;
            }

        }
    return count;
    }
}