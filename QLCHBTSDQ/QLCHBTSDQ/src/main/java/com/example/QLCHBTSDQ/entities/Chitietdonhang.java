package com.example.QLCHBTSDQ.entities;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "chitietdonhang")
public class Chitietdonhang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer machitiet;

    @Column(nullable = false)
    private Integer madonhang;

    @Column(nullable = false)
    private Integer masanpham;

    @Column(nullable = false)
    private Integer soluong;

    @Column(precision = 10, scale = 2)
    private BigDecimal gia;

    // Getters and Setters

    public Integer getMachitiet() {
        return machitiet;
    }

    public void setMachitiet(Integer machitiet) {
        this.machitiet = machitiet;
    }

    public Integer getMadonhang() {
        return madonhang;
    }

    public void setMadonhang(Integer madonhang) {
        this.madonhang = madonhang;
    }

    public Integer getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(Integer masanpham) {
        this.masanpham = masanpham;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }
}
