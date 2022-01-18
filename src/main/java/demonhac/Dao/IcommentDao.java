package demonhac.Dao;

import java.util.List;

import demonhac.Model.commentModel;
import demonhac.Model.comment_userModel;

public interface IcommentDao {
	List<comment_userModel> findALL_byIDmusic(Integer id_music);
	
}
