package demonhac.Model;

public class commentModel {
	private Integer id;	
	private Integer idMusic;	
	private Integer idUser;	
	private String textComment;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdMusic() {
		return idMusic;
	}
	public void setIdMusic(Integer idMusic) {
		this.idMusic = idMusic;
	}
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public String getTextComment() {
		return textComment;
	}
	public void setTextComment(String textComment) {
		this.textComment = textComment;
	}
}
