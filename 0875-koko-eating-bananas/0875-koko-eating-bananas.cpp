class Solution {
public:
    
    long long helper(vector<int>& piles, int k) {
        long long hours = 0;
        for (int bananas : piles) {
            hours += (bananas + k - 1) / k; 
        }
        return hours;
    }

    int minEatingSpeed(vector<int>& piles, int h) {
        int start = 1; 
        int end = *max_element(piles.begin(), piles.end());
        int res = end;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (helper(piles, mid) <= h) {
                res = mid;
                end = mid - 1; // try smaller speed
            } else {
                start = mid + 1; // need higher speed
            }
        }

        return res;
    }
};