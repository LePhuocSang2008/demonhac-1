package demonhac.Dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demonhac.Dao.IcasiDao;
import demonhac.Model.casiModel;
import demonhac.Model.music_casiModel;
import demonhac.Model.theloaiModel;

public class casiDao  extends AbstractDao implements IcasiDao{

	@Override
	public List<casiModel> findALL() {
		List<casiModel> ds= new ArrayList<casiModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT * FROM casi ";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			rs=ps.executeQuery();			
			while (rs.next()) {
					casiModel casi = new casiModel();
					casi.setId(rs.getInt(1));
					casi.setTencasi(rs.getString(2));
					casi.setMota(rs.getString(3));
					casi.setHinhanh(rs.getString(4));
	              ds.add(casi);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public List<casiModel> findALL_byCasi_limit(Integer start, Integer socasi1trang) {
		List<casiModel> ds= new ArrayList<casiModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT * FROM casi LIMIT ?,?  ";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, socasi1trang);
			rs=ps.executeQuery();			
			while (rs.next()) {
				casiModel casi = new casiModel();
				casi.setId(rs.getInt(1));
				casi.setTencasi(rs.getString(2));
				casi.setMota(rs.getString(3));
				casi.setHinhanh(rs.getString(4));
	              ds.add(casi);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public List<music_casiModel> findALL_byIdCasi_Music(Integer idcasi) {
		
		List<music_casiModel> ds= new ArrayList<music_casiModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT music.*,casi.tencasi,casi.mota,casi.hinhanh,theloai.tentheloai FROM `music` INNER JOIN casi INNER JOIN theloai   on music.idcasi=casi.id AND theloai.id=music.idtheloai  WHERE idcasi =?";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			ps.setInt(1, idcasi);
			rs=ps.executeQuery();			
			while (rs.next()) {
				music_casiModel music = new music_casiModel();
	    		  music.setId(rs.getInt(1));	
	    			music.setIdcasi(rs.getInt(2));
	    			music.setIdtheloai(rs.getInt(3));
	    			music.setNgaytao(rs.getString(4));
	    			music.setLuotnghe(rs.getInt(5));
	    			music.setLinkhinhanh(rs.getString(6));
	    			music.setTennhac(rs.getString(7));
	    			music.setLinknhac(rs.getString(8));	
	    			music.setLoibaihat(rs.getString(9));
	    			music.setTencasi(rs.getString(10));
	    			music.setMota(rs.getString(11));
	    			music.setHinhanh(rs.getString(12));
	    			music.setTentheloai(rs.getString(13));
	              ds.add(music);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		}    
	}

	@Override
	public List<casiModel> find_byIdCasi(Integer idcasi) {
		List<casiModel> ds= new ArrayList<casiModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT * FROM `casi` WHERE id = ?  ";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			ps.setInt(1, idcasi);
			rs=ps.executeQuery();			
			while (rs.next()) {
				casiModel casi = new casiModel();
				casi.setId(rs.getInt(1));
				casi.setTencasi(rs.getString(2));
				casi.setMota(rs.getString(3));
				casi.setHinhanh(rs.getString(4));
	              ds.add(casi);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public List<music_casiModel> findALL_byIdCasi_Music_limit(Integer idcasi, Integer start, Integer somusic1trang) {
		List<music_casiModel> ds= new ArrayList<music_casiModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT music.*,casi.tencasi,casi.mota,casi.hinhanh,theloai.tentheloai FROM `music` INNER JOIN casi INNER JOIN theloai   on music.idcasi=casi.id AND theloai.id=music.idtheloai  WHERE idcasi =? LIMIT ?,?";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			ps.setInt(1, idcasi);
			ps.setInt(2, start);
			ps.setInt(3, somusic1trang);
			rs=ps.executeQuery();			
			while (rs.next()) {
				music_casiModel music = new music_casiModel();
	    		  music.setId(rs.getInt(1));	
	    			music.setIdcasi(rs.getInt(2));
	    			music.setIdtheloai(rs.getInt(3));
	    			music.setNgaytao(rs.getString(4));
	    			music.setLuotnghe(rs.getInt(5));
	    			music.setLinkhinhanh(rs.getString(6));
	    			music.setTennhac(rs.getString(7));
	    			music.setLinknhac(rs.getString(8));	
	    			music.setLoibaihat(rs.getString(9));
	    			music.setTencasi(rs.getString(10));
	    			music.setMota(rs.getString(11));
	    			music.setHinhanh(rs.getString(12));
	    			music.setTentheloai(rs.getString(13));
	              ds.add(music);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		}	
	}
	
	

	



}
