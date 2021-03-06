package sport.web.control.clas;

import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import sport.bean.Class_;
import sport.service.class_.Class_Service;

@RestController
@RequestMapping(value="/clas")
public class ClasRestCtrl {
	@Autowired
	private Class_Service Class_Service;
	
	@RequestMapping(value="/query")
	public String query(@RequestParam Integer grade_id){
		
		List<Class_> class_s = Class_Service.getClass_ByGradeId(grade_id);
		Gson gson = new Gson();  
		String str = gson.toJson(class_s); 
		System.out.print(str);
		return str;
	}
	
}
