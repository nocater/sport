package sport.dao;

import org.apache.ibatis.jdbc.SQL;
import sport.bean.Item;

public class ItemSqlProvider {

    public String insertSelective(Item record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("item");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Item record) {
        SQL sql = new SQL();
        sql.UPDATE("item");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}