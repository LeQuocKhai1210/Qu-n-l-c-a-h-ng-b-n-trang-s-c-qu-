package com.example.QLCHBTSDQ.Controller;
import com.example.QLCHBTSDQ.entities.Khachhang;
import com.example.QLCHBTSDQ.Repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/khachhang")
public class KhachhangController {

    @Autowired
    private KhachHangRepository khachHangRepository;

    // Lấy tất cả khách hàng
    @GetMapping("/all")
    public Iterable<Khachhang> getAllKhachHang() {
        return khachHangRepository.findAll();
    }

    // Thêm khách hàng
    @PostMapping("/add")
    public String addKhachHang(@RequestBody Khachhang kh) {
        khachHangRepository.save(kh);
        return "Đã thêm khách hàng";
    }

    // Xóa khách hàng
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteKhachHang(@PathVariable Integer id) {
        if (!khachHangRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Không tìm thấy khách hàng!");
        }

        khachHangRepository.deleteById(id);
        return ResponseEntity.ok("Xóa khách hàng thành công!");
    }

    // Cập nhật khách hàng
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateKhachHang(@PathVariable Integer id, @RequestBody Khachhang khMoi) {
        Optional<Khachhang> optional = khachHangRepository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.badRequest().body("Không tìm thấy khách hàng!");
        }

        Khachhang kh = optional.get();
        kh.setHoten(khMoi.getHoten());
        kh.setSodienthoai(khMoi.getSodienthoai());
        kh.setDiachi(khMoi.getDiachi());
        kh.setMataikhoan(khMoi.getMataikhoan());

        khachHangRepository.save(kh);
        return ResponseEntity.ok("Cập nhật khách hàng thành công!");
    }
}
