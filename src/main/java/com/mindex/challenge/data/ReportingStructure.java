package com.mindex.challenge.data;

public class ReportingStructure{
    private Employee employee;
    private int numReport;

    public ReportingStructure(){

    }

    public Employee getEmployee(){
        return this.employee;

    }

    public int getNumReports(){
        return this.numReport;
    }
    public void setEmployee(Employee employee){
        this.employee = employee;

    }

    public void setNumReports(int num){
        this.numReport = num;
    }


}