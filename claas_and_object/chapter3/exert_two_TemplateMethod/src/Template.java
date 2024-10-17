
public abstract class Template {
    //计算某段代码执行所花费的时间
    public void spendTime() {
        long start = System.currentTimeMillis();
        //currentTimeMillis用于获取当前时间的常用方法，它返回从1970 年 1 月 1 日 00:00:00 GMT开始到当前时间的毫秒数。

        code(); //不确定的部分、易变的部分

        long end = System.currentTimeMillis();
        System.out.println("花费的时间：" + (end - start));
    }

    public abstract void code(); //抽象
}

//code的位置并不影响，编译需要code()这个方法首先会到代码区里面找，并不是一味的从上到下的编译
