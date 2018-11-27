package demos.example.code.tkmybaits.entity;

import javax.persistence.*;

@Table(name = "tb_user")
public class User {
    @Id
    private Float id;

    private String name;

    private String sex;

    private Integer age;

    /**
     * @return id
     */
    public Float getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Float id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}