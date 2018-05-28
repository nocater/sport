package sport.service.grade;

import java.util.List;

import sport.bean.Grade;

public interface GradeService {
	
	
	List<Grade> getGradesBySchoolId(Integer id);
	

}
