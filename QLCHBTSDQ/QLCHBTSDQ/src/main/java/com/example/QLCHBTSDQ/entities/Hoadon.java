package com.example.QLCHBTSDQ.entities;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "hoadon")
public class Hoadon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mahoadon;

    @Column(nullable = false)
    private Integer madonhang;

    private LocalDateTime ngaythanhtoan = LocalDateTime.now();

    @Column(nullable = false, length = 50)
    private String phuongthucthanhtoan;

    @Column(precision = 10, scale = 2)
    private BigDecimal sotienthanhtoan;

    // Getters & Setters
    public Integer getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(Integer mahoadon) {
        this.mahoadon = mahoadon;
    }

    public Integer getMadonhang() {
        return madonhang;
    }

    public void setMadonhang(Integer madonhang) {
        this.madonhang = madonhang;
    }

    public LocalDateTime getNgaythanhtoan() {
        return ngaythanhtoan;
    }

    public void setNgaythanhtoan(LocalDateTime ngaythanhtoan) {
        this.ngaythanhtoan = ngaythanhtoan;
    }

    public String getPhuongthucthanhtoan() {
        return phuongthucthanhtoan;
    }

    public void setPhuongthucthanhtoan(String phuongthucthanhtoan) {
        this.phuongthucthanhtoan = phuongthucthanhtoan;
    }

    public BigDecimal getSotienthanhtoan() {
        return sotienthanhtoan;
    }

    public void setSotienthanhtoan(BigDecimal sotienthanhtoan) {
        this.sotienthanhtoan = sotienthanhtoan;
    }
}
