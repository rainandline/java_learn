/**
 * ClassName: CustomerList
 * Package: yuyi03
 * Description:
 *  CustomerList为Customer对象的管理模块，内部使用数组管理一组Customer对象
 */
public class CustomerList {
    //属性
    private Customer[] customers;   //用来保存客户对象的数组
    private int total;  //记录已保存客户对象的数量


    //构造器
    /**
     * 用途：构造器，用来初始化customers数组
     * @param totalCustomer  指定customers数组的最大空间
     */
    public CustomerList(int totalCustomer){
        customers=new Customer[totalCustomer];
    }


    //方法
    /**
     * 用途：将参数customer添加组中最后一个客户对象记录之后
     * @param customer  参数：customer指定要添加的客户对象
     * @return  返回：添加成功返回true；false表示数组已满，无法添加
     */
    public boolean addCustomer(Customer customer){
        if(total<customers.length){ //若此时客户对象的数量(total)小于数组长度，说明数组没有满，可以添加客户进去
            customers[total]=customer;
            total++;    //加完一个客户进数组，客户对象数量加一
            return true;
        }else{
            return false;
        }
    }

    /**
     * 用途：用参数cust替换数组中由index指定的对象
     * @param index  index指定所替换对象在数组中的位置，从0开始
     * @param cust  参数：cust 指定替换的新客户对象
     * @return  返回：替换成功返回true；false表示索引无效，无法替换
     */
    public boolean replaceCustomer(int index, Customer cust){
        if(index>=0 && index<total){
            customers[index]=cust;
            return true;
        }else{
            return false;
        }
    }

    /**
     * 用途：从数组中删除参数index指定索引位置的客户对象记录
     * @param index  参数： index指定所删除对象在数组中的索引位置，从0开始
     * @return  返回：删除成功返回true；false表示索引无效，无法删除
     */
    public boolean deleteCustomer(int index){
        if(index<0 || index>=total){
            return false;
        }
        for (int i = index; i < total-1; i++) {
            customers[i]=customers[i+1];
        }

        //将有效数据最后一个位置置空
        //customers[total-1]=null;
        //total--;
        //或
        customers[--total]=null;
        return true;
    }

    /**
     * 用途：返回数组中记录的所有客户对象
     * @return 返回： Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同。
     */
    public Customer[] getAllCustomers(){
        //错误的：
        //return customers;  会将空的元素也一起返回，现在只需要有客户的对象元素

        //正确的：
        Customer[] cus=new Customer[total]; //要是一个也没有存，total是0，循环进不去，直接返回，相当于造了一个长度为0的数组
        for (int i = 0; i < total; i++) {   //total也可以改为cus.length
            cus[i]=customers[i];    //没有将对象复制过来，只是将地址复制过来了，对象还是原来的那个
        }
        return cus;
    }

    /**
     * 用途：返回参数index指定索引位置的客户对象记录
     * @param index  参数： index指定所要获取的客户在数组中的索引位置，从0开始
     * @return 返回：封装了客户信息的Customer对象
     */
    public Customer getCustomer(int index){
        if(index>0 || index<total){ //index有效范围
            return customers[index];
        }else{
            return null;
        }
    }

    /**
     *获取客户列表中客户的数量
     * @return  客户数量total
     */
    public int getTotal(){
        return total;
    }

}


//CustomerList为Custom对象的管理模块，内部使用数组管理Customer对象