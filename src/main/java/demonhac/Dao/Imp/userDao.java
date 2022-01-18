package demonhac.Dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demonhac.Dao.IuserDao;
import demonhac.Model.theloaiModel;
import demonhac.Model.userModel;

public class userDao extends AbstractDao implements IuserDao {

	@Override
	public List<userModel> findALL_byUser_Pass(String username, String password) {
		List<userModel> ds= new ArrayList<userModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT * FROM user WHERE tentk = ? AND matkhau = ?  ";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();			
			while (rs.next()) {
				userModel user = new userModel();
				user.setId(rs.getInt(1));
				user.setTentk(rs.getString(2));
				user.setMatkhau(rs.getString(3));
				user.setHinhanh(rs.getString(4));
				user.setQuyen(rs.getInt(5));	    		  
	            ds.add(user);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void add_user(String username, String img, String password) {
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
		String sql="INSERT INTO user (tentk,hinhanh, matkhau,quyen) VALUES (?,?,?,1);";
	    CON=this.getConnection();
		try {
			ps=CON.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, img);
			ps.setString(3, password);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();			
		}
	}

	@Override
	public List<userModel> findALL() {
		List<userModel> ds= new ArrayList<userModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT * FROM user   ";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			rs=ps.executeQuery();			
			while (rs.next()) {
				userModel user = new userModel();
				user.setId(rs.getInt(1));
				user.setTentk(rs.getString(2));
				user.setMatkhau(rs.getString(3));
				user.setHinhanh(rs.getString(4));
				user.setQuyen(rs.getInt(5));	    		  
	            ds.add(user);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void delete_IDtaikhoan(Integer idtaikhoan) {
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
		String sql="DELETE FROM user WHERE id = ?";
	    CON=this.getConnection();
		try {
			ps=CON.prepareStatement(sql);
			ps.setInt(1, idtaikhoan);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();			
		}
	}

	
}
	

