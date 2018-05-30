package sport.service.grade;

import java.util.List;
import java.util.Map;

import sport.bean.Grade;

public interface GradeService {
	
	
	List<Grade> getGradesBySchoolId(Integer id);
	
    Grade getGradeById(Integer id);
    
    Integer deleteByGradeId(Integer id);
    
    Integer insertToGrade_Item(Map<String, Integer> map);
    
}
