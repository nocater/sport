package sport.service.grade.impl;

import java.util.List;
import java.util.Map;

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
	@Override
	public Grade getGradeById(Integer id) {
		// TODO Auto-generated method stub
		Grade selectgrade = grademapper.selectByPrimaryKey(id);
		return selectgrade;
	}
	@Override
	public Integer deleteByGradeId(Integer id) {
		// TODO Auto-generated method stub
		int deleteByGradeId = grademapper.deleteByGradeId(id);
		
		return deleteByGradeId;
	}
	@Override
	public Integer insertToGrade_Item(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		int insertToGrade_Item = grademapper.insertToGrade_Item(map);
		
		return insertToGrade_Item;
	}

}
