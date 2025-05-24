package com.example.QLCHBTSDQ.entities;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "sanpham")
public class Sanpham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer masanpham;

    @Column(nullable = false, length = 100)
    private String tensanpham;

    @Column(nullable = false)
    private Integer maloai;

    @Column(columnDefinition = "text")
    private String mota;

    @Column(length = 50)
    private String chatlieu;

    @Column(length = 50)
    private String daquy;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal gia;

    @Column(nullable = false)
    private Integer soluongton;

    @Column(length = 255)
    private String hinhanh;

    // Getters và Setters
    public Integer getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(Integer masanpham) {
        this.masanpham = masanpham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public Integer getMaloai() {
        return maloai;
    }

    public void setMaloai(Integer maloai) {
        this.maloai = maloai;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getChatlieu() {
        return chatlieu;
    }

    public void setChatlieu(String chatlieu) {
        this.chatlieu = chatlieu;
    }

    public String getDaquy() {
        return daquy;
    }

    public void setDaquy(String daquy) {
        this.daquy = daquy;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public Integer getSoluongton() {
        return soluongton;
    }

    public void setSoluongton(Integer soluongton) {
        this.soluongton = soluongton;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
}
