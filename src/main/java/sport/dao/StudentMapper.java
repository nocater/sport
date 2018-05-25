package sport.dao;

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
import sport.bean.Student;

public interface StudentMapper {
    @Delete({
        "delete from student",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into student (id, name, ",
        "sex, birth, studentnum, ",
        "ethnic, personnum, ",
        "adress, clas_id)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=VARCHAR}, #{birth,jdbcType=VARCHAR}, #{studentnum,jdbcType=VARCHAR}, ",
        "#{ethnic,jdbcType=VARCHAR}, #{personnum,jdbcType=VARCHAR}, ",
        "#{adress,jdbcType=VARCHAR}, #{class_.id,jdbcType=INTEGER})"
    })
    int insert(Student record);

    @InsertProvider(type=StudentSqlProvider.class, method="insertSelective")
    int insertSelective(Student record);

    @Select({
        "select",
        "id, name, sex, birth, studentnum, ethnic, personnum, adress, clas_id",
        "from student",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="birth", property="birth", jdbcType=JdbcType.VARCHAR),
        @Result(column="studentnum", property="studentnum", jdbcType=JdbcType.VARCHAR),
        @Result(column="ethnic", property="ethnic", jdbcType=JdbcType.VARCHAR),
        @Result(column="personnum", property="personnum", jdbcType=JdbcType.VARCHAR),
        @Result(column="adress", property="adress", jdbcType=JdbcType.VARCHAR),
        @Result(column="clas_id", property="class_", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.Class_Mapper.selectByPrimaryKey")
        		)
    })
    Student selectByPrimaryKey(Integer id);
    
    @Select({
        "select",
        "id, name, sex, birth, studentnum, ethnic, personnum, adress, clas_id",
        "from student",
    })
    
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="birth", property="birth", jdbcType=JdbcType.VARCHAR),
        @Result(column="studentnum", property="studentnum", jdbcType=JdbcType.VARCHAR),
        @Result(column="ethnic", property="ethnic", jdbcType=JdbcType.VARCHAR),
        @Result(column="personnum", property="personnum", jdbcType=JdbcType.VARCHAR),
        @Result(column="adress", property="adress", jdbcType=JdbcType.VARCHAR),
        @Result(column="clas_id", property="class_", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.Class_Mapper.selectByPrimaryKey")
        		)
    })
    
    Student selectAll();
    
    @UpdateProvider(type=StudentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Student record);

    @Update({
        "update student",
        "set name = #{name,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "birth = #{birth,jdbcType=VARCHAR},",
          "studentnum = #{studentnum,jdbcType=VARCHAR},",
          "ethnic = #{ethnic,jdbcType=VARCHAR},",
          "personnum = #{personnum,jdbcType=VARCHAR},",
          "adress = #{adress,jdbcType=VARCHAR},",
          "clas_id = #{class_.id,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Student record);
}