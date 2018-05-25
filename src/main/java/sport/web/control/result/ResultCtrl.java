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
import sport.service.item.ItemService;
import sport.service.result.Result_Service;

@Controller
@RequestMapping(value="/ch")
public class ResultCtrl {
//	@Autowired
//	private ItemService itemService;
//	@Autowired
	private Result_Service resultService;
	
	@RequestMapping(value="")
	public String list(ModelMap model, 
						@RequestParam Integer grade_id,
						@RequestParam Integer clas_id,
						@RequestParam(value="pageNum",required=false,defaultValue="1") Integer pageNum,
						@RequestParam(value = "pageSize", required=false, defaultValue="3") Integer pageSize,
						@RequestParam(value = "message", required=false) String message
						){
		grade_id = 36;
		model.addAttribute("grade_id",grade_id);
		model.addAttribute("clas_id",clas_id);
		//获取所有项目
//		List<Item> items = itemService.getItemsByGrade(grade_id);
		List<Item> items = new ArrayList<Item>();
		Item i1 = new Item(); i1.setName("跳高");
		Item i2 = new Item(); i2.setName("跑步");
		Item i3 = new Item(); i3.setName("铅球");
		Item i4 = new Item(); i4.setName("800米男");
		items.add(i1);items.add(i2);items.add(i3);items.add(i4);
		model.addAttribute("items",items);
		//获取所有成绩
//		PageHelper.startPage(pageNum, pageSize);
//		List<Result_> results = resultService.getResult_byClas_id(clas_id);
//		PageInfo<Result_> page = new PageInfo(results);
//		model.addAttribute("page",page);
		return "/result/resultlist";
	}
}
