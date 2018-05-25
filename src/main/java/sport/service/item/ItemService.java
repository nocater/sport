package sport.service.item;

import java.util.List;
import sport.bean.Item;

public interface ItemService {
	/***
	 * 根据年级获取项目
	 * @param id
	 * @return
	 */
	public List<Item> getItemsByGrade(Integer id);
}
