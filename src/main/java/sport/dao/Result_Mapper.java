package sport.dao;

import java.util.List;
import java.util.Map;

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

import sport.bean.Result_;

public interface Result_Mapper {
    @Delete({
        "delete from result",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);
    
    @Insert({
        "insert into result (id, item_id, ",
        "student_id, score,term,type)",
        "values (#{id,jdbcType=INTEGER}, #{item.id,jdbcType=INTEGER}, ",
        "#{student.id,jdbcType=INTEGER}, #{score,jdbcType=VARCHAR})"
        + " #{term,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}"
    })
    int insert(Result_ record);

    @InsertProvider(type=Result_SqlProvider.class, method="insertSelective")
    int insertSelective(Result record);

    @Select({
        "select",
        "id, item_id, student_id, score,term,type",
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
        @Result(column="score", property="score", jdbcType=JdbcType.VARCHAR),
        @Result(column="term", property="term", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER)
           
    })
    
     Result_ selectByPrimaryKey(Integer id);
 
    //学生ID查询成绩
    @Select({
        "select * from result",
        "where student_id = #{id,jdbcType=INTEGER}",
        "   	and item_id in(",
        "		    select item_id from grade_item where grade_id = (select grade_id from clas where id = (",
        "																	select clas_id from student where id = #{id,jdbcType=INTEGER}) ",
        "                                                            )",
        "		)",
        "order by item_id",
    })
    @Results({
	   	@Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="item_id", property="item", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.ItemMapper.selectByPrimaryKey")
        		),
        @Result(column="student_id", property="student", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.StudentMapper.selectByPrimaryKey")
        		),
        @Result(column="score", property="score", jdbcType=JdbcType.VARCHAR),
	    @Result(column="term", property="term", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER)
    })
    List<Result_> selectByStudentId(Integer id);
    
    //学生ID查询某一学期成绩
    @Select({
        "select * from result",
        "where student_id = #{id,jdbcType=INTEGER} and term = #{term, jdbcType=INTEGER}",
        "   	and item_id in(",
        "		    select item_id from grade_item where grade_id = (select grade_id from clas where id = (",
        "																	select clas_id from student where id = #{id,jdbcType=INTEGER}) ",
        "                                                            )",
        "		)",
        "order by item_id",
    })
    @Results({
	   	@Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="item_id", property="item", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.ItemMapper.selectByPrimaryKey")
        		),
        @Result(column="student_id", property="student", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.StudentMapper.selectByPrimaryKey")
        		),
        @Result(column="score", property="score", jdbcType=JdbcType.VARCHAR),
	    @Result(column="term", property="term", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER)
    })
    List<Result_> selectByStudentIdWithTerm(Map<String, Integer> map);
    
    //查询学生有几个学期成绩
    @Select({
        "select distinct(term) from result",
        "where student_id = #{id,jdbcType=INTEGER}",
        "   	and item_id in(",
        "		    select item_id from grade_item where grade_id = (select grade_id from clas where id = (",
        "																	select clas_id from student where id = #{id,jdbcType=INTEGER}) ",
        "                                                            )",
        "		)",
    })
    List<Integer> selectStudentTerms(Integer id);
    
    //年级ID查询所有成绩
    @Select({
		"select",
        "id,item_id,student_id,score,term,type",
        "from result where student_id in(",
        	"select",
        	"id",
        	"from student",
        	"where clas_id in (select id from clas where grade_id = #{id ,jdbcType=INTEGER})",
        ")",
        "   and item_id in(",
        "		select item_id from grade_item where grade_id = #{id ,jdbcType=INTEGER}",
        "	)",
        "order by item_id",
    })
    
    @Results({
	   	@Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="item_id", property="item", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.ItemMapper.selectByPrimaryKey")
        		),
        @Result(column="student_id", property="student", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.StudentMapper.selectByPrimaryKey")
        		),
        @Result(column="score", property="score", jdbcType=JdbcType.VARCHAR),
        @Result(column="term", property="term", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER)
    })
    
    List<Result_> selectByGradeId(Integer id);
    
    
    //班级ID查询所有成绩 带权限
    @Select({
		"select",
        "id,item_id,student_id,score,term,type",
        "from result where student_id in(",
        	"select",
        	"id",
        	"from student",
        	"where clas_id = #{id,jdbcType=INTEGER}",
        ")",
        "     and item_id in(",
        "		  select item_id from grade_item where grade_id = (select grade_id from clas where id = #{id,jdbcType=INTEGER})",
        ")",
        "order by item_id",
    })
    
    @Results({
	   	@Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="item_id", property="item", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.ItemMapper.selectByPrimaryKey")
        		),
        @Result(column="student_id", property="student", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.StudentMapper.selectByPrimaryKey")
        		),
        @Result(column="score", property="score", jdbcType=JdbcType.VARCHAR),
        @Result(column="term", property="term", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER)
    })
    
    List<Result_> selectByClassId(Integer id);
    
    
    //班级ID和学期查询所有成绩
    @Select({
		"select",
        "id,item_id,student_id,score,term,type",
        "from result where student_id in(",
        	"select",
        	"id",
        	"from student",
        	"where clas_id = #{id,jdbcType=INTEGER}",
        "	)",
        "	and term = #{term,jdbcType=INTEGER}",
        "   and item_id in(",
        "		  select item_id from grade_item where grade_id = (select grade_id from clas where id = #{id,jdbcType=INTEGER})",
        ")",
        "order by item_id",
    })
    
    @Results({
	   	@Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="item_id", property="item", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.ItemMapper.selectByPrimaryKey")
        		),
        @Result(column="student_id", property="student", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.StudentMapper.selectByPrimaryKey")
        		),
        @Result(column="score", property="score", jdbcType=JdbcType.VARCHAR),
        @Result(column="term", property="term", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER)
    })
    
    List<Result_> selectByClassIdAndTerm(Map<String, Integer> map);
    
    @UpdateProvider(type=Result_SqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Result_ record);

    @Update({
        "update result",
        "set item_id = #{item.id,jdbcType=INTEGER},",
          "student_id = #{student.id,jdbcType=INTEGER},",
          "score = #{score,jdbcType=VARCHAR}",
          "term =#{term,jdbcType=INTEGER}",
          "type=#{type,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Result_ record);
    
    @Update({
        "update result",
        "set score = #{score,jdbcType=VARCHAR}",
        "where student_id = #{student.id,jdbcType=INTEGER}",
        " and term = #{term,jdbcType=INTEGER}",
        " and item_id = #{item.id,jdbcType=INTEGER}"
    })
    int updateResult(Result_ record);
}