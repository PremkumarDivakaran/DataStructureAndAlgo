package week7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Practice3_SotingUsingJava8 {

    @Test
    public void getEmployeeNameWithHighestEmpIdAndEngineerDesignation(){
        List<Employee> lst = new ArrayList<>();
        lst.add(new Employee(1001, "Sam David", "QA Software Engineer"));
        lst.add(new Employee(1003,"Gopi","Automation Architect"));
        lst.add(new Employee(1006,"Naveen","Jr. Test Engineer"));
        lst.add(new Employee(1007,"Balaji","QA Software Engineer"));
        lst.add(new Employee(1010,"koushik","QA Software Engineer"));
        lst.add(new Employee(1019,"Narashiman","Digital Marketing Consultant"));

        String out = lst.stream().filter(emp -> emp.getEmpDesignation().contains("Engineer"))
                .max(Comparator.comparing(Employee::getEmpId))
                .get().getEmpName();
        System.out.println(out);

        List<Employee> ls = lst.stream().filter(emp -> emp.getEmpDesignation().contains("Engineer"))
                .sorted(Comparator.comparing(Employee::getEmpId).reversed()).limit(1)
                .collect(Collectors.toList());
        System.out.println(ls);
        System.out.println(ls.get(0).getEmpName());

    }
}
