package sport.service.school;

import java.util.List;

import sport.bean.School;

public interface SchoolService {
	
	//通过角色获取学校
	public School getSchoolByRoleId(Integer id);
	
    public List<School> getAllSchool();
    
    public School getSchoolById(Integer id);
    
    public int addSchool(School school);
    
}
