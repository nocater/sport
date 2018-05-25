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
import sport.bean.Account;

public interface AccountMapper {
    @Delete({
        "delete from account",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into account (id, role_id, ",
        "name, real_name, ",
        "password)",
        "values (#{id,jdbcType=INTEGER}, #{role.id,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{realName,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR})"
    })
    int insert(Account record);

    @InsertProvider(type=AccountSqlProvider.class, method="insertSelective")
    int insertSelective(Account record);

    @Select({
        "select",
        "id, role_id, name, real_name, password",
        "from account",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="role", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.RoleMapper.selectByPrimaryKey")),
        
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR)
    })
    
    Account selectByPrimaryKey(Integer id);
    
    @Select({
        "select",
        "id, role_id, name, real_name, password",
        "from account",
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="role", jdbcType=JdbcType.INTEGER,
        		one = @One(select="sport.dao.RoleMapper.selectByPrimaryKey")),
        
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR)
    })
    
    List<Account > selectAll();  
  
    @UpdateProvider(type=AccountSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Account record);

    @Update({
        "update account",
        "set role_id = #{role.id,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "real_name = #{realName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Account record);
}