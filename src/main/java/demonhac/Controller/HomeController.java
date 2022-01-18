package demonhac.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

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
	public String index(ModelMap md,@RequestParam (value = "page", defaultValue = "1") int page)
	{	
		Integer sobai1trang = 8;
		Integer tongbai = this.music_Service.findALL_bynewMusic().size(); //Tra ve tong  so luong 
		Integer tongsotrang = 0;
		
		//set gia tri tong so trang
		if (tongbai % sobai1trang != 0) 
			tongsotrang = tongbai / sobai1trang + 1;	
		else 
			tongsotrang = tongbai / sobai1trang;		
		//Vi tri limit muon lay
		Integer start = (page - 1)* sobai1trang;
		md.addAttribute("theloai",this.theloai_Service.findALL());				
		md.addAttribute("newMusic",this.music_Service.findALL_bynewMusic_limit(start, sobai1trang));
		md.addAttribute("trang",page);
		md.addAttribute("tongsotrang",tongsotrang);

		
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
	
	//trang lien he
	@RequestMapping(value = "/contact")
	public String contact(ModelMap md) {
		md.addAttribute("theloai",this.theloai_Service.findALL());
		return "contact";
	}
	
	//trang tin tuc
	@RequestMapping(value = "/blog")
	public String blog(ModelMap md) {
		md.addAttribute("theloai",this.theloai_Service.findALL());
		return "blog";
	}
	
	//trang ca si
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
	
	//trang chi tiet ca si
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
	
	// trang dang nhap
	@RequestMapping(value = "/login")
	public String login(ModelMap md) {
		return "login";
	}
	
	//xulidangnhap
	@RequestMapping(value = "/xulilogin", method = RequestMethod.POST)
	public String xulylogin(ModelMap md , @RequestParam("username") String username,
											@RequestParam("password") String password,
											@RequestParam (value = "page", defaultValue = "1") int page,
											HttpSession session) {
		
		
		Integer tonguser =this.user_Sevrice.findALL_byUser_Pass(username,password).size();// trả về số lương user	 
		 if( tonguser > 0 &&  this.user_Sevrice.findALL_byUser_Pass(username,password).get(0).getQuyen() == 0) {		 
			session.setAttribute("username", username);
			return "admin_index";	
		 }else if(tonguser > 0 &&  this.user_Sevrice.findALL_byUser_Pass(username,password).get(0).getQuyen() == 1) {
			    Integer sobai1trang = 8;
				Integer tongbai = this.music_Service.findALL_bynewMusic().size(); //Tra ve tong  so luong 
				Integer tongsotrang = 0;
				//set gia tri tong so trang
				if (tongbai % sobai1trang != 0) 
					tongsotrang = tongbai / sobai1trang + 1;
				else 
					tongsotrang = tongbai / sobai1trang;
				//Vi tri limit muon lay
				Integer start = (page - 1)* sobai1trang;
				md.addAttribute("theloai",this.theloai_Service.findALL());		
				md.addAttribute("newMusic",this.music_Service.findALL_bynewMusic_limit(start, sobai1trang));
				md.addAttribute("trang",page);
				md.addAttribute("tongsotrang",tongsotrang);	
				
				
			return "index_user";
		}else{
			md.put("error", "Tài khoản không hợp lệ");
			return "login";
		 }	
	}
	
	//trang dang ki
	@RequestMapping(value = "/registration")
	public String registration(ModelMap md) {
		return "registration";
	}
	
	@RequestMapping(value = "/xulidangky", method = RequestMethod.POST)
	public String xulydangky(ModelMap md , @RequestParam("username") String username,
											@RequestParam("img") String img,
											@RequestParam("password") String password,
											@RequestParam("password1") String password1										
											) {
		if(password.equals(password1)) {
			this.user_Sevrice.add_user(username,img,password);
			md.put("error", "Đăng kí thành công");
			return "registration";
		} else {
			md.put("error", "Tài khoản không hợp lệ");
			return "registration";
		}
	}
	
	
	//dang xuat
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "login";
	}
	
	
	@RequestMapping(value = "/admin_index")
	public String admin_index(ModelMap md) {	
		return "admin_index";
	}
	
	//trang admincasi
	@RequestMapping(value = "/admin_casi", method = RequestMethod.GET)
	public String admin_casi(ModelMap md) {	
		md.addAttribute("casi",this.casi_Sevrice.findALL());
		return "admin_casi";
	}
	
	//xoacasi
	@RequestMapping(value = "/xoacasi", method = RequestMethod.GET)
	public RedirectView xoacasi(ModelMap md , @RequestParam("idcasi") int idcasi){
		this.casi_Sevrice.delete_IDcasi(idcasi);
		return new RedirectView("http://localhost:8080/demonhac/admin_casi");	
	}
	
	//trang admintheloai
	@RequestMapping(value = "/admin_theloai")
	public String admin_theloai(ModelMap md) {	
		md.addAttribute("theloai",this.theloai_Service.findALL());
		return "admin_theloai";
	}
	
	//xoatheloai
	@RequestMapping(value = "/xoatheloai", method = RequestMethod.GET)
	public RedirectView xoatheloai(ModelMap md , @RequestParam("idtheloai") int idtheloai){
		this.theloai_Service.delete_IDtheloai(idtheloai);
		return new RedirectView("http://localhost:8080/demonhac/admin_theloai");	
	}
	
	//trang adminbaihat
	@RequestMapping(value = "/admin_baihat")
	public String admin_baihat(ModelMap md) {
		md.addAttribute("baihat",this.music_Service.findALL_Music());
		return "admin_baihat";
	}
	//xoatheloai
		@RequestMapping(value = "/xoabaihat", method = RequestMethod.GET)
		public RedirectView xoabaihat(ModelMap md , @RequestParam("idbaihat") int idbaihat){
			this.music_Service.delete_IDbaihat(idbaihat);
			return new RedirectView("http://localhost:8080/demonhac/admin_baihat");	
		}
	
	//trang admintaikhoan
	@RequestMapping(value = "/admin_taikhoan")
	public String admin_taikhoan(ModelMap md) {	
		md.addAttribute("taikhoan",this.user_Sevrice.findALL());
		return "admin_taikhoan";
	}
	
	//xoatheloai
	@RequestMapping(value = "/xoataikhoan", method = RequestMethod.GET)
	public RedirectView xoataikhoan(ModelMap md , @RequestParam("idtaikhoan") int idtaikhoan){
		this.user_Sevrice.delete_IDtaikhoan(idtaikhoan);
		return new RedirectView("http://localhost:8080/demonhac/admin_taikhoan");	
	}

}
