public class SubTemplate extends Template{
    @Override//实现对于抽象类的重写
    public void code() {  //实现父类中抽象方法
        //1000以内的质数输出：
        boolean isFlag = true;
        for (int i = 2; i <= 1000; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isFlag = false;
                    break;
                }
            }
            if (isFlag) {
                System.out.print(i + " ");
            }
            isFlag = true;
        }
        System.out.println();
    }

}
