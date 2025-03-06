package service;

public class TinhTongService {

    public int TinhTong(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("array is null or empty");
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 8 == 0) {
                sum += array[i];
            }
        }
        return sum;
    }
}
