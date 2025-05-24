package com.example.QLCHBTSDQ.entities;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "donhang")
public class Donhang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer madonhang;

    @Column(nullable = false)
    private Integer makhachhang;

    private LocalDateTime ngaydat = LocalDateTime.now();

    @Column(nullable = false, length = 20)
    private String trangthai;

    @Column(precision = 10, scale = 2)
    private BigDecimal tongtien;

    // Getters and Setters
    public Integer getMadonhang() {
        return madonhang;
    }

    public void setMadonhang(Integer madonhang) {
        this.madonhang = madonhang;
    }

    public Integer getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(Integer makhachhang) {
        this.makhachhang = makhachhang;
    }

    public LocalDateTime getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(LocalDateTime ngaydat) {
        this.ngaydat = ngaydat;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public BigDecimal getTongtien() {
        return tongtien;
    }

    public void setTongtien(BigDecimal tongtien) {
        this.tongtien = tongtien;
    }
}
