package sport.dao;

import org.apache.ibatis.jdbc.SQL;
import sport.bean.Result_;

public class Result_SqlProvider {

    public String insertSelective(Result_ record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("result");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getItem() != null) {
            sql.VALUES("item_id", "#{item.id,jdbcType=INTEGER}");
        }
        
        if (record.getStudent() != null) {
            sql.VALUES("student_id", "#{student.id,jdbcType=INTEGER}");
        }
        
        if (record.getScore() != null) {
            sql.VALUES("score", "#{score,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Result_ record) {
        SQL sql = new SQL();
        sql.UPDATE("result");
        
        if (record.getItem() != null) {
            sql.SET("item_id = #{item.id,jdbcType=INTEGER}");
        }
        
        if (record.getStudent() != null) {
            sql.SET("student_id = #{student.id,jdbcType=INTEGER}");
        }
        
        if (record.getScore() != null) {
            sql.SET("score = #{score,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}