package demonhac.Service;

import java.util.List;

import demonhac.Model.userModel;

public interface IuserService {
	List<userModel> findALL_byUser_Pass(String username,String password);
}
