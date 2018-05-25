package sport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import sport.bean.Result_;

public interface Result_Mapper {
    @Delete({
        "delete from result",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);
    
    @Insert({
        "insert into result (id, item_id, ",
        "student_id, score)",
        "values (#{id,jdbcType=INTEGER}, #{item.id,jdbcType=INTEGER}, ",
        "#{student.id,jdbcType=INTEGER}, #{score,jdbcType=VARCHAR})"
    })
    int insert(Result_ record);

    @InsertProvider(type=Result_SqlProvider.class, method="insertSelective")
    int insertSelective(Result record);

    @Select({
        "select",
        "id, item_id, student_id, score",
        "from result",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="student_id", property="item", jdbcType=JdbcType.INTEGER,
        
             one=@One(select="sport.dao.ItemMapper.selectByPrimaryKey")   //查找所有的items
        
        		),
        @Result(column="student_id", property="student", jdbcType=JdbcType.INTEGER,
              
        		one = @One(select="sport.dao.StudentMapper.selectByPrimaryKey")
        		),
        @Result(column="score", property="score", jdbcType=JdbcType.VARCHAR)
    })
    
     Result_ selectByPrimaryKey(Integer id);
    
    /*@Select({
        "select * from result",
        "where item_id  in (select item_id from grade_item where "
        + "grade_id =(select grade_id from student where id = #{id,jdbcType=INTEGER}))"
    })*/
    
    
    @Select({
        "select * from result",
        "where student_id = #{id,jdbcType=INTEGER}"
    })
    @Results({
	   	@Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="item_id", property="item", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.ItemMapper.selectByPrimaryKey")
        		),
        @Result(column="student_id", property="student", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.StudentMapper.selectByPrimaryKey")
        		),
        @Result(column="score", property="score", jdbcType=JdbcType.VARCHAR)
    })
    List<Result_> selectByStudentId(Integer id);
    
    @Select({
		"select",
        "id,item_id,student_id,score",
        "from result where student_id in(",
        	"select",
        	"id",
        	"from student",
        	"where clas_id = #{id,jdbcType=INTEGER}",
        ")"

    })
    
    @Results({
	   	@Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="item_id", property="item", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.ItemMapper.selectByPrimaryKey")
        		),
        @Result(column="student_id", property="student", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.StudentMapper.selectByPrimaryKey")
        		),
        @Result(column="score", property="score", jdbcType=JdbcType.VARCHAR)
    })
    
    List<Result_> selectByClassId(Integer id);
    //根据班级ID查找
    
   
   /* @Select({
        "select * from result",
        "where student_id = #{id}"
    })
    
    @Results({
	   	@Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="item_id", property="item", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.ItemMapper.selectByPrimaryKey")
        		),
        @Result(column="student_id", property="student", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.StudentMapper.selectByPrimaryKey")
        		),
        @Result(column="score", property="score", jdbcType=JdbcType.VARCHAR)
    })
    
    List<Result_> selectByGradeIdAndClassId(Integer grade_id,Integer class_id);
      //根据年级ID  班级ID  级联查找
    */
    
    
    @UpdateProvider(type=Result_SqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Result record);

    @Update({
        "update result",
        "set item_id = #{item.id,jdbcType=INTEGER},",
          "student_id = #{student.id,jdbcType=INTEGER},",
          "score = #{score,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Result record);
}