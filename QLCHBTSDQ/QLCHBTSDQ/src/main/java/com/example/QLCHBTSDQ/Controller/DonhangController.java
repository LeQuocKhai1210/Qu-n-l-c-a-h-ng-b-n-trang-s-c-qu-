package com.example.QLCHBTSDQ.Controller;

import com.example.QLCHBTSDQ.entities.Donhang;
import com.example.QLCHBTSDQ.Repository.DonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/donhang")
public class DonhangController {

    @Autowired
    private DonHangRepository donHangRepository;

    // Lấy tất cả đơn hàng
    @GetMapping("/all")
    public Iterable<Donhang> getAllDonHang() {
        return donHangRepository.findAll();
    }

    // Thêm đơn hàng mới
    @PostMapping("/add")
    public String addDonHang(@RequestBody Donhang donHang) {
        donHangRepository.save(donHang);
        return "Đơn hàng đã được lưu!";
    }

    // Xóa đơn hàng
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDonHang(@PathVariable Integer id) {
        if (!donHangRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Không tìm thấy đơn hàng!");
        }

        donHangRepository.deleteById(id);
        return ResponseEntity.ok("Đã xóa đơn hàng!");
    }

    // Cập nhật đơn hàng
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateDonHang(@PathVariable Integer id, @RequestBody Donhang donHangMoi) {
        Optional<Donhang> optional = donHangRepository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.badRequest().body("Không tìm thấy đơn hàng!");
        }

        Donhang donHang = optional.get();
        donHang.setMakhachhang(donHangMoi.getMakhachhang());
        donHang.setNgaydat(donHangMoi.getNgaydat());
        donHang.setTrangthai(donHangMoi.getTrangthai());
        donHang.setTongtien(donHangMoi.getTongtien());

        donHangRepository.save(donHang);
        return ResponseEntity.ok("Cập nhật đơn hàng thành công!");
    }
}
