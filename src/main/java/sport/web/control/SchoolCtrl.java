package sport.web.control;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping(value="/school")
public class SchoolCtrl {
	/***
	 * info
	 * @return
	 */
	@RequestMapping("/info")
	public String index(){
		return "/school/schoolinfo";
	}
	
	@RequestMapping("/list")
	public String list(ModelMap model, 
						@RequestParam(value="pageNum",required=false,defaultValue="1") Integer pageNum,
						@RequestParam(value = "pageSize", required=false, defaultValue="3") Integer pageSize,
						@RequestParam(value = "message", required=false) String message
						){
		PageHelper.startPage(2, 3);
		List<String> list = Arrays.asList(new String[]{"燕山大学", "秦皇岛一中",
				"秦皇岛一中",
				"秦皇岛2中",
				"秦皇岛3中",
				"秦皇岛4中",
				"秦皇岛5中",
				"秦皇岛6中",
				"秦皇岛7中",
				"秦皇岛8中",
				"秦皇岛9中"});
		PageInfo<String> page = new PageInfo<String>(list);
		model.addAttribute("page", page);
		return "/school/schoollist";
	}
}
