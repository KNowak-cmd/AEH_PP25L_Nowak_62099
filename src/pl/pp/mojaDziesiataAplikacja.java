package pl.pp;

public class mojaDziesiataAplikacja {

    /**
     * Dla tablicy input zwraca tablicę: [liczba elementów ujemnych, suma elementów dodatnich].
     * Jeśli input jest null lub pusty, zwraca pustą tablicę.
     */
    public static int[] countAndSumElements(int[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        }

        int countNegative = 0;
        int sumPositive = 0;
        for (int x : input) {
            if (x < 0) {
                countNegative++;
            } else if (x > 0) {
                sumPositive += x;
            }
        }
        return new int[]{countNegative, sumPositive};
    }

    public static void main(String[] args) {
        // Przykładowe testy metody countAndSumElements
        int[] input1 = {1, 2, 3, 4, 5, -3, -2, -1};
        int[] result1 = countAndSumElements(input1);
        System.out.println("Input: {1,2,3,4,5,-3,-2,-1} -> Liczba ujemnych: " + result1[0] + ", Suma dodatnich: " + result1[1]);

        int[] empty = {};
        int[] result2 = countAndSumElements(empty);
        System.out.println("Empty array -> length: " + result2.length);

        int[] nullArr = null;
        int[] result3 = countAndSumElements(nullArr);
        System.out.println("Null array -> length: " + result3.length);
    }
}