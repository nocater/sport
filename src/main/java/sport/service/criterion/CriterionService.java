package sport.service.criterion;

import java.util.List;

import sport.bean.Criterion;;

public interface CriterionService {
	
	/***
	 * 查询项目的的标准
	 * 根据项目ID 和 男女类型查询
	 * @param itemid
	 * @return
	 */
	List<Criterion> getCriterionByItemId(Integer itemid, int type);
}
