package throws_introduction;

public class Exert_throws {
    public static void divide(int a, int b) throws ArithmeticException, NullPointerException {
        int result = a / b;
        System.out.println("结果为：" + result);
    }

    public static void main(String[] args) {
        try
        {
            divide(10,2);
        }catch (ArithmeticException e)
        {
            System.out.println("divide捕获到的除数异常："+e.getMessage());
        }
        catch(NullPointerException e){
            System.out.println("divide未执行");
        }
    }
}



//throws的说明：
//①"throws + 异常类型"写在方法的声明处。指明此方法执行时。
//可能会抛出的异常类型。一旦当方法体执行时，出现异常，仍会在异常代码处生成一个异常类的对象，此对象满足throws后异常类型时，就会被抛出。
//异常代码后续的代码，就不再执行！

//②如果一个方法(中的语句执行时)可能生成某种异常，但是并不能确定如何处理这种异常，则此方法应**显示地声明抛出异常，
//**表明该方法将不对这些异常进行处理， 而由该方法的调用者负责处理。

//③在方法声明中用throws语句可以声明抛出异常的列表，throws后面的异常类型可以是方法中产生的异常类型，也可以是它的父类。

//如果父类中被重写的方法没有throws方式处理异常，则子类重写的方法也不能使用throws。意味着如果子类重写的方法中有异常，必须使用try-catch-finally方式处理。
//② 执行的方法a中，先后又调用了另外的几个方法，这几个方法是递进关系执行的。我们创建这几个方法使用throws的方式进行处理。而执行的方法a可以考虑try-catch-finally方式进行处理。
