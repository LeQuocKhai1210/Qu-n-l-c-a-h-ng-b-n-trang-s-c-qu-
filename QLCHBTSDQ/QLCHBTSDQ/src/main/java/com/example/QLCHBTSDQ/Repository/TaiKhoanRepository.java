package com.example.QLCHBTSDQ.Repository;
import com.example.QLCHBTSDQ.entities.Taikhoan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TaiKhoanRepository extends CrudRepository<Taikhoan, Integer> {
    boolean existsByTendangnhap(String tendangnhap);

    Optional<Taikhoan> findByTendangnhapAndMatkhau(String tendangnhap, String matkhau);

    Optional<Taikhoan> findByTendangnhap(String tendangnhap);
}