class FourDivisors {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            int factor = 0;
            int factorSum = 0;

            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    factor++;
                    factorSum += i;

                    if (i * i != num) {
                        factor++;
                        factorSum += num / i;
                    }
                }

            }

            if (factor == 4) {
                sum += factorSum;
            }
        }

        return sum;
    }
}