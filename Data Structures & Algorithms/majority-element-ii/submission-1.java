class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int num1 = -1;
        int count1 = 0;
        int num2 = -1;
        int count2 = 0;
        int n=nums.length;

        for(int num: nums) {
            if(num == num1) {
                count1++;
            } else if(num == num2) {
                count2++;
            } else if(count1 == 0) {
                count1=1;
                num1=num;
            } else if(count2 == 0) {
                count2=1;
                num2=num;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;
        for (int num : nums) {
            if (num == num1) {
                count1++;
            } else if (num == num2) {
                count2++;
            }
        }

        ArrayList<Integer> result = new ArrayList();
        if(count1> n/3) {
            result.add(num1);
        }
        if(count2> n/3) {
            result.add(num2);
        }

        return result;
    }
}