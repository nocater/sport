package sport.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import sport.bean.Addscore;

public interface AddscoreMapper {
    @Delete({
        "delete from addscore",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into addscore (id, item_id, ",
        "grade_num, add, standrad)",
        "values (#{id,jdbcType=INTEGER}, #{itemId,jdbcType=INTEGER}, ",
        "#{gradeNum,jdbcType=VARCHAR}, #{add,jdbcType=VARCHAR}, #{standrad,jdbcType=VARCHAR})"
    })
    int insert(Addscore record);

    @InsertProvider(type=AddscoreSqlProvider.class, method="insertSelective")
    int insertSelective(Addscore record);

    @Select({
        "select",
        "id, item_id, grade_num, add, standrad",
        "from addscore",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item_id", property="itemId", jdbcType=JdbcType.INTEGER),
        @Result(column="grade_num", property="gradeNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="add", property="add", jdbcType=JdbcType.VARCHAR),
        @Result(column="standrad", property="standrad", jdbcType=JdbcType.VARCHAR)
    })
    Addscore selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AddscoreSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Addscore record);

    @Update({
        "update addscore",
        "set item_id = #{itemId,jdbcType=INTEGER},",
          "grade_num = #{gradeNum,jdbcType=VARCHAR},",
          "add = #{add,jdbcType=VARCHAR},",
          "standrad = #{standrad,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Addscore record);
}