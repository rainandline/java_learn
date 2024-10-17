package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programme;

public class TeamService {
    private static int counter = 1;//给numberID自动赋值的基数
    private static final int MAX_MEMBER = 5;//表示开发团队的最大成员数
    private int total;//记录开发团队中的人数
    private Programme[] team = new Programme[MAX_MEMBER];


    /**
     * @return 包含所有成员对象的数组，数组的大小和人数一样
     */
    public Programme[] getTeam() {
        Programme[] team1 = new Programme[total];
        for (int i = 0; i < total; i++) {
            team1[i] = team[i];
        }
        return team1;
    }

    /**
     * @param e 待添加的对象
     * @throws TeamException 包含了失败的原因
     */
    public void addMember(Employee e) throws TeamException {
        // 成员已满，无法添加
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加！");
        }

        // 该员工已在本开发团队中
        if (!(e instanceof Programme)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        Programme p = (Programme) e;


        //该员工已是某团队成员
        //该员正在休假，无法添加
        Status status = p.getStatus();
        switch (status) {
            case BUSY:
                throw new TeamException("该员工已是其他团队成员");
            case VOCATION:
                throw new TeamException("该员工正在休假，无法添加");
        }


        //该员工已经在发开团队的内部
        boolean isExist = isExist(p);
        if (isExist) {
            throw new TeamException("在发开团队的内部");
        }


        //团队中至多只能有一名架构师
        //团队中至多只能有两名设计师
        //团队中至多只能有三名程序员
        int numOfArch = 0, numOfDesi = 0, numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) numOfArch++;
            else if (team[i] instanceof Designer) numOfDesi++;
            else numOfPro++;
        }
        if (p instanceof Architect) {
            if (numOfArch >= 1)
                throw new TeamException("团队中至多只能有一名架构师");
        } else if (p instanceof Designer) {
            if (numOfDesi >= 2)
                throw new TeamException("团队中至多只能有两名设计师");
        } else if (p instanceof Programme) {
            if (numOfPro >= 3)
                throw new TeamException("团队中至多只能有三名程序员");
        }

        p.setNumberId(counter++);
        p.setStatus(Status.BUSY);
        team[total++] = p;
    }

    /**
     * @param p 判断p是否在开发团队中
     * @return 返回true和false即可
     */
    private boolean isExist(Programme p) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == p.getId())
                return true;
        }
        return false;
    }

    /**
     * @param memberId 要删除的成员id
     * @throws TeamException 要抛出的异常，删除失败
     */
    public void removeMember(int memberId) throws TeamException {
        int i;
        for (i = 0; i < total; i++) {
            if (team[i].getNumberId() == memberId) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if (i == total)
            throw new TeamException("找不到指定memberId的员工，删除失败");
        for (int j = i; j < total - 1; j++) {
            team[j] = team[j + 1];
        }
        team[total - 1] = null;
        total--;

    }
}