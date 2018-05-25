package sport.web.control.school;

import java.util.ArrayList;
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
	public String index(
			@RequestParam(value = "id", required=false) Integer id
						){
		//通过ID查询学校
		return "/school/schoolinfo";
	}
	
	@RequestMapping("")
	public String list(ModelMap model, 
						@RequestParam(value="pageNum",required=false,defaultValue="1") Integer pageNum,
						@RequestParam(value = "pageSize", required=false, defaultValue="3") Integer pageSize,
						@RequestParam(value = "message", required=false) String message
						){
		PageHelper.startPage(2, 3);
		List<String> list = new ArrayList<String>();
		list.add("秦皇岛一中");
		list.add("秦皇岛2中");
		list.add("秦皇岛3中");
		list.add("秦皇岛4中");
		list.add("秦皇岛5中");
		list.add("秦皇岛6中");
		list.add("秦皇岛7中");
		list.add("秦皇岛8中");
		PageInfo page = new PageInfo(list);
		model.addAttribute("page", page);
		return "/school/schoollist";
	}
}
