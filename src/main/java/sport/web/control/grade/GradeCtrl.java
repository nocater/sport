package sport.web.control.grade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import sport.bean.Account;
import sport.bean.Grade;
import sport.bean.Item;
import sport.bean.School;
import sport.service.grade.GradeService;
import sport.service.item.ItemService;
import sport.service.school.SchoolService;


@Controller
@RequestMapping(value="/grade")
public class GradeCtrl {
	/***
	 * info
	 * @return
	 */
	@Autowired
	private SchoolService schoolservice;
	@Autowired
	private GradeService gradeservice;
	@Autowired
	private ItemService itemservice;
	
	@RequestMapping("/info")
	public String index(
			ModelMap model,
			HttpSession session,
			@RequestParam(value = "id", required=false) Integer id
						){
		//通过ID查询学校
      Account account = (Account) session.getAttribute("LOGIN_ACCOUNT");
		
	  School school = schoolservice.getSchoolByRoleId(account.getRole().getId());
	  model.addAttribute("school",school);
	  Grade grade = gradeservice.getGradeById(id);
	  model.addAttribute("grade",grade);
	  List<Item> items = itemservice.getAllItems();
	  model.addAttribute("items",items);
	  
	  return "/grade/gradeinfo";
	}
	
	@RequestMapping("")
	public String list(ModelMap model,
			         HttpSession session,
						@RequestParam(value="pageNum",required=false,defaultValue="1") Integer pageNum,
						@RequestParam(value = "pageSize", required=false, defaultValue="3") Integer pageSize,
						@RequestParam(value = "message", required=false) String message
						){
		PageHelper.startPage(pageNum, pageSize);
		Account account = (Account) session.getAttribute("LOGIN_ACCOUNT");
		
		School school = schoolservice.getSchoolByRoleId(account.getRole().getId());
		
		//获取年级
		List<Grade> grades= gradeservice.getGradesBySchoolId(school.getId());
		
		model.addAttribute("grades",grades);
	    
		PageInfo page = new PageInfo(grades);
		model.addAttribute("page", page);
		return "/grade/gradelist";
	}
	
	
	@RequestMapping("/modify")
	public String modify(
			ModelMap model,
			HttpSession session,
			@RequestParam(value = "grade_id", required=false) Integer grade_id,
			@RequestParam(value="selected_items",required=false) String selected_items
						){
		//通过ID查询学校
		
	  System.out.print(selected_items);
	  
	  List<Integer> itemids =new ArrayList<Integer>();
	  
	  String[] item_ids = selected_items.split(",");
	  
	  
	  
	  for(int i=0;i<item_ids.length;i++){
		  
		  itemids.add(Integer.parseInt(item_ids[i]));
		  
	  }
	  Integer modifyresult=0; 
	  Integer dele = gradeservice.deleteByGradeId(grade_id);
	  if(dele!=0){
		  for(Integer it:itemids){
			    Map<String, Integer> map = new HashMap<>();
				map.put("grade_id", grade_id);
				map.put("item_id", it);
				modifyresult = gradeservice.insertToGrade_Item(map);	
		  }
		  
	  }
	  if(modifyresult!=0){
		  model.addAttribute("message","修改成功！");
	  }else{
		  model.addAttribute("message","修改失败！");
	  }
	  Account account = (Account) session.getAttribute("LOGIN_ACCOUNT");
	  School school = schoolservice.getSchoolByRoleId(account.getRole().getId());
	  model.addAttribute("school",school);
	  Grade grade = gradeservice.getGradeById(grade_id);
	  model.addAttribute("grade",grade);
	  List<Item> items = itemservice.getAllItems();
	  model.addAttribute("items",items);
      
	  return "/grade/gradeinfo";
	}
	
	
	
}
