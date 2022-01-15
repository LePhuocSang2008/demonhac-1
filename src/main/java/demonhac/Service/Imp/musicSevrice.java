package demonhac.Service.Imp;

import java.util.List;

import demonhac.Dao.ImusicDao;
import demonhac.Dao.Imp.musicDao;
import demonhac.Model.mucsic_theloaiModel;
import demonhac.Model.musicModel;
import demonhac.Model.music_casiModel;
import demonhac.Service.ImusicService;

public class musicSevrice implements ImusicService{
	private ImusicDao music_Dao;
	
	public musicSevrice() {
		super();
		this.music_Dao = new musicDao();
	}
	@Override
	public List<musicModel> findALL_byIDtheloai(Integer id_theloai) {	
		return this.music_Dao.findALL_byIDtheloai(id_theloai);
	}
	@Override
	public List<music_casiModel> findALL_byIDtheloai_limit(Integer id_theloai, Integer start, Integer soluong1dong) {
		return this.music_Dao.findALL_byIDtheloai_limit(id_theloai, start, soluong1dong);
	}
	@Override
	public List<music_casiModel> findBy_idmusic(Integer id_music) {
	
		return this.music_Dao.findBy_idmusic(id_music);
	}
	@Override
	public List<mucsic_theloaiModel> findALL_byIDcasi_notmusic(Integer id_casi, Integer id_music) {
		return this.music_Dao.findALL_byIDcasi_notmusic(id_casi, id_music);
	}
	@Override
	public List<music_casiModel> findALL_byIDtheloai_notcasi(Integer id_theloai, Integer id_casi) {
		return this.music_Dao.findALL_byIDtheloai_notcasi(id_theloai, id_casi);
	}
	@Override
	public List<musicModel> findALL_bynewMusic() {
		return this.music_Dao.findALL_bynewMusic();
	}


}
