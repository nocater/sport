package sport.service.school.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sport.bean.School;
import sport.dao.SchoolMapper;
import sport.service.school.SchoolService;
@Service
public class SchoolServiceImpl implements SchoolService{
	@Autowired
	private SchoolMapper schoolmapper;
	@Override
	public School getSchoolByRoleId(Integer id) {
		// TODO Auto-generated method stub
		School school = schoolmapper.selectSchoolByRoleId(id);
		
		return school;
	}
	@Override
	public List<School> getAllSchool() {
		// TODO Auto-generated method stub
		List<School> selectall = schoolmapper.selectall();
		
		
		return selectall;
	}
	@Override
	public School getSchoolById(Integer id) {
		// TODO Auto-generated method stub
		School selectschool = schoolmapper.selectByPrimaryKey(id);
		
		return selectschool;
	}
	@Override
	
	public int addSchool(School school) {
		// TODO Auto-generated method stub
		int IsInsert = schoolmapper.insert(school);
		
		return IsInsert;
	}
}
