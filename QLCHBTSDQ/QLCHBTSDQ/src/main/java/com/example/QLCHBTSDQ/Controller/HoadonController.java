package com.example.QLCHBTSDQ.Controller;

import com.example.QLCHBTSDQ.entities.Hoadon;
import com.example.QLCHBTSDQ.Repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/hoadon")
public class HoadonController {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    // Lấy tất cả hóa đơn
    @GetMapping("/all")
    public Iterable<Hoadon> getAllHoaDon() {
        return hoaDonRepository.findAll();
    }

    // Thêm mới hóa đơn
    @PostMapping("/add")
    public String addHoaDon(@RequestBody Hoadon hoaDon) {
        hoaDonRepository.save(hoaDon);
        return "Hóa đơn đã được lưu!";
    }

    // Xóa hóa đơn
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHoaDon(@PathVariable Integer id) {
        if (!hoaDonRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Không tìm thấy hóa đơn!");
        }

        hoaDonRepository.deleteById(id);
        return ResponseEntity.ok("Đã xóa hóa đơn!");
    }

    // Cập nhật hóa đơn
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateHoaDon(@PathVariable Integer id, @RequestBody Hoadon hoaDonMoi) {
        Optional<Hoadon> optional = hoaDonRepository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.badRequest().body("Không tìm thấy hóa đơn!");
        }

        Hoadon hoaDon = optional.get();
        hoaDon.setMadonhang(hoaDonMoi.getMadonhang());
        hoaDon.setNgaythanhtoan(hoaDonMoi.getNgaythanhtoan());
        hoaDon.setPhuongthucthanhtoan(hoaDonMoi.getPhuongthucthanhtoan());
        hoaDon.setSotienthanhtoan(hoaDonMoi.getSotienthanhtoan());

        hoaDonRepository.save(hoaDon);
        return ResponseEntity.ok("Cập nhật hóa đơn thành công!");
    }
}
