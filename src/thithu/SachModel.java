
package thithu;


public class SachModel {
    String ma ;
    String ten; 
    String dongia;
    String trangthai;

    public SachModel(String ma, String ten, String dongia, String trangthai) {
        this.ma = ma;
        this.ten = ten;
        this.dongia = dongia;
        this.trangthai = trangthai;
    }

    public SachModel() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
    
    
}
