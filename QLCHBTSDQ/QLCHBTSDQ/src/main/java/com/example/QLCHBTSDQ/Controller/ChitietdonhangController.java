package com.example.QLCHBTSDQ.Controller;
import com.example.QLCHBTSDQ.entities.Chitietdonhang;
import com.example.QLCHBTSDQ.Repository.ChiTietDonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chitietdonhang")
public class ChitietdonhangController {
    @Autowired
    private ChiTietDonHangRepository repository;

    // Lấy tất cả chi tiết đơn hàng
    @GetMapping("/all")
    public Iterable<Chitietdonhang> getAll() {
        return repository.findAll();
    }

    // Lấy chi tiết theo mã đơn hàng
    @GetMapping("/bydonhang/{madonhang}")
    public List<Chitietdonhang> getByDonHang(@PathVariable Integer madonhang) {
        return repository.findByMadonhang(madonhang);
    }

    // Thêm mới
    @PostMapping("/add")
    public String add(@RequestBody Chitietdonhang chitiet) {
        repository.save(chitiet);
        return "Đã thêm chi tiết đơn hàng!";
    }

    // Xoá chi tiết đơn hàng
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.badRequest().body("Không tìm thấy chi tiết đơn hàng!");
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Đã xoá thành công!");
    }

    // Cập nhật chi tiết đơn hàng
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody Chitietdonhang moi) {
        Optional<Chitietdonhang> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.badRequest().body("Không tìm thấy chi tiết đơn hàng!");
        }

        Chitietdonhang chitiet = optional.get();
        chitiet.setMadonhang(moi.getMadonhang());
        chitiet.setMasanpham(moi.getMasanpham());
        chitiet.setSoluong(moi.getSoluong());
        chitiet.setGia(moi.getGia());

        repository.save(chitiet);
        return ResponseEntity.ok("Cập nhật thành công!");
    }
}
