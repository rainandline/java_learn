public class ComparableCircle extends Circle implements CompareObject {

    public ComparableCircle() {
    }

    public ComparableCircle(double ridius) {
        super(ridius);
    }

    //根据比较半径的方法进行比较
    @Override
    public int compareTo(Object o) {
        if (this == o)
            return 0;
        if (o instanceof ComparableCircle) {
            ComparableCircle c = (ComparableCircle) o;
            return Double.compare(this.getRidius(), c.getRidius());
        } else {
            throw new RuntimeException("输入的对象不匹配");
        }
    }
}
