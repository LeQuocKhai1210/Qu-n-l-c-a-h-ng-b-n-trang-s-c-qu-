package com.example.QLCHBTSDQ.Repository;

import com.example.QLCHBTSDQ.entities.Chitietdonhang;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChiTietDonHangRepository extends CrudRepository<Chitietdonhang, Integer> {
    List<Chitietdonhang> findByMadonhang(Integer madonhang);
}
