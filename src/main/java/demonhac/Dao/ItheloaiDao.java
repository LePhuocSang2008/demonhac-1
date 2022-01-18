package demonhac.Dao;

import java.util.List;


import demonhac.Model.theloaiModel;

public interface ItheloaiDao {
	List<theloaiModel> findALL();
	List<theloaiModel> findALL_limit(Integer start,Integer soluong1dong);
	List<theloaiModel> findALL_byIDtheloai(Integer id_theloai);
	
	void delete_IDtheloai(Integer idtheloai);
}
