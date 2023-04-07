package com.mindex.challenge.data;

import java.math.BigDecimal;
import java.util.Date;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Compensation {
    private String employee;
    private BigDecimal salary;
    private Date effectiveDate;
    

    private static Logger LOG = LoggerFactory.getLogger(Compensation.class);
    public Compensation(){

    }
    

    public void setEmployee(String employee){
        this.employee = employee;

    }

    public String getEmployeeId(){
        return this.employee;
    }
    public String getSalary(){
        return this.salary.toPlainString();
    }

    public void setSalary(String salary){
        this.salary = new BigDecimal(salary);
    }

    public String getDate(){
        return new SimpleDateFormat("mm-dd-yyyy").format(this.effectiveDate);

    }
    public void setDate(String effectiveDate){
        try{
            this.effectiveDate = new SimpleDateFormat("mm-dd-yyyy").parse(effectiveDate);

        } catch (ParseException e){
            LOG.debug("Unable to parse date [{}]", effectiveDate);
        }

    }

    @Override
    public String toString(){
        return "{"+"employeeID='"+ getEmployeeId() +"'" + ",\n salary='" + getSalary() +"'";
    }



}
