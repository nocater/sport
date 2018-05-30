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

import sport.bean.Criterion;

public interface CriterionMapper {
    @Delete({
        "delete from criterion",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into criterion (id, item_id, ",
        "grade_num, standrad, ",
        "levl, score)",
        "values (#{id,jdbcType=INTEGER}, #{itemId,jdbcType=INTEGER}, ",
        "#{gradeNum,jdbcType=VARCHAR}, #{standrad,jdbcType=VARCHAR}, ",
        "#{levl,jdbcType=VARCHAR}, #{score,jdbcType=VARCHAR})"
    })
    int insert(Criterion record);

    @InsertProvider(type=CriterionSqlProvider.class, method="insertSelective")
    int insertSelective(Criterion record);

    @Select({
        "select",
        "id, item_id, grade_num, standrad, levl, score",
        "from criterion",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item_id", property="item", jdbcType=JdbcType.INTEGER,
			one = @One(select="sport.dao.ItemMapper.selectByPrimaryKey")
		),
        @Result(column="grade_num", property="gradeNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="standrad", property="standrad", jdbcType=JdbcType.VARCHAR),
        @Result(column="levl", property="levl", jdbcType=JdbcType.VARCHAR),
        @Result(column="score", property="score", jdbcType=JdbcType.VARCHAR)
    })
    Criterion selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CriterionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Criterion record);

    @Update({
        "update criterion",
        "set item_id = #{item.id,jdbcType=INTEGER},",
          "grade_num = #{gradeNum,jdbcType=VARCHAR},",
          "standrad = #{standrad,jdbcType=VARCHAR},",
          "levl = #{levl,jdbcType=VARCHAR},",
          "score = #{score,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Criterion record);
    
    @Select({
        "select",
        "id, item_id, grade_num, type, standrad, levl, score",
        "from criterion",
        "where item_id=#{itemid,jdbcType=INTEGER} ",
        "	and grade_num=#{gradeNum, jdbcType=VARCHAR}",
        "	and type=#{type, jdbcType=INTEGER}",
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item_id", property="item", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.ItemMapper.selectByPrimaryKey")
        		),
        @Result(column="grade_num", property="gradeNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="standrad", property="standrad", jdbcType=JdbcType.VARCHAR),
        @Result(column="levl", property="levl", jdbcType=JdbcType.VARCHAR),
        @Result(column="score", property="score", jdbcType=JdbcType.VARCHAR)
    })
    List<Criterion> selectNormal(Map<String, Integer> map);
}