package sport.service.grade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sport.bean.Grade;
import sport.dao.GradeMapper;
import sport.service.grade.GradeService;
@Service
public class GradeImpl implements GradeService{
    @Autowired
    private GradeMapper grademapper;
	@Override
	public List<Grade> getGradesBySchoolId(Integer id) {
		// TODO Auto-generated method stub
		
		List<Grade> selectGrades = grademapper.selectGradeBySchoolId(id);
		
		return selectGrades;
	}

}
