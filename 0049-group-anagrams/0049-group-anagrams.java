class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,ArrayList<String>> m=new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            char[] arr=strs[i].toCharArray();
            Arrays.sort(arr);

            String ans="";
            for(char k:arr)
            {
                ans+=k;
            }

            if(m.containsKey(ans))
            {
                m.get(ans).add(strs[i]);
            }
            else
            {
                ArrayList<String> res=new ArrayList<>();
                res.add(strs[i]);
                m.put(ans,res);
            }
        }
       return new ArrayList<>(m.values());
    }
}