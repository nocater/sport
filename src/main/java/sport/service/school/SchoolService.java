package sport.service.school;

import sport.bean.School;

public interface SchoolService {
	
	//通过角色获取学校
	public School getSchoolByRoleId(Integer id);
	

}
