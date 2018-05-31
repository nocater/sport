package sport.web.control.clas;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import sport.bean.Class_;
import sport.bean.Env;
import sport.bean.Item;
import sport.service.class_.Class_Service;
import sport.service.env.EnvService;

@Controller
@RequestMapping(value="/clas")
public class ClasCtrl {
	@Autowired
	private Class_Service Class_Service;
	@Autowired
	private EnvService envservice;
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
	
    @RequestMapping("/info")
	public String clas_info(ModelMap model,
			@RequestParam(required=false,defaultValue="65") Integer id
			){
    	Class_ clas = Class_Service.getClassById(id);
    	
    	model.addAttribute("clas",clas);
    	
    	List<Env> allByClassId = envservice.getAllByClassId(id);
    	
    	model.addAttribute("envs",allByClassId);
    	
    	
    	
    	Map<Item, Env> map = new LinkedHashMap<>();
    	for(int i = 0; i<clas.getGrade().getItems().size(); i++){
    		System.out.println(clas.getGrade().getItems().get(i).getId());
    		map.put(clas.getGrade().getItems().get(i), allByClassId.get(i));
    	}
    	model.addAttribute("map",map);
    	
		return "clas/clasinfo";
		
	}
	
	
	
	
	
}
