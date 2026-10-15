class Solution {
    public int maxArea(int[] height) {
        
        int i=0;
        int j=height.length-1;
        int area=0;

        while(i<j)
        {
            int length=Math.min(height[i],height[j]);
            int breadth=j-i;
            area=Math.max(area,length*breadth);

            if(height[i]<height[j])
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return area;
    }
}