package sport.web.control.student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.validator.internal.engine.messageinterpolation.TermResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sport.bean.Fresult;
import sport.bean.Item;
import sport.bean.Result_;
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
		return "/student/studentinfo";
	}
	
	@PostMapping(value="/update")
	public String updateFresult(
								@RequestParam Integer student_id,
								@RequestParam String modifyData,
								RedirectAttributes attr
								){
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
