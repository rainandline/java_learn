package domain;

public class Designer extends Programme {
    private double bonus;

    public Designer() {

    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String toString() {
        return getDetail() + " \t设计师\t " + getStatus() + " \t " + getBonus() + " \t\t\t " + getEquipment().getDescription();
    }

    public String gettDetail() {
        return getTeamDetail() + " \t设计师\t " + getBonus();
    }


}
