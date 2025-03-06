package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.checkerframework.checker.units.qual.A;

@Builder
@Data
@AllArgsConstructor
public class NhanVien {

    private  String ma;
    private String ten;
    private String sdt;
    private Double luong;
    private boolean chucVu;
}
