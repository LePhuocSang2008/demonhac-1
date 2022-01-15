package demonhac.Service;

import java.util.List;

import demonhac.Model.theloaiModel;

public interface ItheloaiService {
	List<theloaiModel> findALL();
	List<theloaiModel> findALL_limit(Integer start,Integer soluong1dong);
	List<theloaiModel> findALL_byIDtheloai(Integer id_theloai);
}
