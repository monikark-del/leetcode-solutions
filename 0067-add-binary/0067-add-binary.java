class Solution {
    public String addBinary(String a, String b) {
        
        int carry=0;
        int m=a.length()-1;
        int n=b.length()-1;
        String ans="";


        while(m>=0 || n>= 0|| carry!=0)
        {
            int sum=0;
        
            if(m>=0)
            {
                sum+=a.charAt(m)-'0';
                m--;
            }
            if(n>=0)
            {
                sum+=b.charAt(n)-'0';
                n--;
            }
           
            sum+=carry;

            int bit=sum%2;
            carry=sum/2;
            ans+=(char)(bit+'0');

        }
        StringBuilder s=new StringBuilder(ans);
        s.reverse();
        return s.toString();

    }
}