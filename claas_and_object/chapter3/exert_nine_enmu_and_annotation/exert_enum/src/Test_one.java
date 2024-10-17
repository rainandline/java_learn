public class Test_one {
    public static void main(String[] args) {

        //1.所属于的类和继承的所属于的关系
        System.out.println(SeasonEnum.SPRING.getClass());//class SeasonEnum
        System.out.println(SeasonEnum.SPRING.getClass().getSuperclass());//class java.lang.Enum
        System.out.println(SeasonEnum.SPRING.getClass().getSuperclass().getSuperclass());//class java.lang.Object

        //SeasonEnum有一个默认的继承类就是Enum，不能对于他做其他的继承关系，不能显式的定义其父类


        //2.enum中的方法
        //（1）：toString()返回枚举常量的字符串表示，返回的也就是创建对象的名称
        //（2）：name()	获取枚举常量的名称
        System.out.println(SeasonEnum.SPRING);//SeasonEnum{name='春天', desc='春暖花开'}   (重写后的方法）
        System.out.println(SeasonEnum.FALL.name());//FALL

        //（3）：values()	获取枚举类型中所有的枚举常量
        SeasonEnum[] values=SeasonEnum.values();
        for (SeasonEnum seasonEnum : values) {
            System.out.println(seasonEnum);
            //SeasonEnum{name='春天', desc='春暖花开'}
            //SeasonEnum{name='夏天', desc='炎炎盛夏'}
            //SeasonEnum{name='秋天', desc='秋高气爽'}
            //SeasonEnum{name='冬天', desc='大雪纷飞'}
        }

        //(4):valueOf(String name)	根据枚举常量的名称获取对应的枚举常量
        //如果枚举中没有这个方法则会报错
        String objName="WINTER";
        SeasonEnum season=SeasonEnum.valueOf(objName);
        System.out.println(season);//SeasonEnum{name='冬天', desc='大雪纷飞'}

        //（5）：ordinal()获取枚举常量的序号
        System.out.println(SeasonEnum.FALL.ordinal());//2


        //3.接口实现匿名实现类的对象
        SeasonEnum[] season2=SeasonEnum.values();
        for (int i = 0; i < season2.length; i++) {
            values[i].show();
            //春天在哪里啊！！！！！
            //夏天在哪里啊！！！！！
            //秋天在哪里啊！！！！！
            //冬天在哪里啊！！！！！
        }

    }
}

interface info{
    void show();
}

enum SeasonEnum implements info{

    //JDK 1.5以后可以省略public static final Season的修饰
    //必须在第一行写出有哪些枚举值
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里啊！！！！！");
        }
    },
    SUMMER("夏天", "炎炎盛夏"){
        @Override
        public void show() {
            System.out.println("夏天在哪里啊！！！！！");
        }
    },
    FALL("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天在哪里啊！！！！！");
        }
    },
    WINTER("冬天", "大雪纷飞") {
        @Override
        public void show() {
            System.out.println("冬天在哪里啊！！！！！");
        }
    };

    private final String name;//季节的名字
    private final String desc;//对于季节的描述


    SeasonEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }


    @Override
    public String toString() {
        return "SeasonEnum{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

//JDK 1.5以前的表示枚举

//public class Season {
//	//属性不能修改，用 final 修饰，说明其只能调用不能修改
//	private final String name;
//	private final String desc;
//
//	//因为枚举类的对象是有限的，即我们不能再外面 new Season()，所以构造器私有化
//	private Season(String name,String desc) {
//		this.name = name;
//		this.desc = desc;
//	}
//
//	//不能再外面new Season(),那么内部必须创建出对象
//	//外界直接通过类名来访问，用 static 修饰
//	//外界不能修改，用 final 修饰
//	public static final Season SPRING = new Season("春天", "春暖花开");
//	public static final Season SUMMER = new Season("夏天", "炎炎盛夏");
//	public static final Season FALL = new Season("秋天", "秋高气爽");
//	public static final Season WINTER = new Season("冬天", "大雪纷飞");
//
//	@Override
//	public String toString() {
//		return "Season [name=" + name + ", desc=" + desc + "]";
//	}
//
//
//}


//枚举类型在Java中具有以下优点和缺点：
//
//优点：
//易读性和可维护性：枚举类型中的常量是有意义的、自描述的，使得代码更易读、易理解和易于维护。枚举常量具有唯一的名称，提供了更好的文档和注释。
//类型安全：枚举类型在编译时进行静态类型检查，这意味着编译器可以确保只使用有效的枚举常量，提供了更高的类型安全性。
//可限定的值集合：枚举类型定义了一个有限的值集合，限定了有效的取值范围。这可以帮助避免程序中出现无效或意外的取值。
//避免魔法数值：使用枚举类型可以避免使用硬编码的魔法数值，提供了更好的代码可读性和可维护性。
//增强的编译器支持：枚举类型在编译器层面提供了一些额外的支持，如自动添加常用方法（如values()、valueOf()）、枚举常量的顺序等。
//适用于状态和选项的表示：枚举类型非常适用于表示状态、选项和固定集合，如季节、颜色、星期几等。

//缺点：
//不适用于动态变化的数据：枚举类型是在编译时定义的，其常量集合是固定的。如果需要表示动态变化的数据集合，枚举类型可能不适合。
//不适用于大型数据集合：如果需要表示大型的数据集合，枚举类型的常量定义可能会变得冗长和繁琐。
//缺乏扩展性：枚举类型的常量是在编译时确定的，不支持动态添加或删除常量。因此，如果需要频繁地修改常量集合，可能会导致代码的改动和维护成本的增加。
//不支持继承：枚举类型不支持继承，无法实现枚举类型之间的继承关系。
