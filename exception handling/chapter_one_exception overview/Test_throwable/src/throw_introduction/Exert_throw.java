package throw_introduction;

import java.io.Serial;

public class Exert_throw {
    public void regist(int num) throws MyException {
        if (num < 0)
            throw new MyException("人数为负值，不合理", 3);  //手动生成异常对象
        else
            System.out.println("登记人数" + num);
    }

    public void manager() {
        try {
            regist(100);
        } catch (MyException e) {
            System.out.print("登记失败，出错种类" + e.getId());
        }
        System.out.print("本次登记操作结束");
    }

    public static void main(String args[]) {
        Exert_throw t = new Exert_throw();
        t.manager();
    }
}

class MyException extends Exception {
    @Serial
    private static final long serialVersionUID = 13465653435L;
    private final int idnumber;
    public MyException(String message, int id) {
        super(message);
        this.idnumber = id;
    }
    public int getId() {
        return idnumber;
    }
}

//Java异常类对象除在程序执行过程中出现异常时由系统自动生成并抛出，也可根据需要使用人工创建并抛出。

