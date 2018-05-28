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
	
	@Override
	public List<Criterion> getCriterionByItemId(Integer itemid, int type) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<>();
		map.put("itemid", itemid);
		map.put("type", type);
		return criterionMapper.selectByItemId(map);
	}

}
