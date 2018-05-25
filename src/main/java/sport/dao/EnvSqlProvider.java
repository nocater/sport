package sport.dao;

import org.apache.ibatis.jdbc.SQL;
import sport.bean.Env;

public class EnvSqlProvider {

    public String insertSelective(Env record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("env");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getClass_() != null) {
            sql.VALUES("clas_id", "#{class_.id,jdbcType=INTEGER}");
        }
        
        if (record.getItem() != null) {
            sql.VALUES("item_id", "#{item.id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            sql.VALUES("time", "#{time,jdbcType=VARCHAR}");
        }
        
        if (record.getPlace() != null) {
            sql.VALUES("place", "#{place,jdbcType=VARCHAR}");
        }
        
        if (record.getEquipment() != null) {
            sql.VALUES("equipment", "#{equipment,jdbcType=VARCHAR}");
        }
        
        if (record.getMode() != null) {
            sql.VALUES("mode", "#{mode,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Env record) {
        SQL sql = new SQL();
        sql.UPDATE("env");
        
        if (record.getClass_() != null) {
            sql.SET("clas_id = #{class_.id,jdbcType=INTEGER}");
        }
        
        if (record.getItem() != null) {
            sql.SET("item_id = #{item.id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            sql.SET("time = #{time,jdbcType=VARCHAR}");
        }
        
        if (record.getPlace() != null) {
            sql.SET("place = #{place,jdbcType=VARCHAR}");
        }
        
        if (record.getEquipment() != null) {
            sql.SET("equipment = #{equipment,jdbcType=VARCHAR}");
        }
        
        if (record.getMode() != null) {
            sql.SET("mode = #{mode,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}