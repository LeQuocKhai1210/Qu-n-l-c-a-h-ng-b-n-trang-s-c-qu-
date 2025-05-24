package com.example.QLCHBTSDQ.Controller;
import com.example.QLCHBTSDQ.entities.Nhanvien;
import com.example.QLCHBTSDQ.Repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/nhanvien")

public class NhanvienController {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    // Lấy tất cả nhân viên
    @GetMapping("/all")
    public Iterable<Nhanvien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    // Thêm nhân viên
    @PostMapping("/add")
    public String addNhanVien(@RequestBody Nhanvien nv) {
        nhanVienRepository.save(nv);
        return "Đã thêm nhân viên";
    }

    // Xóa nhân viên
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNhanVien(@PathVariable Integer id) {
        if (!nhanVienRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Không tìm thấy nhân viên!");
        }

        nhanVienRepository.deleteById(id);
        return ResponseEntity.ok("Xóa nhân viên thành công!");
    }

    // Cập nhật nhân viên
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateNhanVien(@PathVariable Integer id, @RequestBody Nhanvien nvMoi) {
        Optional<Nhanvien> optional = nhanVienRepository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.badRequest().body("Không tìm thấy nhân viên!");
        }

        Nhanvien nv = optional.get();
        nv.setHoten(nvMoi.getHoten());
        nv.setSodienthoai(nvMoi.getSodienthoai());
        nv.setDiachi(nvMoi.getDiachi());
        nv.setMataikhoan(nvMoi.getMataikhoan());

        nhanVienRepository.save(nv);
        return ResponseEntity.ok("Cập nhật nhân viên thành công!");
    }
}
