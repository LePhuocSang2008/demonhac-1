package demonhac.Service;

import java.util.List;

import demonhac.Model.userModel;

public interface IuserService {
	List<userModel> findALL_byUser_Pass(String username,String password);
	
	void add_user(String username,String img,String password);
	
	List<userModel> findALL();
	
	void delete_IDtaikhoan(Integer idtaikhoan);
}
