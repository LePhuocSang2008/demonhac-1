package demonhac.Service.Imp;

import java.util.List;

import demonhac.Dao.IuserDao;
import demonhac.Dao.Imp.userDao;
import demonhac.Model.userModel;
import demonhac.Service.IuserService;

public class userService implements IuserService{

	private IuserDao user_Dao;
	
	public userService() {
		super();
		this.user_Dao = new userDao();
	}
	@Override
	public List<userModel> findALL_byUser_Pass(String username, String password) {
		return this.user_Dao.findALL_byUser_Pass(username, password);
	}
	@Override
	public void add_user(String username, String img, String password) {
		this.user_Dao.add_user(username, img,password);
		
	}
	@Override
	public List<userModel> findALL() {
		return this.user_Dao.findALL();
	}
	
	@Override
	public void delete_IDtaikhoan(Integer idtaikhoan) {
		this.user_Dao.delete_IDtaikhoan(idtaikhoan);
		
	}

}
