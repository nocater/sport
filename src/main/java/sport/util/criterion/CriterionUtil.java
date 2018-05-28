package sport.util.criterion;

import java.util.List;
import java.util.Map;

import sport.bean.Fresult;
import sport.bean.Result_;
import sport.bean.Student;

public interface CriterionUtil {
	/***
	 * 处理学生所有成绩
	 * @param student
	 * @return
	 */
	List<Fresult> dealStudentScore(Student student, List<Result_> results);
}
