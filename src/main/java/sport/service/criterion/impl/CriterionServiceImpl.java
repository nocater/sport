package sport.service.criterion.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sport.bean.Criterion;
import sport.dao.CriterionMapper;
import sport.service.criterion.CriterionService;

@Service
public class CriterionServiceImpl implements CriterionService {
	@Autowired
	private CriterionMapper criterionMapper;
	
	/***
	 * 查询项目的的标准
	 * 根据项目ID 和 男女类型查询
	 * @param itemid
	 * @param gradeNum
	 * @param type
	 * @return
	 */
	@Override
	public List<Criterion> getCriterion(Integer itemid, Integer gradeNum, int type) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<>();
		map.put("itemid", itemid);
		map.put("gradeNum", gradeNum);
		map.put("type", type);
//		System.out.println("CRITERSERVICE:"+itemid+"-"+gradeNum+"-"+type);
		return criterionMapper.selectNormal(map);
	}

}
