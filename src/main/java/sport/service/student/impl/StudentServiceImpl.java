package sport.service.student.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sport.bean.Fresult;
import sport.bean.Result_;
import sport.bean.Student;
import sport.dao.StudentMapper;
import sport.service.result.Result_Service;
import sport.service.student.Studentservice;
import sport.util.criterion.CriterionUtil;

@Service
public class StudentServiceImpl implements Studentservice {
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private Result_Service resultService;
	@Autowired
	private CriterionUtil CriterionUtil;
	
	@Override
	public List<Student> getStudentsByClas(Integer clas_id) {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<Student>();
		List<Student> origin_students = studentMapper.selectBylassIdClassId(clas_id);
		Iterator<Student> iter = origin_students.iterator();
		while(iter.hasNext()){
			Student s = iter.next();
			s = getStudentByStuId(s.getId());
			students.add(s);
		}
		return students;
	}

	@Override
	public Student getStudentByStuId(Integer student_id) {
		// TODO Auto-generated method stub
		Student student = studentMapper.selectByPrimaryKey(student_id);
		//封装学生成绩信息
		List<Result_> onestuResults = resultService.getResult_byStudent_id(student_id);
		List<Fresult> fresults = CriterionUtil.dealStudentScore(student, onestuResults);
		student.setFresults(fresults);
//		Map<Integer, String> rs = new HashMap<Integer,String>();
//		for(Result_ r : onestuResults){
//			rs.put(r.getItem().getId(), r.getScore());
//		}
//		student.setResults(rs);
		return student;
	}
	
	
}
