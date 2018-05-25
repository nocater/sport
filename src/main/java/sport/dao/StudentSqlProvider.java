package sport.dao;

import org.apache.ibatis.jdbc.SQL;
import sport.bean.Student;

public class StudentSqlProvider {

    public String insertSelective(Student record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("student");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.VALUES("sex", "#{sex,jdbcType=VARCHAR}");
        }
        
        if (record.getBirth() != null) {
            sql.VALUES("birth", "#{birth,jdbcType=VARCHAR}");
        }
        
        if (record.getStudentnum() != null) {
            sql.VALUES("studentnum", "#{studentnum,jdbcType=VARCHAR}");
        }
        
        if (record.getEthnic() != null) {
            sql.VALUES("ethnic", "#{ethnic,jdbcType=VARCHAR}");
        }
        
        if (record.getPersonnum() != null) {
            sql.VALUES("personnum", "#{personnum,jdbcType=VARCHAR}");
        }
        
        if (record.getAdress() != null) {
            sql.VALUES("adress", "#{adress,jdbcType=VARCHAR}");
        }
        
        if (record.getClass_() != null) {
            sql.VALUES("clas_id", "#{class_.id,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Student record) {
        SQL sql = new SQL();
        sql.UPDATE("student");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.SET("sex = #{sex,jdbcType=VARCHAR}");
        }
        
        if (record.getBirth() != null) {
            sql.SET("birth = #{birth,jdbcType=VARCHAR}");
        }
        
        if (record.getStudentnum() != null) {
            sql.SET("studentnum = #{studentnum,jdbcType=VARCHAR}");
        }
        
        if (record.getEthnic() != null) {
            sql.SET("ethnic = #{ethnic,jdbcType=VARCHAR}");
        }
        
        if (record.getPersonnum() != null) {
            sql.SET("personnum = #{personnum,jdbcType=VARCHAR}");
        }
        
        if (record.getAdress() != null) {
            sql.SET("adress = #{adress,jdbcType=VARCHAR}");
        }
        
        if (record.getClass_() != null) {
            sql.SET("clas_id = #{clasId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{class_.id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}