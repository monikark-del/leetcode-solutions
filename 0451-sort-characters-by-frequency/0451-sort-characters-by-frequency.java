class Solution {
    public String frequencySort(String s) {
        
       HashMap<Character,Integer> t=new HashMap<>();
       for(char i:s.toCharArray())
       {
           t.put(i,t.getOrDefault(i,0)+1);
       }
       
       ArrayList<Character> list=new ArrayList<>(t.keySet());

       list.sort((a,b)-> t.get(b)-t.get(a));


       String ans="";
       for(char j:list)
       {
           while(t.get(j)!=0)
           {
               ans+=j;
               t.put(j,t.get(j)-1);
           }
       } 
       return ans;
    }
}