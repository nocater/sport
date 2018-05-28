package sport.dao;

import org.apache.ibatis.jdbc.SQL;
import sport.bean.Addscore;

public class AddscoreSqlProvider {

    public String insertSelective(Addscore record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("addscore");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getItemId() != null) {
            sql.VALUES("item_id", "#{itemId,jdbcType=INTEGER}");
        }
        
        if (record.getGradeNum() != null) {
            sql.VALUES("grade_num", "#{gradeNum,jdbcType=VARCHAR}");
        }
        
        if (record.getAdd() != null) {
            sql.VALUES("add", "#{add,jdbcType=VARCHAR}");
        }
        
        if (record.getStandrad() != null) {
            sql.VALUES("standrad", "#{standrad,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Addscore record) {
        SQL sql = new SQL();
        sql.UPDATE("addscore");
        
        if (record.getItemId() != null) {
            sql.SET("item_id = #{itemId,jdbcType=INTEGER}");
        }
        
        if (record.getGradeNum() != null) {
            sql.SET("grade_num = #{gradeNum,jdbcType=VARCHAR}");
        }
        
        if (record.getAdd() != null) {
            sql.SET("add = #{add,jdbcType=VARCHAR}");
        }
        
        if (record.getStandrad() != null) {
            sql.SET("standrad = #{standrad,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}