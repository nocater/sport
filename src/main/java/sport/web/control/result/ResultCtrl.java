package sport.web.control.result;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import sport.bean.Item;
import sport.bean.Result_;
import sport.bean.Student;
import sport.service.item.ItemService;
import sport.service.result.Result_Service;
import sport.service.student.Studentservice;

@Controller
@RequestMapping(value="/result")
public class ResultCtrl {
	@Autowired
	private ItemService itemService;
	@Autowired
	private Result_Service resultService;
	@Autowired
	private Studentservice studentService;
//	@Autowired
//	private ClasService clasService;
	
	@RequestMapping(value="")
	public String list(ModelMap model, 
						@RequestParam Integer grade_id,
						@RequestParam Integer clas_id,
						@RequestParam(value = "pageNum",required=false,defaultValue="1") Integer pageNum,
						@RequestParam(value = "pageSize", required=false, defaultValue="10") Integer pageSize,
						@RequestParam(value = "message", required=false) String message
						){
		//获取班级
//		Clas clas = clasService.querybyid(clas_id);
		//获取学生
//		List<Student> students = studentService
		
		//获取所有项目
		List<Item> items = itemService.getItemsByGrade(grade_id);
		model.addAttribute("items",items);
		//获取所有成绩
		PageHelper.startPage(pageNum, pageSize);
		List<Student> students = studentService.getStudentsByClas(clas_id);
		PageInfo<Student> page = new PageInfo<Student>(students);
		model.addAttribute("page",page);
		
		model.addAttribute("grade_id",grade_id);
		model.addAttribute("clas_id",clas_id);
		return "/result/resultlist";
	}
}
