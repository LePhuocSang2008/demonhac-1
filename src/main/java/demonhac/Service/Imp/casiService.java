package demonhac.Service.Imp;

import java.util.List;

import demonhac.Dao.IcasiDao;
import demonhac.Dao.Imp.casiDao;
import demonhac.Model.casiModel;
import demonhac.Model.music_casiModel;
import demonhac.Service.IcasiSevrice;

public class casiService implements IcasiSevrice{

	private IcasiDao casi_Dao;
	
	public casiService() {
		super();
		this.casi_Dao = new casiDao();
	}
	
	@Override
	public List<casiModel> findALL() {
		return this.casi_Dao.findALL();
	}

	@Override
	public List<casiModel> findALL_byCasi_limit(Integer start, Integer socasi1trang) {
		
		return this.casi_Dao.findALL_byCasi_limit(start, socasi1trang);
	}

	@Override
	public List<music_casiModel> findALL_byIdCasi_Music(Integer idcasi) {
		
		return this.casi_Dao.findALL_byIdCasi_Music(idcasi);
	}

	@Override
	public List<casiModel> find_byIdCasi(Integer idcasi) {
		return this.casi_Dao.find_byIdCasi(idcasi);
	}

	@Override
	public List<music_casiModel> findALL_byIdCasi_Music_limit(Integer idcasi, Integer start, Integer somusic1trang) {
		
		return this.casi_Dao.findALL_byIdCasi_Music_limit(idcasi, start, somusic1trang);
	}

	@Override
	public void delete_IDcasi(Integer idcasi) {
		this.casi_Dao.delete_IDcasi(idcasi);
		
	}
	
	

}
