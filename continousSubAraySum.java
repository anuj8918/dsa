class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            int rem=sum%k;
            if(rem==0 && i>=1){
                return true;
            }
            if(map.containsKey(rem)){
                int idx=map.get(rem);
                if((i-idx)>=2){
                    return true;
                }
            }
            else{
                map.put(rem,i);
            }
        }
        return false;
    }
}