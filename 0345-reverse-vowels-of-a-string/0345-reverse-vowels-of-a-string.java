class Solution {
    public String reverseVowels(String s) {
        
        int i=0;
        int j=s.length()-1;

        StringBuilder res=new StringBuilder(s);
        while(i<=j)
        {
           char c=res.charAt(i);
           char d=res.charAt(j);
           if((c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U') && (d=='a'||d=='e'||d=='i'||d=='o'||d=='u'||d=='A'||d=='E'||d=='I'||d=='O'||d=='U') )
           {
                char temp=c;
                res.setCharAt(i,d);
                res.setCharAt(j,temp);
                i++;
                j--;
           }
           else if((c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U') && !(d=='a'||d=='e'||d=='i'||d=='o'||d=='u'||d=='A'||d=='E'||d=='I'||d=='O'||d=='U'))
           {
                j--;
           }
           else if(!(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U') && (d=='a'||d=='e'||d=='i'||d=='o'||d=='u'||d=='A'||d=='E'||d=='I'||d=='O'||d=='U'))
           {
                i++;
           }
           else if(!(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U') && !(d=='a'||d=='e'||d=='i'||d=='o'||d=='u'||d=='A'||d=='E'||d=='I'||d=='O'||d=='U'))
           {
                i++;
                j--;
           }
          
        }

        return res.toString();
    }
}