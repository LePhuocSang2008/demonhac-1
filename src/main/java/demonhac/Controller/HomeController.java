package demonhac.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import demonhac.Model.music_casiModel;
import demonhac.Model.theloaiModel;
import demonhac.Service.IcasiSevrice;
import demonhac.Service.IcommentSevrice;
import demonhac.Service.ImusicService;
import demonhac.Service.ItheloaiService;
import demonhac.Service.IuserService;
import demonhac.Service.Imp.casiService;
import demonhac.Service.Imp.commentService;
import demonhac.Service.Imp.musicSevrice;
import demonhac.Service.Imp.theloaiService;
import demonhac.Service.Imp.userService;

@Controller
public class HomeController {
	private ItheloaiService theloai_Service;
	private ImusicService music_Service;
	private IcommentSevrice comment_Sevrice;
	private IcasiSevrice casi_Sevrice;
	private IuserService user_Sevrice;
	
	
	public HomeController() {
		super();
		this.theloai_Service = new theloaiService();
		this.music_Service = new musicSevrice();
		this.comment_Sevrice = new commentService();
		this.casi_Sevrice = new casiService();
		this.user_Sevrice = new userService();
		
	}

	@RequestMapping(value = {"/","/index"},method = RequestMethod.GET)// đường dẫn
	public String index(ModelMap md)
	{	
		md.addAttribute("theloai",this.theloai_Service.findALL());		
		md.addAttribute("newMusic",this.music_Service.findALL_bynewMusic());
		return "index_user";// trả về giao diện ko cần đuôi .jsp
	}
	
	@RequestMapping(value = {"/category"},method = RequestMethod.GET)// đường dẫn
	public String category(ModelMap md,@RequestParam( value  ="idtheloai", defaultValue = "1")int idtheloai ,
							@RequestParam( value  ="page", defaultValue = "1" ) int page)
	{
		Integer somusic1trang=9;
		Integer tongmusic=this.music_Service.findALL_byIDtheloai(idtheloai).size();// trả về số lương nhac của thể loại đóa
		Integer tongsotrang=0;
		// set giá trị tổng số trang
		if(tongmusic % somusic1trang !=0) tongsotrang=tongmusic/somusic1trang +1;
		else tongsotrang=tongmusic/somusic1trang;
		// vị trí limit muốn lấy lấy
		Integer start=(page-1)*somusic1trang;	
		md.addAttribute("theloai",this.theloai_Service.findALL());
		md.addAttribute("dulieutrang",this.music_Service.findALL_byIDtheloai_limit(idtheloai, start, somusic1trang));
		md.addAttribute("tentheloaihientai",this.music_Service.findALL_byIDtheloai_limit(idtheloai, start, somusic1trang).get(0));
		md.addAttribute("trang",page);
		md.addAttribute("tongsotrang",tongsotrang);
		md.addAttribute("idtheloai",idtheloai);
		return "category";// trả về giao diện ko cần đuôi .jsp
	}
	// hiển thị chi tiết bài hát
	@RequestMapping(value = "/artist",method = RequestMethod.GET)
	public String artist(ModelMap md,@RequestParam( value  ="idmusic", defaultValue = "1" ) int idmusic)
	{
		try {
			music_casiModel music = this.music_Service.findBy_idmusic(idmusic).get(0);
			md.addAttribute("dulieubaihat",music);
			md.addAttribute("nametheloai",theloai_Service.findALL_byIDtheloai(music.getIdtheloai()).get(0).getTentheloai());
			md.addAttribute("listmusic_casi", music_Service.findALL_byIDcasi_notmusic(music.getIdcasi(), idmusic));
			md.addAttribute("comment_music",comment_Sevrice.findALL_byIDmusic(idmusic));
			md.addAttribute("listmusic_notcasi",this.music_Service.findALL_byIDtheloai_notcasi(music.getIdtheloai(), music.getIdcasi()));
		} catch (Exception e) {
			//....
		}
		md.addAttribute("theloai",this.theloai_Service.findALL());
		return "artist";
	}
	
	@RequestMapping(value = "/contact")
	public String contact(ModelMap md) {
		md.addAttribute("theloai",this.theloai_Service.findALL());
		return "contact";
	}
	
	@RequestMapping(value = "/blog")
	public String blog(ModelMap md) {
		md.addAttribute("theloai",this.theloai_Service.findALL());
		return "blog";
	}
	
