
package thithu;

import java.util.ArrayList;
import java.sql.*;

public class SachService {
    private ArrayList<SachModel> list;
    String URL = "jdbc:sqlserver://XUANTHANH\\SQLEXPRESS:1433;encrypt=false;databaseName=QLS";
    String user = "Sa";
    String pass = "123456";
    Connection con ;
    Statement st;
    PreparedStatement ps ;
    
    public SachService(){
        list = new ArrayList<>();
        try {
            con = DriverManager.getConnection(URL,user,pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LoadData();
        
    }
    public void LoadData(){
        list.clear();
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from Sach");
            while(rs.next()){
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                String dongia = rs.getString(3);
                String trangthai = rs.getString(4);
                SachModel M = new SachModel(ma, ten, dongia, trangthai);
                list.add(M);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<SachModel> getList(){
        return list;
    }
    public void setList(ArrayList<SachModel> list){
        this.list = list;
    }
    public void Add(String ma, String ten, String dongia, String trangthai){
        try {
            ps = con.prepareStatement("Insert into NhanVien values (?,?,?,?)");
            ps.setString(1, ma);
            ps.setString(2, ten);
            ps.setString(3, dongia);
            ps.setString(4, trangthai);
            ps.execute();
            LoadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Update(String ma, String ten, String dongia, String trangthai){
        try {
            ps = con.prepareStatement("Update NhanVien SET ten = ?, dongia = ?, trangthai = ? WHERE ma = ?");
            ps.setString(1, ma);
            ps.setString(2, ten);
            ps.setString(3, dongia);
            ps.setString(4, trangthai);
            ps.execute();
            LoadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean Delete(String ma) {
        try {
            ps = con.prepareStatement("Delete from nhanvien where ma=?");
            ps.setString(1, ma);
            ps.execute();
            LoadData();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
    
    
}
