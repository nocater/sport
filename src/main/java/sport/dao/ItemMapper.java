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
import sport.bean.Item;

public interface ItemMapper {
	@Select({
		"select",
        "id, name",
        "from item where id in(",
        	"select",
        	"item_id",
        	"from grade_item",
        	"where grade_id = #{id}",
        ")",	
	})
	
	@Results({
		@Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
		@Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
	})
	
	List<Item> selectByGrade(Integer id);
    	
	@Select({
		" select id, name from item where id in("
		+ "select item_id from grade_item where grade_id = ("
		+ "select grade_id from student where id = #{id})"
		+ ")"
	})
	
	@Results({
		@Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
		@Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
	})	
	
	List<Item> selectByStudent(Integer id);
	
	@Select({
		" select id, name from item where id in("
		+ "select item_id from grade_item where grade_id = ("
		+ "select grade_id from clas where id = #{id})"
		+ ")"
	})
	
	@Results({
		@Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
		@Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
	})	
	
	
	
	List<Item> selectByClass(Integer id);
	
	
	
	
    @Delete({
        "delete from item",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Insert({
        "insert into item (id, name)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    
    int insert(Item record);

     
    @InsertProvider(type=ItemSqlProvider.class, method="insertSelective")
    int insertSelective(Item record);

    @Select({
        "select",
        "id, name",
        "from item",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Item selectByPrimaryKey(Integer id);
    
    @Select({
        "select",
        "id, name",
        "from item"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Item> selectAllItems();
    
    
    

    @UpdateProvider(type=ItemSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Item record);

    @Update({
        "update item",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Item record);
    
}