import java.util.Arrays;

public class Main {

    public static void sort(int[] A, int p, int r) {
        if (p < r) {
            int q = (int) Math.floor((p + r) / 2);
            sort(A, p, q);
            sort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    public static void merge(int[] A, int p, int q, int r) {
        int length = r - p + 1;
        int shift = p - 1;
        int[] buf = new int[length];
        int pos_1 = p - 1, pos_2 = q;
        for (int i = 0; i < length; i++) {
            if (pos_1 == q) {
                buf[i] = A[pos_2];
                pos_2++;
            } else if (pos_2 == r) {
                buf[i] = A[pos_1];
                pos_1++;
            } else if (A[pos_2] < A[pos_1]) {
                buf[i] = A[pos_2];
                pos_2++;
            } else {
                buf[i] = A[pos_1];
                pos_1++;
            }
        }
        for (int i = 0; i < length; i++) {
            A[shift + i] = buf[i];
        }
    }

    public static void func(int[] A) {
        A[0] = 0;
    }

    public static void main(String[] args) {
        int[] A = {5, 2, 4, 6, 1, 3, 2, 6};
        sort(A, 1, 8);
        System.out.println(Arrays.toString(A));
    }
}
