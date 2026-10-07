class Solution {
    public String addBinary(String a, String b) {
        
        int carry=0;
        int m=a.length()-1;
        int n=b.length()-1;
        String ans="";


        while(m>=0 || n>= 0|| carry!=0)
        {
            int sum=0;
            int n1=0;
            int n2=0;
            if(m>=0)
            {
                n1=a.charAt(m)-'0';
                m--;
            }
            if(n>=0)
            {
                n2=b.charAt(n)-'0';
                n--;
            }
           
            sum=n1+n2+carry;

            int bit=sum%2;
            carry=sum/2;
            ans+=(char)(bit+'0');

        }
        StringBuilder s=new StringBuilder(ans);
        s.reverse();
        return s.toString();

    }
}