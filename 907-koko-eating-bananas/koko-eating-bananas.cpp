#include <cmath>
#include <numeric>
#include <vector>
using namespace std;

class Solution {
public:
    int totalHours(vector<int>& piles, int hour, int h) {
        int total_hours = 0;
        for (int i = 0; i < piles.size(); i++) {
            total_hours += (piles[i] + hour - 1) / hour;
            if (total_hours > h)
                break;
        }
        return total_hours;
    }

    int minEatingSpeed(vector<int>& piles, int h) {
        int n = *max_element(piles.begin(), piles.end());
        int start = 1, end = n;
        int result = end;
        while (start <= end) {
            int mid = (start + end) / 2;
            int total_hours = totalHours(piles, mid, h);  
            if (total_hours <= h) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
};
