package servicetest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.TinhTongService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestTinhTongService {
    private TinhTongService tinhTongService;

    @BeforeEach
    public void setUp() {
        tinhTongService = new TinhTongService();
    }

    @Test
    void testTinhTong() {
        int[] arrays = null;
//        Exception exception = assertThrows(IllegalArgumentException.class, () ->
//                tinhTongService.TinhTong(arrays));
//        assertEquals("array is null or empty", exception.getMessage());
        assertThrows(IllegalArgumentException.class, () -> {tinhTongService.TinhTong(arrays);});
    }

    @Test
    void testTinhTong2() {
        int[] arrays = {1, 2, 3, 16, 8};
        assertEquals(16 + 8, tinhTongService.TinhTong(arrays));
    }

    @Test
    void testTinhTong3() {
        int[] arrays = {-1, -2, -3, -16, -8};
        assertEquals(-16 + -8, tinhTongService.TinhTong(arrays));
    }

    @Test
    void testTinhTong4() {
        int[] arrays = {1, 2, 3, 4, 5};
        assertEquals(0, tinhTongService.TinhTong(arrays));
    }

    @Test
    void testTinhTong5() {
        int[] arrays = {-1, -8, 8, 16};
        assertEquals(-8 + 8 + 16, tinhTongService.TinhTong(arrays));
    }
}
