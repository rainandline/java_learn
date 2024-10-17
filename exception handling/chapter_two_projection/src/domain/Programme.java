package domain;

import service.Status;

public class Programme extends Employee {
    private int numberId;//开发团队中的mId
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programme() {
    }

    public Programme(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getNumberId() {
        return numberId;
    }

    public void setNumberId(int numberId) {
        this.numberId = numberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String toString() {
        return getDetail() + " \t程序员\t " + status + " \t\t\t\t\t\t " + equipment.getDescription();
    }

    public String getTeamDetail() {
        return numberId + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary();
    }

    public String getDetailsForTeam() {
        return getTeamDetail() + " \t程序员 ";
    }
}
