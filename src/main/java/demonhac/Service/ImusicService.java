package demonhac.Service;

import java.util.List;

import demonhac.Model.mucsic_theloaiModel;
import demonhac.Model.musicModel;
import demonhac.Model.music_casiModel;

public interface ImusicService {
	List<musicModel> findALL_byIDtheloai(Integer id_theloai);
	List<music_casiModel> findALL_byIDtheloai_limit(Integer id_theloai,Integer start,Integer soluong1dong);
	List<music_casiModel> findBy_idmusic(Integer id_music);
	List<mucsic_theloaiModel> findALL_byIDcasi_notmusic(Integer id_casi,Integer id_music);
	List<music_casiModel> findALL_byIDtheloai_notcasi(Integer id_theloai,Integer id_casi);
	List<musicModel> findALL_bynewMusic();
	
	List<musicModel> findALL_bynewMusic_limit(Integer start,Integer sobai1trang);
	List<music_casiModel> findALL_Music();
	
	void delete_IDbaihat(Integer idbaihat);
}
