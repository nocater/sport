package sport.web.control.student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sport.bean.Fresult;
import sport.bean.Item;
import sport.bean.Student;
import sport.service.item.ItemService;
import sport.service.result.ResultService;
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
	
	@RequestMapping(value="/info")
	public String info(ModelMap model,
					@RequestParam(required=false,defaultValue="6") Integer id
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
		return "/student/studentinfo";
		//多个学期成绩显示未完成
	}
}
