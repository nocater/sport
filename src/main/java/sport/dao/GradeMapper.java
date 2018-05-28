package sport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import sport.bean.Grade;
import sport.bean.Item;

public interface GradeMapper {
	
   
    @Delete({
        "delete from grade",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into grade (id, school_id, ",
        "num, name)",
        "values (#{id,jdbcType=INTEGER}, #{school.id,jdbcType=INTEGER}, ",
        "#{num,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Grade record);

    
     
    @InsertProvider(type=GradeSqlProvider.class, method="insertSelective")
    int insertSelective(Grade record);
    @Select({
        "select",
        "id, school_id, num, name",
        "from grade"
        
    })
    
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="school_id", property="school", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.SchoolMapper.selectByPrimaryKey")),
        @Result(column="id", property="items", jdbcType=JdbcType.INTEGER,
        
		 many = @Many(select="sport.dao.ItemMapper.selectByGrade")),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Grade> selectAll();
    
    
    @Select({
        "select",
        "id, school_id, num, name",
        "from grade"
        + " where school_id=#{id,jdbcType=INTEGER}"
        
    })
    
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="school_id", property="school", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.SchoolMapper.selectByPrimaryKey")),
        @Result(column="id", property="items", jdbcType=JdbcType.INTEGER,
        
		 many = @Many(select="sport.dao.ItemMapper.selectByGrade")),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    
    List<Grade> selectGradeBySchoolId(Integer id);
    
    
    
  
    @Select({
        "select",
        "id, school_id, num, name",
        "from grade",
        "where id = #{id,jdbcType=INTEGER}"
    })
    
    
    
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="school_id", property="school", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.SchoolMapper.selectByPrimaryKey")),
        
        @Result(column="id", property="items", jdbcType=JdbcType.INTEGER,
        
        		many = @Many(select="sport.dao.ItemMapper.selectByGrade")),
        
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Grade selectByPrimaryKey(Integer id);

    @UpdateProvider(type=GradeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Grade record);

    @Update({
        "update grade",
        "set school_id = #{school.id,jdbcType=INTEGER},",
          "num = #{num,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    
    int updateByPrimaryKey(Grade record);
}