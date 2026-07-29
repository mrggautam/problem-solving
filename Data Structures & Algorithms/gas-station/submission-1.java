class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank=0;
        int n = gas.length;
        int start = 0;

        int totalGas = Arrays.stream(gas).sum();
        int totalCost = Arrays.stream(cost).sum();
        if(totalGas< totalCost) {
            return -1;
        }

        for(int i=0; i<n ;i++) {
            tank += gas[i];
            tank -= cost[i];
            if(tank<0) {
                tank=0;
                start=i+1;
            }
        }

        return start;
    }
}
