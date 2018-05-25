package sport.dao;

import org.apache.ibatis.jdbc.SQL;
import sport.bean.School;

public class SchoolSqlProvider {

    public String insertSelective(School record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("school");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getZipcode() != null) {
            sql.VALUES("zipcode", "#{zipcode,jdbcType=INTEGER}");
        }
        
        if (record.getPresident() != null) {
            sql.VALUES("president", "#{president,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.VALUES("tel", "#{tel,jdbcType=INTEGER}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getSchooltype() != null) {
            sql.VALUES("schooltype", "#{schooltype,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(School record) {
        SQL sql = new SQL();
        sql.UPDATE("school");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getZipcode() != null) {
            sql.SET("zipcode = #{zipcode,jdbcType=INTEGER}");
        }
        
        if (record.getPresident() != null) {
            sql.SET("president = #{president,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.SET("tel = #{tel,jdbcType=INTEGER}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getSchooltype() != null) {
            sql.SET("schooltype = #{schooltype,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}