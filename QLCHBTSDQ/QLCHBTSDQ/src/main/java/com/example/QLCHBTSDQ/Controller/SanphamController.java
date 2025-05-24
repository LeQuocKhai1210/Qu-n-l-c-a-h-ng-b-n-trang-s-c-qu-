package com.example.QLCHBTSDQ.Controller;
import com.example.QLCHBTSDQ.entities.Sanpham;
import com.example.QLCHBTSDQ.Repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;



@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/sanpham")
public class SanphamController {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    // Lấy tất cả sản phẩm
    @GetMapping("/all")
    public Iterable<Sanpham> getAllSanPham() {
        return sanPhamRepository.findAll();
    }

    // Thêm sản phẩm mới
    @PostMapping("/add")
    public String addSanPham(@RequestBody Sanpham sp) {
        sanPhamRepository.save(sp);
        return "Đã thêm sản phẩm";
    }

    // Xóa sản phẩm
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSanPham(@PathVariable Integer id) {
        if (!sanPhamRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Không tìm thấy sản phẩm!");
        }

        sanPhamRepository.deleteById(id);
        return ResponseEntity.ok("Xóa sản phẩm thành công!");
    }

    // Cập nhật sản phẩm
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateSanPham(@PathVariable Integer id, @RequestBody Sanpham spMoi) {
        Optional<Sanpham> optional = sanPhamRepository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.badRequest().body("Không tìm thấy sản phẩm!");
        }


        Sanpham sp = optional.get();
        sp.setTensanpham(spMoi.getTensanpham());
        sp.setMaloai(spMoi.getMaloai());
        sp.setMota(spMoi.getMota());
        sp.setChatlieu(spMoi.getChatlieu());
        sp.setDaquy(spMoi.getDaquy());
        sp.setGia(spMoi.getGia());
        sp.setSoluongton(spMoi.getSoluongton());
        sp.setHinhanh(spMoi.getHinhanh());

        sanPhamRepository.save(sp);
        return ResponseEntity.ok("Cập nhật sản phẩm thành công!");
    }
}
