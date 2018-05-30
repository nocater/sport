package sport.service.result.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sport.bean.Fresult;
import sport.bean.Result_;
import sport.bean.Student;
import sport.dao.Result_Mapper;
import sport.dao.StudentMapper;
import sport.service.result.ResultService;
import sport.util.criterion.CriterionUtil;
@Service
public class ResultServiceImpl implements ResultService{
    @Autowired
    private Result_Mapper result_mapper;
    @Autowired
	private StudentMapper studentMapper;
	@Autowired
	private CriterionUtil CriterionUtil;

	@Override
	public List<Result_> getResult_byClas_id(Integer id) {
		// TODO Auto-generated method stub
		
		
		List<Result_> results_ = result_mapper.selectByClassId(id);
		
		
		return results_;
	}
	@Override
	public List<Result_> getResult_byStudent_id(Integer id) {
		// TODO Auto-generated method stub
		List<Result_> results_ = result_mapper.selectByStudentId(id);
		
		return results_;
	}
	@Override
	public List<Student> getFresultsByClasWithTerm(Integer clas_id, Integer term) {
		// TODO Auto-generated method stub
		List<Student> origin_students = studentMapper.selectByClassId(clas_id);
		List<Student> students = new ArrayList<Student>();
		for(Student s:origin_students){
			s.setFresults(this.getFresultWithTerm(s.getId(), term));
			students.add(s);
		}
		return students;
	}
	@Override
	public List<Fresult> getFresultWithTerm(Integer student_id, Integer term) {
		// TODO Auto-generated method stub
		Student student = studentMapper.selectByPrimaryKey(student_id);
		//封装学生成绩信息
		Map<String, Integer> map = new HashMap<>();
		map.put("id", student_id);
		map.put("term", term);
		List<Result_> onestuResults = result_mapper.selectByStudentIdWithTerm(map);
		List<Fresult> origin_fresults = CriterionUtil.dealStudentScore(student, onestuResults);
		List<Fresult> fresults = new ArrayList<>();
		//添加成绩学期信息
		for(Fresult f : origin_fresults){
			f.setTerm(term);
			fresults.add(f);
		}
		return fresults;
	}
	@Override
	public List<Integer> getTerms(Integer student_id) {
		// TODO Auto-generated method stub
		return result_mapper.selectStudentTerms(student_id);
	}
	@Override
	public List<Result_> getResultByClassIdAndTerm(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		List<Result_> selectreaults = result_mapper.selectByClassIdAndTerm(map);
		return selectreaults;
	}
	@Override
	public int updateResult(Result_ result) {
		// TODO Auto-generated method stub
		return result_mapper.updateResult(result);
	}

}
