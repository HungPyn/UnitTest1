package service;

import entity.NhanVien;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
public class NhanVienService {

    List<NhanVien> list = new ArrayList<NhanVien>();

    public NhanVienService() {
    }

    boolean isValid(NhanVien nhanVien) {
        return nhanVien == null
                || nhanVien.getMa().isBlank()
                || nhanVien.getTen().isBlank()
                || nhanVien.getLuong().toString().isBlank()
                || nhanVien.getLuong() <= 0;

    }

    public void update(NhanVien nhanVien) {
        int indexUpdate = -1;
        if (isValid(nhanVien)) {
            throw new IllegalArgumentException("NhanV ien tidak valid");
        }
        for (int i = 0; i < list.size(); i++) {
            if (nhanVien.getMa().equals(list.get(i).getMa())) {
                indexUpdate = i;
                break;
            }
        }
       if (indexUpdate != -1) {
           list.set(indexUpdate, nhanVien);
       }
    }
}
