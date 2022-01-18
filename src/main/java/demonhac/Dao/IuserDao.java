package demonhac.Dao;

import java.util.List;

import demonhac.Model.userModel;

public interface IuserDao {
	List<userModel> findALL_byUser_Pass(String username,String password);
	
	void add_user(String username,String img,String password);
	
	List<userModel> findALL();
	
	void delete_IDtaikhoan(Integer idtaikhoan);
}
