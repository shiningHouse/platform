package com.cunity.platform.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cunity.platform.dao.DepartmentDao;
import com.cunity.platform.dao.EmployeeDao;
import com.cunity.platform.model.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@RequestMapping(value="/emp", method=RequestMethod.PUT)
	public String update(Employee employee){
		Employee beforeEmployee = employeeDao.get(employee.getId());
		employee.setLastName(beforeEmployee.getLastName());
		employeeDao.save(employee);
		return "redirect:emps";
	}
	
	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
	public String input(@PathVariable Integer id, Map<String,Object> map){
		map.put("employee", employeeDao.get(id));
		map.put("departments", departmentDao.getDepartments());
		return "input";
	}
	
	/**
	 * 重点是JSP页面如何发起一个delete请求，实际只是post请求
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable Integer id){
		System.out.println("........RESU DELETE.........." + id);
		employeeDao.delete(id);
		return "redirect:/employee/emps";
	}
	
	
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	public String save(Employee employee){
		System.out.println("save emp="+employee);
		employeeDao.save(employee);
		return "redirect:emps";
	}
	 
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String input(Map<String, Object> map){
		System.out.println("show input employee page");
		map.put("departments", departmentDao.getDepartments());
		map.put("employee", new Employee());
		return "input";
	}
	
	@RequestMapping("/emps")
	public String list(Map<String, Object> map){
		map.put("employees", employeeDao.getAll());
		return "list";
	}
	
}
