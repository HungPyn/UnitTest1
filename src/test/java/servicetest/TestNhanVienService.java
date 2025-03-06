package servicetest;

import entity.NhanVien;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.NhanVienService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestNhanVienService {
    NhanVienService service;
    List<NhanVien> list;

    @BeforeEach
    public void setUp() throws Exception {
        service = new NhanVienService();
        list = new ArrayList<NhanVien>();
        service.setList(list);
        list.add(new NhanVien("NV01", "Nguyen Van C", "123456789", 50000.0, true));
        list.add(new NhanVien("NV02", "Nguyen Van C", "123456789", 50000.0, true));
    }

    @Test
    void testUpdateNhanVien() {
        NhanVien nv = new NhanVien("NV01", "Nguyen Van B", "234567891", 50000.0, true);
        service.update(nv);
        assertEquals("Nguyen Van B", list.get(0).getTen());
    }

    @Test
    void testUpdateNhanVien2() {
        NhanVien nv = new NhanVien("NV03", "Nguyen Van B", "234567891", 50000.0, true);
        service.update(nv);
        assertEquals(2, list.size());
    }

    @Test
    void testUpdateNhanVien3() {
        NhanVien nv = new NhanVien("NV01", "", "", 50000.0, true);
        assertThrows(IllegalArgumentException.class, () -> service.update(nv));
    }

    @Test
    void testUpdateNhanVien4() {
        NhanVien nv = null;
        assertThrows(Exception.class, () -> service.update(nv));
    }
    @Test
    void testUpdateNhanVien5() {
        NhanVien nv =new NhanVien("NV01", "", "", 0.0, true);
        assertThrows(IllegalArgumentException.class, () -> service.update(nv));
    }
}
