package com.example.cuoiky.model;

public class taikhoan {

    //Các biến
    private int mid;
    private String mHovaten;
    private String mCCCD;
    private String mMatkhau;
    private String mTramyte;
    private String mTieusubenh;
    private int mPhanQuyen;

    //hàm khởi tạo
    public taikhoan(String mHovaten, String mCCCD, String mMatkhau, String mTramyte, String mTieusubenh, int mPhanQuyen) {
        this.mHovaten = mHovaten;
        this.mCCCD = mCCCD;
        this.mMatkhau = mMatkhau;
        this.mTramyte = mTramyte;
        this.mTieusubenh = mTieusubenh;
        this.mPhanQuyen = mPhanQuyen;
    }

    public taikhoan(String mHovaten, String mCCCD) {
        this.mHovaten = mHovaten;
        this.mCCCD = mCCCD;
    }

    //Các getter và setter

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getmHovaten() {
        return mHovaten;
    }

    public void setmHovaten(String mHovaten) {
        this.mHovaten = mHovaten;
    }

    public String getmCCCD() {
        return mCCCD;
    }

    public void setmCCCD(String mCCCD) {
        this.mCCCD = mCCCD;
    }

    public String getmMatkhau() {
        return mMatkhau;
    }

    public void setmMatkhau(String mMatkhau) {
        this.mMatkhau = mMatkhau;
    }

    public String getmTramyte() {
        return mTramyte;
    }

    public void setmTramyte(String mTramyte) {
        this.mTramyte = mTramyte;
    }

    public String getmTieusubenh() {
        return mTieusubenh;
    }

    public void setmTieusubenh(String mTieusubenh) {
        this.mTieusubenh = mTieusubenh;
    }

    public int getmPhanQuyen() {
        return mPhanQuyen;
    }

    public void setmPhanQuyen(int mPhanQuyen) {
        this.mPhanQuyen = mPhanQuyen;
    }
}
