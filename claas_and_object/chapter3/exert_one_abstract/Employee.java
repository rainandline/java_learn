import java.util.Date;

/**
 * 定义一个Employee类，该类包含
 * private成员变量name,number,birthday，其中birthday 为MyDate类的对象:提供必要的构造器;
 * abstract方法earnings(),返回工资数额;
 * toString()方法输出对象的name,number和birthday。
 */

public abstract class Employee {
    private String name;
    private int number;
    private MyDate brithday;

    public Employee() {
    }

    public Employee(String name, int number, MyDate brithday) {
        this.name = name;
        this.number = number;
        this.brithday = brithday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public MyDate getBrithday() {
        return brithday;
    }

    public void setBrithday(MyDate brithday) {
        this.brithday = brithday;
    }

    public abstract double earning();

    public String toString() {
        return "name = " + name + ",number = " + number + ", birthday = " + brithday.toDateString();

    }
}