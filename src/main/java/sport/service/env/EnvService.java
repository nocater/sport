package sport.service.env;

import java.util.List;

import sport.bean.Class_;
import sport.bean.Env;

public interface EnvService {
	
	List<Env> getAllByClassId(Integer id);
	
	int deleteByClas(Integer clas_id);
	/***
	 * 默认添加env 信息随机
	 * @param item_ids
	 * @param clas_id
	 * @return
	 */
	int insertByClas(List<Integer> item_ids, Class_ class_);
}
