package tool;

import domain.Employee;
import domain.Programme;
import service.NameListService;
import service.TeamException;
import service.TeamService;

public class TeamView_control {
    public static void main(String[] args) {
        TeamView_control teamView=new TeamView_control();
        teamView.enterMainMenu();
    }

    private final NameListService listSvc=new NameListService();
    private final TeamService teamSvc=new TeamService();

    public void enterMainMenu(){

        boolean flag=true;
        char key=0;
        while(flag){
            if(key!='1'){
                listAllEmployees();
            }

            System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4):");
            key=TSUtility.readMenuSelection();
            switch (key){
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("是否确认退出(Y/N):");
                    char isExit=TSUtility.readConfirmSelection();
                    if(isExit=='Y'){
                        flag=false;
                        break;
                    }
            }
        }

    }

    public void listAllEmployees(){
        System.out.println("------------------------开发团队调度软件--------------------------\n");
        System.out.println("ID \t 姓名 \t 年龄 \t 工资 \t\t 职位 \t\t 状态 \t 奖金 \t\t 股票 \t\t 领用设备");
        Employee[] employees=listSvc.getAllemployee();
        for(int i=0;i<employees.length;i++){
            System.out.println(employees[i]+"\n");
        }
        System.out.println("----------------------------------------------------------------");
    }

    public void getTeam(){
        System.out.println("------------------------团队成员列表--------------------------\n");
        System.out.println("ID \t 姓名 \t 年龄 \t 工资 \t 职位 \t状态 \t 奖金 \t 股票 \t 领用设备");
        Programme[] programmer=teamSvc.getTeam();
        for(int i=0;i<programmer.length;i++){
            System.out.println(programmer[i].getDetailsForTeam());
        }
        System.out.println("------------------------------------------------------------");
    }

    public void addMember(){
        System.out.println("------------------------添加成员--------------------------");
        System.out.println("请输入要添加的员工ID：");
        int id=TSUtility.readInt();

        try{
            Employee a=listSvc.getEmployee(id);
            teamSvc.addMember(a);
        }catch (TeamException e){
            System.out.println(e.getMessage());
        }
        TSUtility.readReturn();

    }

    public void deleteMember(){
        System.out.println("------------------------删除成员--------------------------");
        System.out.println("请输入要添加的员工ID：");
        int id=TSUtility.readInt();
        System.out.println("确认是否删除(Y/N):");
        char isDele=TSUtility.readConfirmSelection();
        if(isDele=='N'){
            return;
        }

        try {
            teamSvc.removeMember(id);
        }catch (TeamException e){
            System.out.println(e.getMessage());
        }
        System.out.println("删除成功");

        TSUtility.readReturn();
    }

}
