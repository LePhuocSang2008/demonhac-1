package demonhac.Dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demonhac.Dao.IcommentDao;
import demonhac.Model.commentModel;
import demonhac.Model.comment_userModel;
import demonhac.Model.musicModel;

public class commentDao extends AbstractDao implements IcommentDao{

	@Override
	public List<comment_userModel> findALL_byIDmusic(Integer id_music) {
		List<comment_userModel> ds= new ArrayList<comment_userModel>();
		Connection CON = null;// dùng để  lưu  chuôi  kết nối từ abs....
		PreparedStatement ps=null;// dùng dể thực hiện try vaans;
	    ResultSet rs=null;	 // dùng dể lưu dữ liệu trả về
		String sql="SELECT comment.*,user.tentk,user.matkhau,user.hinhanh FROM `comment` INNER JOIN user on comment.idUser = user.id WHERE comment.idMusic = ?";
	    CON=this.getConnection();
	    try {
			ps=CON.prepareStatement(sql);
			ps.setInt(1, id_music);
			rs=ps.executeQuery();			
			while (rs.next()) {
				comment_userModel comment = new comment_userModel();
	    		  	comment.setId(rs.getInt(1));	
	    			comment.setIdMusic(rs.getInt(2));
	    			comment.setIdUser(rs.getInt(3));
	    			comment.setTextComment(rs.getString(4));
	    			comment.setTentk(rs.getString(5));
	    			comment.setHinhanh_user(rs.getString(7));
	              ds.add(comment);
	           }
			return ds;
		} catch (SQLException e) {					
			e.printStackTrace();
			return null;
		}    	 
	}

}
