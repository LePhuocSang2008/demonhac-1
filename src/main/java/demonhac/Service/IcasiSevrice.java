package demonhac.Service;

import java.util.List;

import demonhac.Model.casiModel;
import demonhac.Model.music_casiModel;

public interface IcasiSevrice {
	List<casiModel> findALL();
	List<casiModel> findALL_byCasi_limit(Integer start, Integer socasi1trang);
	
	List<music_casiModel> findALL_byIdCasi_Music(Integer idcasi);
	List<casiModel> find_byIdCasi(Integer idcasi);
	List<music_casiModel> findALL_byIdCasi_Music_limit(Integer idcasi,Integer start,Integer somusic1trang);
	
	void delete_IDcasi(Integer idcasi);
}
