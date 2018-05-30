package sport.web.control.school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import sport.bean.School;
import sport.service.school.SchoolService;


@Controller
@RequestMapping(value="/school")
public class SchoolCtrl {
	/***
	 * info
	 * @return
	 */
	@Autowired
	private SchoolService schoolservice;
	
	//删除,修改
	@RequestMapping("/edit")
	public String edit(ModelMap model,
			@RequestParam(value = "id", required=false) Integer id
						){
		/*schoolservice.*/
		School selectschool = schoolservice.getSchoolById(id);
		
		model.addAttribute("selectschool",selectschool);
		//通过ID查询学校
		return "/school/schoolinfoedit";
		
		
	}
	//增加学校页面
	@RequestMapping("/addinfo")
	public String index(  ModelMap model
						){
		/*schoolservice.*/
		
		return "/school/schoolinfo";
		
		
	}
	//增加学校页面
	@RequestMapping("/add")
	public String addSchool(  ModelMap model,
			@RequestParam(value = "name", required=false) String name,
			@RequestParam(value = "address", required=false) String address,
			@RequestParam(value = "zipcode", required=false) Integer   zipcode,
			@RequestParam(value = "president", required=false) String president,
			@RequestParam(value = "tel", required=false) String tel,
			@RequestParam(value = "email", required=false) String email,
			@RequestParam(value = "schooltype", required=false) String schooltype			     
						){
		School school=new School();
		school.setName(name);
		school.setAddress(address);	
		school.setZipcode(zipcode);
        school.setPresident(president);	
        school.setTel(tel);
        school.setEmail(email);	
        school.setSchooltype(schooltype);
        int IsInsert = schoolservice.addSchool(school);
        
        model.addAttribute("isinsert",IsInsert);
        
		return "/school/schoolinfo";
		
	}
	
	
	
	
	@RequestMapping("")
	public String list(ModelMap model, 
						@RequestParam(value="pageNum",required=false,defaultValue="1") Integer pageNum,
						@RequestParam(value = "pageSize", required=false, defaultValue="10") Integer pageSize,
						@RequestParam(value = "message", required=false) String message
						){
		PageHelper.startPage(pageNum, pageSize);
		//List<String> list = new ArrayList<String>();
		
		List<School>  schools=schoolservice.getAllSchool();
		/*System.out.println(schools);*/
		
		PageInfo page = new PageInfo(schools);
		
		model.addAttribute("page", page);
		return "/school/schoollist";
	}
	
	
	
	
}
