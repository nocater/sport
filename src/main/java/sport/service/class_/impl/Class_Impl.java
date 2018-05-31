package sport.service.class_.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sport.bean.Class_;
import sport.dao.Class_Mapper;
import sport.service.class_.Class_Service;

@Service
public class Class_Impl implements Class_Service {
   @Autowired
   private Class_Mapper class_mapper;
	@Override
	public List<Class_> getClass_ByGradeId(Integer id) {
		// TODO Auto-generated method stub
		
		List<Class_> selectedclass_ = class_mapper.selectClassByGradeId(id);
		
		return selectedclass_;
		
	}
	@Override
	public List<Class_> getAllClass() {
		// TODO Auto-generated method stub
		List<Class_> selectAll = class_mapper.selectAll();
		return selectAll;
	}
	
	@Override
	public Class_ getClassById(Integer id) {
		// TODO Auto-generated method stub
		Class_ selectByPrimaryKey = class_mapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

}
