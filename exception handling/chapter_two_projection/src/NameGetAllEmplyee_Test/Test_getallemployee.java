package NameGetAllEmplyee_Test;

import domain.Employee;
import org.junit.Test;
import service.NameListService;
import service.TeamException;

public class Test_getallemployee {

    @Test
    public void Test_getallemployee() {
        NameListService nameListService = new NameListService();
        Employee[] employees = nameListService.getAllemployee();

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }

    }


    @Test
    public void testGetEmployee() {
        try {
            NameListService nameListService = new NameListService();
            int id = 13;
            Employee employee = nameListService.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }


}
