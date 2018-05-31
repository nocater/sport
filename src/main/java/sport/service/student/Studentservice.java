package sport.service.student;

import java.util.List;

import sport.bean.Student;

public interface Studentservice {
	List<Student> getStudentsByClas(Integer clas_id);
	
	Student getStudentByStuId(Integer student_id);
	
	Integer updateStudent(Student student);
	
}
