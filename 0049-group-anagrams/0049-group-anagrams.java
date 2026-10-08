class Solution {
    public List<List<String>> groupAnagrams(String[] s) {
        
        HashMap<String,ArrayList<String>> m=new HashMap<>();
        for(int i=0;i<s.length;i++)
        {
            char[] arr=s[i].toCharArray();
            Arrays.sort(arr);

            String temp=new String(arr);
            if(m.containsKey(temp))
            {
                m.get(temp).add(s[i]);
            }
            else
            {
                ArrayList<String> p=new ArrayList<>();
                p.add(s[i]);
                m.put(temp,p);
            }
        }
        List<List<String>> a=new ArrayList<>();
        for(ArrayList<String> k:m.values())
        {
            a.add(k);
        }
        return a;
    }
}