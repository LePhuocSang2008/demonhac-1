package demonhac.Dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demonhac.Dao.ImusicDao;
import demonhac.Model.mucsic_theloaiModel;
import demonhac.Model.musicModel;
import demonhac.Model.music_casiModel;
import demonhac.Model.theloaiModel;

public class musicDao extends AbstractDao implements ImusicDao{

	@Override
	public List<musicModel> findALL_byIDtheloai(Integer id_theloai) {
		List<musicModel> ds= new ArrayList<musicModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT * FROM `music` WHERE idtheloai = ?";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			ps.setInt(1, id_theloai);
			rs=ps.executeQuery();			
			while (rs.next()) {
	    		  musicModel music = new musicModel();
	    		  	music.setId(rs.getInt(1));	
	    			music.setIdcasi(rs.getInt(2));
	    			music.setIdtheloai(rs.getInt(3));
	    			music.setNgaytao(rs.getString(4));
	    			music.setLuotnghe(rs.getInt(5));
	    			music.setLinkhinhanh(rs.getString(6));
	    			music.setTennhac(rs.getString(7));
	    			music.setLinknhac(rs.getString(8));	
	    			music.setLoibaihat(rs.getString(9));
	              ds.add(music);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		}    	 
	}

	@Override
	public List<music_casiModel> findALL_byIDtheloai_limit(Integer id_theloai, Integer start, Integer soluong1dong) {
		List<music_casiModel> ds= new ArrayList<music_casiModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT music.*,casi.tencasi,casi.mota,casi.hinhanh,theloai.tentheloai FROM `music` INNER JOIN casi INNER JOIN theloai  on music.idcasi=casi.id AND theloai.id=music.idtheloai WHERE idtheloai = ? LIMIT ?,?";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			ps.setInt(1, id_theloai);
			ps.setInt(2, start);
			ps.setInt(3, soluong1dong);
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
	public List<music_casiModel> findBy_idmusic(Integer id_music) {
		List<music_casiModel> ds= new ArrayList<music_casiModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
	    String sql="SELECT music.*,casi.tencasi,casi.mota,casi.hinhanh FROM `music` INNER JOIN casi on music.idcasi=casi.id WHERE music.id=? ";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			ps.setInt(1, id_music);
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
	              ds.add(music);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		}    	 
	}

	@Override
	public List<mucsic_theloaiModel> findALL_byIDcasi_notmusic(Integer id_casi, Integer id_music) {
		List<mucsic_theloaiModel> ds= new ArrayList<mucsic_theloaiModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT music.*,theloai.hinhanh,theloai.tentheloai FROM `music` INNER JOIN theloai ON music.idtheloai = theloai.id  WHERE music.idcasi = ? and NOT music.id = ? LIMIT 0,3";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			ps.setInt(1, id_casi);
			ps.setInt(2, id_music);
			rs=ps.executeQuery();			
			while (rs.next()) {
				mucsic_theloaiModel music = new mucsic_theloaiModel();
	    		  music.setId(rs.getInt(1));	
	    			music.setIdcasi(rs.getInt(2));
	    			music.setIdtheloai(rs.getInt(3));
	    			music.setNgaytao(rs.getString(4));
	    			music.setLuotnghe(rs.getInt(5));
	    			music.setLinkhinhanh(rs.getString(6));
	    			music.setTennhac(rs.getString(7));
	    			music.setLinknhac(rs.getString(8));	
	    			music.setLoibaihat(rs.getString(9));
	    			music.setHinhanh_theloai(rs.getString(10));
	    			music.setTentheloai(rs.getString(11));
	              ds.add(music);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		}    	 
	}

	@Override
	public List<music_casiModel> findALL_byIDtheloai_notcasi(Integer id_theloai, Integer id_casi) {
		List<music_casiModel> ds= new ArrayList<music_casiModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT music.*,casi.tencasi,casi.mota,casi.hinhanh FROM `music` INNER JOIN casi on music.idcasi=casi.id  WHERE music.idtheloai = ? and NOT music.idcasi = ?  LIMIT 0,8";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			ps.setInt(1, id_theloai);
			ps.setInt(2, id_casi);
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
	              ds.add(music);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		}    	 
	}

	@Override
	public List<musicModel> findALL_bynewMusic() {
		List<musicModel> ds= new ArrayList<musicModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT * FROM `music`  ORDER BY luotnghe DESC  LIMIT 0,12";
		   
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			rs=ps.executeQuery();			
			while (rs.next()) {
				musicModel music = new musicModel();
	    		  	music.setId(rs.getInt(1));	
	    			music.setIdcasi(rs.getInt(2));
	    			music.setIdtheloai(rs.getInt(3));
	    			music.setNgaytao(rs.getString(4));
	    			music.setLuotnghe(rs.getInt(5));
	    			music.setLinkhinhanh(rs.getString(6));
	    			music.setTennhac(rs.getString(7));
	    			music.setLinknhac(rs.getString(8));	
	    			music.setLoibaihat(rs.getString(9));
	    			
	              ds.add(music);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		}    	 
	}

	
	
	

}
