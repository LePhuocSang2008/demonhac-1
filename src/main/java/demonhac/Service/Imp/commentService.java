package demonhac.Service.Imp;

import java.util.List;

import demonhac.Dao.IcommentDao;
import demonhac.Dao.Imp.commentDao;
import demonhac.Model.comment_userModel;
import demonhac.Service.IcommentSevrice;

public class commentService implements IcommentSevrice{
private IcommentDao comment_Dao;
	
	public commentService() {
		super();
		this.comment_Dao = new commentDao();
	}
	@Override
	public List<comment_userModel> findALL_byIDmusic(Integer id_music) {
		return this.comment_Dao.findALL_byIDmusic(id_music);
	}

	
	

}
