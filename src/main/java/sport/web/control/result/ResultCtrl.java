package sport.web.control.result;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import sport.bean.Account;
import sport.bean.Class_;
import sport.bean.Fresult;
import sport.bean.Grade;
import sport.bean.Item;
import sport.bean.Result_;
import sport.bean.School;
import sport.bean.Student;
import sport.service.class_.Class_Service;
import sport.service.grade.GradeService;
import sport.service.item.ItemService;
import sport.service.result.ResultService;
import sport.service.school.SchoolService;
import sport.service.student.Studentservice;

@Controller
@RequestMapping(value="/result")
public class ResultCtrl {
	@Autowired
	private ItemService itemService;
	@Autowired
	private ResultService ResultService;
	@Autowired
	private Studentservice studentService;
	@Autowired
	private GradeService gradeservice;
	@Autowired
	private Class_Service class_service;
	
	@Autowired
    private SchoolService schoolservice;
//	@Autowired
//	private ClasService clasService;
	
	@RequestMapping(value="")
	public String list(ModelMap model, 
			            HttpSession session,
						@RequestParam(value = "grade_id",required=false,defaultValue="39") Integer grade_id,
						@RequestParam(value = "clas_id",required=false,defaultValue="65") Integer clas_id,
						@RequestParam(value = "term_id",required=false,defaultValue="1")   Integer term_id,
						@RequestParam(value = "pageNum",required=false,defaultValue="1") Integer pageNum,
						@RequestParam(value = "pageSize", required=false, defaultValue="10") Integer pageSize,
						@RequestParam(value = "message", required=false) String message
						){
		Account account = (Account) session.getAttribute("LOGIN_ACCOUNT");
		if(account==null)return"redirect:/";
				
		School school = schoolservice.getSchoolByRoleId(account.getRole().getId());
		
		//获取年级
		List<Grade> grades= gradeservice.getGradesBySchoolId(school.getId());
		
		model.addAttribute("grades",grades);
		
		//获取班级
		 List<Class_> class_s = class_service.getClass_ByGradeId(grade_id);
		 model.addAttribute("class_s",class_s);
				
		//获取所有项目
		List<Item> items = itemService.getItemsByGrade(grade_id);

		model.addAttribute("items",items);
		//获取所有成绩
		PageHelper.startPage(pageNum, pageSize);
		//List<Student> students = studentService.getStudentsByClas(clas_id);
		List<Student> students = ResultService.getFresultsByClasWithTerm(clas_id, term_id);
		
		PageInfo<Student> page = new PageInfo<Student>(students);
		model.addAttribute("page",page);
		
		model.addAttribute("grade_id",grade_id);
		model.addAttribute("clas_id",clas_id);
		return "/result/resultlist";
	}
}