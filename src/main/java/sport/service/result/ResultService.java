package sport.service.result;

import java.util.List;
import java.util.Map;

import sport.bean.Fresult;
import sport.bean.Result_;
import sport.bean.Student;

public interface ResultService {
	/***
	 * 根据班级获取班级成绩
	 * @param id
	 * @return
	 */
	List<Result_> getResult_byClas_id(Integer id);
	
	/***
	 * 查询某一个学生的全部成绩
	 * @param id
	 * @return
	 */
	List<Result_> getResult_byStudent_id(Integer id);
	/***
	 * 查询班级某学期的成绩
	 * @param clas_id
	 * @param term
	 * @return
	 */
	List<Student> getFresultsByClasWithTerm(Integer clas_id, Integer term);
	/***
	 * 查询某一个学生的某一学期成绩
	 * @param clas_id
	 * @param term
	 * @return
	 */
	List<Fresult> getFresultWithTerm(Integer student_id, Integer term);
	/***
	 * 查询一个学生有几个学期成绩
	 * @param student_id
	 * @return
	 */
	List<Integer> getTerms(Integer student_id);
	/***
	 * 根据班级和学期获取成绩
	 * @param student_id
	 * @return
	 */
	List<Fresult> getResultByClassIdAndTerm(Map<String, Integer> map);
	
}
