package com.example.QLCHBTSDQ.Controller;
import com.example.QLCHBTSDQ.entities.Taikhoan;
import com.example.QLCHBTSDQ.Repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "http://localhost:5173") // Chỉ định nguồn gốc của ứng dụng React
@RequestMapping("/taikhoan")
public class TaikhoanController {
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Taikhoan tk) {
        Optional<Taikhoan> userOpt = taiKhoanRepository.findByTendangnhap(tk.getTendangnhap());

        if (userOpt.isPresent()) {
            Taikhoan user = userOpt.get();
            if (user.getMatkhau().equals(tk.getMatkhau())) {
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.status(401).body("Sai tài khoản hoặc mật khẩu!");
    }

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    // Lấy tất cả tài khoản
    @GetMapping("/all")
    public @ResponseBody Iterable<Taikhoan> getAllTaiKhoan() {
        return taiKhoanRepository.findAll();
    }

    // Thêm tài khoản mới
    @PostMapping("/add")
    public @ResponseBody String addTaiKhoan(@RequestBody Taikhoan tk) {
        if (taiKhoanRepository.existsByTendangnhap(tk.getTendangnhap())) {
            return "Tên đăng nhập đã tồn tại!";
        }
        taiKhoanRepository.save(tk);
        return "Đã lưu";
    }

    // Xóa tài khoản
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTaiKhoan(@PathVariable Integer id) {
        if (!taiKhoanRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Không tìm thấy tài khoản!");
        }

        taiKhoanRepository.deleteById(id);
        return ResponseEntity.ok("Xóa tài khoản thành công!");
    }

    // Cập nhật tài khoản
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateTaiKhoan(@PathVariable Integer id, @RequestBody Taikhoan updated) {
        Optional<Taikhoan> optionalTK = taiKhoanRepository.findById(id);
        if (optionalTK.isEmpty()) {
            return ResponseEntity.badRequest().body("Không tìm thấy tài khoản!");
        }

        Taikhoan tk = optionalTK.get();
        tk.setTendangnhap(updated.getTendangnhap());
        tk.setMatkhau(updated.getMatkhau());
        tk.setVaitro(updated.getVaitro());
        taiKhoanRepository.save(tk);

        return ResponseEntity.ok("Cập nhật tài khoản thành công!");
    }
}
