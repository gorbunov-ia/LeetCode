package ru.gorbunov.tasks.fb.search;

/**
 * 1 Billion Users
 * <p>
 * We have N different apps with different user growth rates. At a given time t, measured in days, the number of users
 * using an app is g^t (for simplicity we'll allow fractional users), where g is the growth rate for that app. These
 * apps will all be launched at the same time and no user ever uses more than one of the apps. We want to know how many
 * total users there are when you add together the number of users from each app.
 * After how many full days will we have 1 billion total users across the N apps?
 * Signature
 * int getBillionUsersDay(float[] growthRates)
 * Input
 * 1.0 < growthRate < 2.0 for all growth rates
 * 1 <= N <= 1,000
 * Output
 * Return the number of full days it will take before we have a total of 1 billion users across all N apps.
 * Example 1
 * growthRates = [1.5]
 * output = 52
 * Example 2
 * growthRates = [1.1, 1.2, 1.3]
 * output = 79
 * Example 3
 * growthRates = [1.01, 1.02]
 * output = 1047
 */
public class OneBillionUsers {

    public static void main(String[] args) {
        System.out.println(new OneBillionUsers().fastGetBillionUsersDay(new float[]{1.5f}));
        System.out.println(new OneBillionUsers().fastGetBillionUsersDay(new float[]{1.1f, 1.2f, 1.3f}));
        System.out.println(new OneBillionUsers().fastGetBillionUsersDay(new float[]{1.01f, 1.02f}));
    }

    int getBillionUsersDay(float[] growthRates) {
        // Write your code here
        float[] values = new float[growthRates.length];
        for (int i = 0; i < growthRates.length; i++) {
            values[i] = 1;
        }

        float sum = 0;
        int day = 0;
        while (sum < 1_000_000_000) {
            sum = 0;
            day++;
            for (int i = 0; i < growthRates.length; i++) {
                values[i] = values[i] * growthRates[i];
                sum = sum + values[i];
            }
        }
        return day;
    }

    int fastGetBillionUsersDay(float[] growthRates) {
        // Write your code here
        float minValue = growthRates[0];
        float maxValue = growthRates[0];
        for (int i = 1; i < growthRates.length; i++) {
            if (growthRates[i] < minValue) {
                minValue = growthRates[i];
            }
            if (growthRates[i] > maxValue) {
                maxValue = growthRates[i];
            }
        }

        int left = (int) Math.ceil(getDay(maxValue, growthRates.length));
        int right = (int) Math.floor(getDay(minValue, growthRates.length));

        while (left < right) {
            int mid = (left + right) / 2;

            int users = (int) countUsers(growthRates, mid);
            if (users >= 1e9) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private double getDay(float value, int n) {
        return Math.log(1e9 / n) / Math.log(value);
    }

    private double countUsers(float[] growthRates, int day) {
        double sum = 0;
        for (float growthRate : growthRates) {
            sum = sum + Math.pow(growthRate, day);
        }
        return sum;
    }
}