	@RequestMapping(value = "/singer",method = RequestMethod.GET)
	public String singer(ModelMap md,@RequestParam( value  ="page", defaultValue = "1" ) int page) {
		Integer socasi1trang=9;
		Integer tongcasi=this.casi_Sevrice.findALL().size();// trả về số lương ca sĩ
		Integer tongsotrang=0;
		// set giá trị tổng số trang
		if(tongcasi % socasi1trang !=0) tongsotrang=tongcasi/socasi1trang +1;
		else tongsotrang=tongcasi/socasi1trang;
		// vị trí limit muốn lấy lấy
		Integer start=(page-1)*socasi1trang;
		md.addAttribute("casi",this.casi_Sevrice.findALL());
		md.addAttribute("dulieutrang",this.casi_Sevrice.findALL_byCasi_limit(start, socasi1trang));
		md.addAttribute("trang",page);
		md.addAttribute("tongsotrang",tongsotrang);
		md.addAttribute("theloai",this.theloai_Service.findALL());
		return "singer";
	}
	
	@RequestMapping(value = "/singerDetails",method = RequestMethod.GET)
	public String singerDetails(ModelMap md,@RequestParam( value  ="idcasi", defaultValue = "1" ) int idcasi,
											@RequestParam( value  ="page", defaultValue = "1" ) int page) {
		Integer somusic1trang=8;
		Integer tongcasi=this.casi_Sevrice.findALL_byIdCasi_Music(idcasi).size();// trả về số lương bài hát
		Integer tongsotrang=0;
		// set giá trị tổng số trang
		if(tongcasi % somusic1trang !=0) tongsotrang=tongcasi/somusic1trang +1;
		else tongsotrang=tongcasi/somusic1trang;
		// vị trí limit muốn lấy lấy
		Integer start=(page-1)*somusic1trang;
		md.addAttribute("theloai",this.theloai_Service.findALL());
		md.addAttribute("dulieucasi",this.casi_Sevrice.find_byIdCasi(idcasi).get(0));
		md.addAttribute("dulieutrang",this.casi_Sevrice.findALL_byIdCasi_Music_limit(idcasi, start, somusic1trang));
		md.addAttribute("trang",page);
		md.addAttribute("tongsotrang",tongsotrang);
		return "singerDetails";
	}
	
	@RequestMapping(value = "/login")
	public String login(ModelMap md) {
		return "login";
	}
	
	@RequestMapping(value = "/registration")
	public String registration(ModelMap md) {
		return "registration";
	}
	
	@RequestMapping(value = "/xulilogin", method = RequestMethod.POST)
	public String xulylogin(ModelMap md , @RequestParam("username") String username,
											@RequestParam("password") String password,
											HttpSession session) {
		
		
		Integer tonguser =this.user_Sevrice.findALL_byUser_Pass(username,password).size();// trả về số lương ca sĩ
//			Integer quyen = this.user_Sevrice.findALL_byUser_Pass(username,password).get(0).getQuyen();
		 
		 if( tonguser > 0 &&  this.user_Sevrice.findALL_byUser_Pass(username,password).get(0).getQuyen() == 0) {		 
			session.setAttribute("username", username);
			return "admin_casi";	
		 }else if(tonguser > 0 &&  this.user_Sevrice.findALL_byUser_Pass(username,password).get(0).getQuyen() == 1) {
			 session.setAttribute("username", username);
			 md.addAttribute("theloai",this.theloai_Service.findALL());		
			 md.addAttribute("newMusic",this.music_Service.findALL_bynewMusic());
			return "index_user";
		}else{
			md.put("error", "Invalid Account");
			return "login";
		 }	
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "login";
	}
	
	@RequestMapping(value = "/admin_casi")
	public String admin_casi(ModelMap md) {	
		return "admin_casi";
	}
	
	@RequestMapping(value = "/admin_theloai")
	public String admin_theloai(ModelMap md) {	
		return "admin_theloai";
	}
	
	@RequestMapping(value = "/admin_baihat")
	public String admin_baihat(ModelMap md) {	
		return "admin_baihat";
	}
	
	@RequestMapping(value = "/admin_taikhoan")
	public String admin_taikhoan(ModelMap md) {	
		return "admin_taikhoan";
	}
	

}
