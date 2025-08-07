#include <vector>
#include <numeric>
#include <cmath>   
using namespace std;

class Solution {
public:
    double totalHours(vector<int> &piles, int hour){
        double total_hours = 0;
        for(int i=0; i<piles.size();i++){
            total_hours += ceil((double)piles[i]/hour);
        }
        return total_hours;
    }
    
    int minEatingSpeed(vector<int>& piles, int h) {
        int n = *max_element(piles.begin(), piles.end());
        int start = 1, end = n;
        int result = end;
        while(start<=end){
            int mid = (start+end)/2;
            double total_hours = totalHours(piles, mid);
            if(total_hours <= (double)h) {
                result = mid;
                end = mid-1;
            }
            else start = mid+1;
        }
        return (int)result;
    }
};