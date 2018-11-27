package demos.example.code.tkmybaits.mapper;


import demos.example.code.tkmybaits.dao.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;


@Mapper
public interface TestMapper {
    //在org.fkit.MapperXml.TestMapper.xml里面定义
     void insertUser(User user);

    @Insert("insert into tb_user(id,name,sex,age)values(#{id},#{name},#{sex},#{age})")
    void saveUser(User user);
    @Delete("delete from tb_user where id=#{id}")
    int removeUser(User user);
    @Delete("delete from tb_user where id=#{id}")
    int removeById(@Param("id") Integer id);
    @Update("update tb_user set name=#{name},sex=#{sex},age=#{age} where id=#{id}")
    void modifyUser(User user);

    @Select("select * from tb_user where id=#{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name"),
            @Result(column="sex",property="sex"),
            @Result(column="age",property="age")
    })
    User selectById(@Param("id") Integer id);
    @Select("select * from tb_user where id=#{id} ")
    List<User> selectUser(User user);
    @Select("select * from tb_user where names=#{name} ")
    List<User> selectUserByName(@Param("name") String name);
    @Select("select * from tb_user")
    List<User> selectAllUser();



    //one to one
    @Select("select * from tb_card where id=#{id}")
    Card selectCardById(Integer id);

    @Select("select * from tb_student where id=#{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name"),
            @Result(column="sex",property="sex"),
            @Result(column="age",property="age"),
            @Result(column="card_id",property="card",one=@One(
                    select="selectCardById",fetchType= FetchType.EAGER))
    })
    Student selectStudentById(Integer id);

    //one to many
    @Select("select * from tb_student where card_id=#{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name"),
            @Result(column="sex",property="sex"),
            @Result(column="age",property="age")
    })
    List<Student> selectStudentByClazzId(Integer Id);

    @Select("select * from tb_class where id=#{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="code",property="code"),
            @Result(column="id",property="students",many=@Many(
                    select="selectStudentByClazzId",fetchType=FetchType.EAGER))
    })
    Clazz selectClazzById(Integer id);


    //many to many
    @Select("select * from tb_student where id in(select student_id from tb_course_student where course_id=#{id})")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name"),
            @Result(column="sex",property="sex"),
            @Result(column="age",property="age")
    })
    List<Student> selectByCourseId(Integer Id);

    @Select("select * from tb_course where id=#{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name"),
            @Result(column="id",property="students",many=@Many(
                    select="selectByCourseId",fetchType=FetchType.LAZY))
    })
    Course selectCourseById(Integer id);

    @Insert("insert into tb_user(id,name,sex,age)values(#{id},#{name},#{sex},#{age})")
    int inserStudents(Course course, List<Student> students);

}

