package sport.web.control.student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.validator.internal.engine.messageinterpolation.TermResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
@RequestMapping(value="/student")
public class StudentCtrl {
	@Autowired
	private Studentservice studentService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private ResultService resultService;
	@Autowired
	private GradeService gradeservice;
	@Autowired
	private SchoolService schoolservice;
	@Autowired
	private Class_Service clasService;
	
	@RequestMapping(value="")
	public String list(ModelMap model,
			HttpSession session,
			@RequestParam(value="pageNum",required=false,defaultValue="1") Integer pageNum,
			@RequestParam(value = "pageSize", required=false, defaultValue="10") Integer pageSize,
			@RequestParam(value = "message", required=false) String message
			){
		Account account = (Account) session.getAttribute("LOGIN_ACCOUNT");
		if(account==null)return"redirect:/";
		School school = schoolservice.getSchoolByRoleId(account.getRole().getId());
		
		PageHelper.startPage(pageNum, pageSize);
		List<Student> students = studentService.getStudentsByClas(65);
		PageInfo<Student> page = new PageInfo<>(students);
		model.addAttribute("page", page);
		
		//获取年级
		List<Grade> grades= gradeservice.getGradesBySchoolId(school.getId());
		model.addAttribute("grades",grades);
		
		//获取班级
		List<Class_> class_s = clasService.getClass_ByGradeId(grades.get(0).getId());
		model.addAttribute("class_s",class_s);
		
		return "student/studentlist";
	}
	
	@RequestMapping(value="/info")
	public String info(ModelMap model,
					@RequestParam(required=false,defaultValue="6") Integer id,
					@RequestParam(value = "message", required=false) String message
			){
		//学生信息
		Student student = studentService.getStudentByStuId(id);
		model.addAttribute("student", student);
		
		// 体侧项目
		List<Item> items = itemService.getItemsByGrade(student.getClass_().getGrade().getId());
		model.addAttribute("items",items);
		
		//获取Terms
		List<Integer> terms = resultService.getTerms(id);
		Map<Integer, List<Fresult>> terms_fresults = new HashMap<>();
		for(Integer term : terms){
			List<Fresult> fresult = resultService.getFresultWithTerm(id, term);
			terms_fresults.put(term, fresult);
		}
		
		model.addAttribute("terms_fresults",terms_fresults);
		model.addAttribute("message", message);
		return "student/studentinfo";
	}
	
	@PostMapping(value="/update")
	public String updateFresult(
								@RequestParam Integer student_id,
								@RequestParam String modifyData,
								RedirectAttributes attr
								){
		if(modifyData == null || modifyData.equals(""))return "redirect:/student";
		System.out.println(modifyData);
		String[] rs = modifyData.split(",");
		for(String data : rs){
			Result_ record = new Result_();
			//学生
			Student s = new Student();
			s.setId(student_id);
			record.setStudent(s);
			//体测项目
			Item i = new Item();
			i.setId(Integer.parseInt(data.split("_")[0]));
			record.setItem(i);
			//学期
			record.setTerm(Integer.parseInt(data.split("_")[1]));
			//成绩
			record.setScore(data.split("_")[2]);
			resultService.updateResult(record);
		}
		attr.addAttribute("id", student_id);
		attr.addAttribute("message", "修改成功！");
		return "redirect:/student/info";
	}
}
