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
import sport.bean.Env;

public interface EnvMapper {
    @Delete({
        "delete from env",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into env (id, clas_id, ",
        "item_id, name, dater, ",
        "place, equipment, ",
        "mode)",
        "values (#{id,jdbcType=INTEGER}, #{class_.id,jdbcType=INTEGER}, ",
        "#{item.id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, #{time,jdbcType=DATE}, ",
        "#{place,jdbcType=VARCHAR}, #{equipment,jdbcType=VARCHAR}, ",
        "#{mode,jdbcType=VARCHAR})"
    })
    
    int insert(Env record);

    @InsertProvider(type=EnvSqlProvider.class, method="insertSelective")
    int insertSelective(Env record);

    @Select({
        "select",
        "id, clas_id, item_id, name,dater, place, equipment, mode",
        "from env",
        "where id = #{id,jdbcType=INTEGER}"
    })
    
    @Results({
    	
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="clas_id", property="class_", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.Class_Mapper.selectByPrimaryKey")
        		),
        @Result(column="item_id", property="item", jdbcType=JdbcType.INTEGER,
        		one=@One(select="sport.dao.ItemMapper.selectByPrimaryKey")
        		),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="dater", property="time", jdbcType=JdbcType.DATE),
        @Result(column="place", property="place", jdbcType=JdbcType.VARCHAR),
        @Result(column="equipment", property="equipment", jdbcType=JdbcType.VARCHAR),
        @Result(column="mode", property="mode", jdbcType=JdbcType.VARCHAR)
    })
    Env selectByPrimaryKey(Integer id);
    //主键查询
    
    
    @Select({
        "select",
        "id, clas_id, item_id, name, dater, place, equipment, mode",
        "from env",
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="clas_id", property="class_", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.Class_Mapper.selectByPrimaryKey")),
        
        @Result(column="item_id", property="item", jdbcType=JdbcType.INTEGER,
        		one=@One(select="sport.dao.ItemMapper.selectByPrimaryKey")
        		),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="dater", property="time", jdbcType=JdbcType.DATE),
        @Result(column="place", property="place", jdbcType=JdbcType.VARCHAR),
        @Result(column="equipment", property="equipment", jdbcType=JdbcType.VARCHAR),
        @Result(column="mode", property="mode", jdbcType=JdbcType.VARCHAR)
    })
    List<Env> selectAll();
    //查询全部
    
    @Select({
        "select",
        "id, clas_id, item_id, name, dater, place, equipment, mode",
        "from env where clas_id=#{id,jdbcType=INTEGER}",
        "order by item_id"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="clas_id", property="class_", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.Class_Mapper.selectByPrimaryKey")),
        
        @Result(column="item_id", property="item", jdbcType=JdbcType.INTEGER,
        		one=@One(select="sport.dao.ItemMapper.selectByPrimaryKey")
        		),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="dater", property="time", jdbcType=JdbcType.DATE),
        @Result(column="place", property="place", jdbcType=JdbcType.VARCHAR),
        @Result(column="equipment", property="equipment", jdbcType=JdbcType.VARCHAR),
        @Result(column="mode", property="mode", jdbcType=JdbcType.VARCHAR)
    })
    List<Env> selectEnvByClassId(Integer id);
    
    @Delete({
    	"delete from env",
        "where clas_id = #{id,jdbcType=INTEGER}"
    })
    int deleteByClas_id(Integer id);
        
    @UpdateProvider(type=EnvSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Env record);
    
    @Update({
        "update env",
        "set clas_id = #{class_.id,jdbcType=INTEGER},",
          "item_id = #{itemId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "dater = #{time,jdbcType=DATE},",
          "place = #{place,jdbcType=VARCHAR},",
          "equipment = #{equipment,jdbcType=VARCHAR},",
          "mode = #{mode,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Env record);
}