package week7;

public class Employee {
    private int empId;
    private String empName;
    private String empDesignation;

    public Employee(int empId,String empName,String empDesignation){
        this.empId = empId;
        this.empName = empName;
        this.empDesignation = empDesignation;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    @Override
    public String toString(){
        return getEmpId()+" - "+getEmpName()+" - "+getEmpDesignation();
    }

}
