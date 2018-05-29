package sport.service.school.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sport.bean.School;
import sport.dao.SchoolMapper;
import sport.service.school.SchoolService;
@Service
public class SchoolServiceImpl implements SchoolService{
	@Autowired
	private SchoolMapper achoolmapper;
	@Override
	public School getSchoolByRoleId(Integer id) {
		// TODO Auto-generated method stub
		School school = achoolmapper.selectSchoolByRoleId(id);
		
		return school;
	}
}
