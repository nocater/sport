package sport.dao;

import org.apache.ibatis.jdbc.SQL;
import sport.bean.Criterion;

public class CriterionSqlProvider {

    public String insertSelective(Criterion record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("criterion");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getItemId() != null) {
            sql.VALUES("item_id", "#{itemId,jdbcType=INTEGER}");
        }
        
        if (record.getGradeNum() != null) {
            sql.VALUES("grade_num", "#{gradeNum,jdbcType=VARCHAR}");
        }
        
        if (record.getStandrad() != null) {
            sql.VALUES("standrad", "#{standrad,jdbcType=VARCHAR}");
        }
        
        if (record.getLevl() != null) {
            sql.VALUES("levl", "#{levl,jdbcType=VARCHAR}");
        }
        
        if (record.getScore() != null) {
            sql.VALUES("score", "#{score,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Criterion record) {
        SQL sql = new SQL();
        sql.UPDATE("criterion");
        
        if (record.getItemId() != null) {
            sql.SET("item_id = #{itemId,jdbcType=INTEGER}");
        }
        
        if (record.getGradeNum() != null) {
            sql.SET("grade_num = #{gradeNum,jdbcType=VARCHAR}");
        }
        
        if (record.getStandrad() != null) {
            sql.SET("standrad = #{standrad,jdbcType=VARCHAR}");
        }
        
        if (record.getLevl() != null) {
            sql.SET("levl = #{levl,jdbcType=VARCHAR}");
        }
        
        if (record.getScore() != null) {
            sql.SET("score = #{score,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}