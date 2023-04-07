package com.mindex.challenge.service.impl;

import com.mindex.challenge.service.ReportingStructureService;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService{
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

        private final EmployeeService employeeService;

        public ReportingStructureServiceImpl(@NotNull EmployeeService employeeService){
            this.employeeService = employeeService;
    
        }

        @Override
        public ReportingStructure create(String id){
            LOG.debug("Creating report structure for id [{}]", id);

            Employee employee = employeeService.read(id);
            
            return create(employee);

        }

        @Override
        public ReportingStructure create(Employee employee){
            LOG.debug("Creating report-structure for id [{}]", employee.getEmployeeId());
            ReportingStructure reportingStructure = new ReportingStructure();
            reportingStructure.setEmployee(employee);

            int numReport = getEmployeeReports(employee);
            reportingStructure.setNumReports(numReport);

            return reportingStructure;
        }

        private int getEmployeeReports(Employee employee){
            List<Employee> reports = employee.getDirectReports();
            int n = reports.size();

            for( Employee e : reports){
                if(e.getEmployeeId() != null){
                    Employee subEmployee = employeeService.read(e.getEmployeeId());
                    if( subEmployee.getDirectReports() != null){
                        n += subEmployee.getDirectReports().size();
                    }
                }
            }

            return n;
        }
}
    
    



