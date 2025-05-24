package com.example.QLCHBTSDQ.Controller;
import com.example.QLCHBTSDQ.entities.Loaisanpham;
import com.example.QLCHBTSDQ.Repository.LoaiSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/loaisanpham")
public class LoaisanphamController {
    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;

    // Lấy tất cả loại sản phẩm
    @GetMapping("/all")
    public Iterable<Loaisanpham> getAllLoai() {
        return loaiSanPhamRepository.findAll();
    }

    // Thêm loại sản phẩm
    @PostMapping("/add")
    public String addLoai(@RequestBody Loaisanpham loai) {
        loaiSanPhamRepository.save(loai);
        return "Đã thêm loại sản phẩm";
    }

    // Xóa loại sản phẩm
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLoai(@PathVariable Integer id) {
        if (!loaiSanPhamRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Không tìm thấy loại sản phẩm!");
        }

        loaiSanPhamRepository.deleteById(id);
        return ResponseEntity.ok("Xóa thành công!");
    }

    // Cập nhật loại sản phẩm
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateLoai(@PathVariable Integer id, @RequestBody Loaisanpham loaiMoi) {
        Optional<Loaisanpham> optional = loaiSanPhamRepository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.badRequest().body("Không tìm thấy loại sản phẩm!");
        }

        Loaisanpham loai = optional.get();
        loai.setTenloai(loaiMoi.getTenloai());

        loaiSanPhamRepository.save(loai);
        return ResponseEntity.ok("Cập nhật thành công!");
    }
}
