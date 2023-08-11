package DataModels;

import java.util.Comparator;

public class Passenger {
    String name;
    String pClass;
    Double age;
    String sex;
    Integer survived;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPClass() {
        return pClass;
    }

    public void setPClass(String pClass) {
        this.pClass = pClass;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getSurvived() {
        return survived;
    }

    public void setSurvived(Integer survived) {
        this.survived = survived;
    }

    public Passenger(String name, String pClass, Double age, String sex, Integer survived) {
        this.name = name;
        this.pClass = pClass;
        this.age = age;
        this.sex = sex;
        this.survived = survived;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", pClass='" + pClass + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", survived=" + survived +
                '}';
    }
}
