package com.example.postapi;

public class dathang {
    long idhoadon;
    long idmathang;
    long soluong;
    float giatienhientai;
    float thanhtien;

    public dathang(long idhoadon, long idmathang, long soluong, float giatienhientai, float thanhtien) {
        this.idhoadon = idhoadon;
        this.idmathang = idmathang;
        this.soluong = soluong;
        this.giatienhientai = giatienhientai;
        this.thanhtien = thanhtien;
    }

    public dathang()
    {

    }

    public Long getIdhoadon() {
        return idhoadon;
    }

    public void setIdhoadon(Long idhoadon) {
        this.idhoadon = idhoadon;
    }

    public Long getIdmathang() {
        return idmathang;
    }

    public void setIdmathang(Long idmathang) {
        this.idmathang = idmathang;
    }

    public Long getSoluong() {
        return soluong;
    }

    public void setSoluong(Long soluong) {
        this.soluong = soluong;
    }

    public Float getGiatienhientai() {
        return giatienhientai;
    }

    public void setGiatienhientai(Float giatienhientai) {
        this.giatienhientai = giatienhientai;
    }

    public Float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(Float thanhtien) {
        this.thanhtien = thanhtien;
    }
}
