package service;

import domain.*;


import static service.Data.*;//导入该类下的静态结构

/**
 * 负责将Data中的数据封装到Employee[]数组中，同时提供想关的操作方法
 */

public class NameListService {
    private final Employee[] employees;
    //用于存储所有的员工信息。

    /**
     * 将Data中的数据加载到数组employee中，并且实现相关数据的转换
     */
    public NameListService(){
           employees=new Employee[EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++) {

            //将通用各种的数据进行包装分类
            int type=Integer.parseInt(EMPLOYEES[i][0]);
            int id=Integer.parseInt(EMPLOYEES[i][1]);
            String name=EMPLOYEES[i][2];
            int age=Integer.parseInt(EMPLOYEES[i][3]);
            double salary=Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;

            //不同类型的对象不同创建
            switch (type)
            {
                case EMPLOYEE :
                    employees[i]=new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER:
                    equipment=creatEquipment(i);
                    employees[i]=new Programme(id,name,age,salary,equipment);
                    break;
                case DESIGNER:
                    equipment=creatEquipment(i);
                    bonus=Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i]=new Designer(id,name,age,salary,equipment,bonus);
                case ARCHITECT:
                    equipment=creatEquipment(i);
                    int stock=Integer.parseInt(EMPLOYEES[i][5]);
                    bonus=Double.parseDouble(EMPLOYEES[i][4]);
                    employees[i]=new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }
        }
    }

    private Equipment creatEquipment(int index) {
        int equipmentType=Integer.parseInt(EQUIPMENTS[index][0]);
        String model=EQUIPMENTS[index][1];

        switch (equipmentType)
        {
            case PC:
                String display=EQUIPMENTS[index][2];
                return new PC(model, display);
            case NOTEBOOK:
                double price=Double.parseDouble(EQUIPMENTS[index][2]);
                return new NoteBook(model,price);
            case PRINTER:
                String name=EQUIPMENTS[index][1];
                String type_a=EQUIPMENTS[index][2];
                return new Printer(name,type_a);
        }
        return null;
    }

    public Employee[] getAllemployee()
    {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException
    {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new TeamException("找不到指定员工");
    }


}
