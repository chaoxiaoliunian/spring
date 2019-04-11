package sjqi.model;

import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author sjqi
 * @Date 17:31 2019/3/26
 * @Version 1.0
 **/
public class User {
    String name;
    int age=20;
    Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
