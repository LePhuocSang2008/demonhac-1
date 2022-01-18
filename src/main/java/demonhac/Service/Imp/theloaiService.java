package demonhac.Service.Imp;

import java.util.List;

import demonhac.Dao.ItheloaiDao;
import demonhac.Dao.Imp.theloaiDao;
import demonhac.Model.theloaiModel;
import demonhac.Service.ItheloaiService;

public class theloaiService implements ItheloaiService{

	private ItheloaiDao theloai_Dao;
	
	public theloaiService() {
		super();
		this.theloai_Dao = new theloaiDao();
	}
	@Override
	public List<theloaiModel> findALL() {
		
		return this.theloai_Dao.findALL();
	}
	@Override
	public List<theloaiModel> findALL_limit(Integer start, Integer soluong1dong) {
		return this.theloai_Dao.findALL_limit(start, soluong1dong);
	}
	@Override
	public List<theloaiModel> findALL_byIDtheloai(Integer id_theloai) {
		return this.theloai_Dao.findALL_byIDtheloai(id_theloai);
	}
	@Override
	public void delete_IDtheloai(Integer idtheloai) {
		this.theloai_Dao.delete_IDtheloai(idtheloai);
		
	}

}
