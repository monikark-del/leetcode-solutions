class Solution {
   /* public int pivotIndex(int[] nums) {
        
        int total=0;
        int left=0;
        int right=0;

        for(int i=0;i<nums.length;i++)
        {
            total+=nums[i];
        }

        for(int i=0;i<nums.length;i++)
        {   
          
            right=total-nums[i]-left;
            if(right==left)
            {
                return i;
            }
            left+=nums[i];
        }
        return -1;
    }*/

    public int pivotIndex(int[] nums)
    {
        long[] arr=new long[nums.length];
        long prefix=0;
        for(int i=0;i<nums.length;i++)
        {
            arr[i]=prefix;
            prefix+=nums[i];
        }
        
        
        long total=prefix;
        for(int i=0;i<nums.length;i++)
        {
            long right=total-arr[i]-nums[i];
            if(arr[i]==right)
            {
                return i;
            }
          
        }
        return -1;

    } 
}