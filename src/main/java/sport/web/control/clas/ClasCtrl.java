package sport.web.control.clas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import sport.bean.Class_;
import sport.service.class_.Class_Service;

@Controller
@RequestMapping(value="/clas")
public class ClasCtrl {
	@Autowired
	private Class_Service Class_Service;
	
	@RequestMapping("")
	
	public String queryAll(ModelMap model,
			@RequestParam(value="pageNum",required=false,defaultValue="1") Integer pageNum,
			@RequestParam(value = "pageSize", required=false, defaultValue="10") Integer pageSize,
			@RequestParam(value = "message", required=false) String message
			){
		PageHelper.startPage(pageNum, pageSize);
		List<Class_> allClass = Class_Service.getAllClass();
		PageInfo page = new PageInfo(allClass);
		model.addAttribute("page", page);
		
		return "clas/claslist";
		
	}
	
	
}
