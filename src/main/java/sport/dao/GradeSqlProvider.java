package sport.dao;

import org.apache.ibatis.jdbc.SQL;
import sport.bean.Grade;

public class GradeSqlProvider {

    public String insertSelective(Grade record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("grade");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getSchool() != null) {
            sql.VALUES("school_id", "#{school.id,jdbcType=INTEGER}");
        }
        
        if (record.getNum() != null) {
            sql.VALUES("num", "#{num,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Grade record) {
        SQL sql = new SQL();
        sql.UPDATE("grade");
        
        if (record.getSchool() != null) {
            sql.SET("school_id = #{school.id,jdbcType=INTEGER}");
        }
        
        if (record.getNum() != null) {
            sql.SET("num = #{num,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}