import java.util.Date;

/**
 * 参照SalariedEmployee类定义HourlyEmployee类
 * 实现按小时计算工资的员工处理。该类包括:private成员变量wage和hour;
 * 提供必要的构造器;
 * 实现父类的抽象方法earnings()
 * 该方法返回wage*hour值;toString()方法输出员工类型信息及员工的name，number,birthday。
 */
public class HourlyEmployee extends Employee{
    private double wage;
    private int hour;

    public HourlyEmployee() {
    }

    public HourlyEmployee(String name, int number, MyDate brithday, double wage, int hour) {
        super(name, number, brithday);
        this.wage = wage;
        this.hour = hour;
    }

    @Override//对于抽象类的重写
    public double earning() {
        return wage*hour;
    }


    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }



    public String toString() {
        return "HourlyEmployee [ " + super.toString() + " ] ";
    }
}
