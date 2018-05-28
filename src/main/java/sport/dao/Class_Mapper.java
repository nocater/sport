package sport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import sport.bean.Class_;

public interface Class_Mapper {
    @Delete({
        "delete from clas",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into clas (id, num, ",
        "name, grade_id)",
        "values (#{id,jdbcType=INTEGER}, #{num,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{grade.id,jdbcType=INTEGER})"
    })
    int insert(Class_ record);

    @InsertProvider(type=Class_SqlProvider.class, method="insertSelective")
    int insertSelective(Class_ record);
   /* @Select({
    	
    })*/
    
    @Select({
        "select",
        "id, num, name, grade_id",
        "from clas",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="grade_id", property="grade", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.GradeMapper.selectByPrimaryKey")
        		)
    })
    Class_ selectByPrimaryKey(Integer id);
    
    @Select({
        "select",
        "id, num, name, grade_id",
        "from clas",
        "where grade_id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="grade_id", property="grade", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.GradeMapper.selectByPrimaryKey")
        		)
    })
    List<Class_> selectClassByGradeId(Integer id);
    
   
    @UpdateProvider(type=Class_SqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Class_ record);
    @Update({
        "update clas",
        "set num = #{num,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "grade_id = #{grade.id,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Class_ record);
    
    @Select({
        "select",
        "id, num, name, grade_id",
        "from clas",
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="grade_id", property="grade", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.GradeMapper.selectByPrimaryKey")
        		)
    })
    
   List< Class_ > selectAll();
    
    
}