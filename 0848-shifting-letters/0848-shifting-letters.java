class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        
        int total=0;

        char[] arr=s.toCharArray();

        for(int i=s.length()-1;i>=0;i--)
        {
            total=(total+shifts[i])%26;
            
            int pos=arr[i]-'a';
            pos=(pos+total)%26;

            arr[i]=(char)(pos+'a');
            
        }
        return String.valueOf(arr);
    }
}