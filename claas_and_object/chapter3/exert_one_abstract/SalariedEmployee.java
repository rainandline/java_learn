import java.util.Date;

/**
 * 定义SalariedEmployee类继承Employee类
 * 实现按月计算工资的员工处理。该类包括:private成员变量monthlySalary;
 * 提供必要的构造器;
 * 实现父类的抽象方法earnings(),
 * 该方法返回monthlySalary值;toString()方注输出品工类型信息及品工的name. number birthday
 */
public class SalariedEmployee extends Employee {
    private double monthlySalary;//月工资

    public SalariedEmployee() {
    }

    @Override
    public double earning() {
        return monthlySalary;
    }

    public SalariedEmployee(String name, int number, MyDate birthday, double monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String toString() {
        return "SalariedEmployee[" + super.toString() + "]";
    }
}
