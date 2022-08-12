package com.example.appsuckhoe;

public class TaikhoanActivity {

    //Các biến
    private int mid;
    private String mHovaten;
    private String mCCCD;
    private String mMatkhau;
    private String mTramyte;
    private String mTieusubenh;
    private String msdt;

    //hàm khởi tạo
    public TaikhoanActivity(String mHovaten, String mCCCD, String mMatkhau, String mTramyte, String mTieusubenh, String msdt) {
        this.mHovaten = mHovaten;
        this.mCCCD = mCCCD;
        this.mMatkhau = mMatkhau;
        this.mTramyte = mTramyte;
        this.mTieusubenh = mTieusubenh;
        this.msdt = msdt;
    }

    public TaikhoanActivity(String mHovaten, String mCCCD) {
        this.mHovaten = mHovaten;
        this.mCCCD = mCCCD;
    }

    //Các getter và setter
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
}
