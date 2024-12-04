public class GasStation {

    public static void main(String[] args) {
        GasStation main = new GasStation();
        main.testCanCompleteCircuit();
    }

    public static void testCanCompleteCircuit() {
        GasStation main = new GasStation();

        // Test case 1: Simple case where the circuit can be completed
        int[] gas1 = { 1, 2, 3, 4, 5 };
        int[] cost1 = { 3, 4, 5, 1, 2 };
        int result1 = main.canCompleteCircuit(gas1, cost1);
        System.out.println("Test case 1: " + (result1 == 3 ? "Passed" : "Failed"));

        // Test case 2: Case where the circuit cannot be completed
        int[] gas2 = { 2, 3, 4 };
        int[] cost2 = { 3, 4, 3 };
        int result2 = main.canCompleteCircuit(gas2, cost2);
        System.out.println("Test case 2: " + (result2 == -1 ? "Passed" : "Failed"));

        // Test case 3: All stations have equal gas and cost
        int[] gas3 = { 5, 5, 5, 5 };
        int[] cost3 = { 5, 5, 5, 5 };
        int result3 = main.canCompleteCircuit(gas3, cost3);
        System.out.println("Test case 3: " + (result3 == 0 ? "Passed" : "Failed"));

        // Test case 4: Only one station
        int[] gas4 = { 5 };
        int[] cost4 = { 4 };
        int result4 = main.canCompleteCircuit(gas4, cost4);
        System.out.println("Test case 4: " + (result4 == 0 ? "Passed" : "Failed"));

        // Test case 5: Large values
        int[] gas5 = { 100, 200, 300, 400, 500 };
        int[] cost5 = { 500, 400, 300, 200, 100 };
        int result5 = main.canCompleteCircuit(gas5, cost5);
        System.out.println("Test case 5: " + (result5 == 2 ? "Passed" : "Failed"));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int totalCost = 0;
        int curGas = 0;
        int index = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            curGas += gas[i] - cost[i];

            if (curGas < 0) {
                index = i + 1;
                curGas = 0;
            }

        }

        return totalCost > totalGas ? -1 : index;
    }
}
