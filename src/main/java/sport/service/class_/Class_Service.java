package sport.service.class_;

import java.util.List;

import sport.bean.Class_;

public interface Class_Service {
	
	
	List<Class_> getClass_ByGradeId(Integer id);
	
	List<Class_> getAllClass();
	
	
	Class_ getClassById(Integer id);
	

}
