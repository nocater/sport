package sport.service.result;

import java.util.List;
import sport.bean.Result_;

public interface Result_Service {
	/***
	 * 根据班级获取班级成绩
	 * @param id
	 * @return
	 */
	public List<Result_> getResult_byClas_id(Integer id);
	
	
	public List<Result_> getResult_byStudent_id(Integer id);
}
