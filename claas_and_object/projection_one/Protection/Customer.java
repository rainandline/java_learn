
/**
 * ClassName: Customer
 *  客户类
 */
public class Customer {
    //属性
    private String name;    //客户姓名
    private char gender;    //性别
    private int age;    //年龄
    private String phone;   //电话号码
    private String email;   //电子邮箱


    //方法
    public void setName(String name){
        this.name=name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public String getDetails(){
        return name + "\t" +gender +"\t" +age+ "\t" +phone +"\t"+email;
    }

    //构造器
    public Customer() {
    }

    public Customer(String name, char gender, int age, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }
}
