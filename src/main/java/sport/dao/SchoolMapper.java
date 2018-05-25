package sport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import sport.bean.School;

public interface SchoolMapper {
    @Delete({
        "delete from school",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into school (id, name, ",
        "address, zipcode, ",
        "president, tel, ",
        "email, schooltype)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{zipcode,jdbcType=INTEGER}, ",
        "#{president,jdbcType=VARCHAR}, #{tel,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{schooltype,jdbcType=VARCHAR})"
    })
    int insert(School record);

    @InsertProvider(type=SchoolSqlProvider.class, method="insertSelective")
    int insertSelective(School record);

    @Select({
        "select",
        "id, name, address, zipcode, president, tel, email, schooltype",
        "from school",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="zipcode", property="zipcode", jdbcType=JdbcType.INTEGER),
        @Result(column="president", property="president", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="schooltype", property="schooltype", jdbcType=JdbcType.VARCHAR)
    })
    School selectByPrimaryKey(Integer id);
   
   
    @UpdateProvider(type=SchoolSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(School record);

    @Update({
        "update school",
        "set name = #{name,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "zipcode = #{zipcode,jdbcType=INTEGER},",
          "president = #{president,jdbcType=VARCHAR},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "schooltype = #{schooltype,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(School record);
    
    @Select({
    	"select",
        "id, name, address, zipcode, president, tel, email, schooltype",
        "from school"
    	
    })
    @Results({
    	@Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="zipcode", property="zipcode", jdbcType=JdbcType.INTEGER),
        @Result(column="president", property="president", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="schooltype", property="schooltype", jdbcType=JdbcType.VARCHAR),
    })
       
    List<School>  selectall();  
    
}