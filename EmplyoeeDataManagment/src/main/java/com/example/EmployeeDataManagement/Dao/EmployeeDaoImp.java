package com.example.EmployeeDataManagement.Dao;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.EmployeeDataManagement.model.VWEmployeeData;
import com.example.EmployeeDataManagement.model.address;
import com.example.EmployeeDataManagement.model.department;
import com.example.EmployeeDataManagement.model.employee;

import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeDaoImp implements EmployeeDao{
	
private static Logger logger = Logger.getLogger("EmployeeDaoImpl");
	
	@Autowired
    private EntityManagerFactory entityManagerFactory;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<VWEmployeeData> getAll() {
		// TODO Auto-generated method stub
		logger.info("START::EmployeeDaoImpl.getAll");
		Session session = null;

		try {
			session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			List<VWEmployeeData> allList = session.createQuery("from VWEmployeeData ").list();

			logger.info("END::EmployeeDaoImpl.getAll");
			return allList;

		} catch(Exception exc) {
			logger.error("ERROR::EmployeeDaoImpl.getAll", exc);
			return null;

		} finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}

	}


	@Override
	public List<VWEmployeeData> getById(int deptId) {
		// TODO Auto-generated method stub
		logger.info("START::EmployeeDaoImpl.getById");
		Session session = null;
		try {
			session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			List<VWEmployeeData> allList = session.createQuery("from VWEmployeeData where deptId="+deptId+"").list();

			logger.info("END::EmployeeDaoImpl.getById");
			return allList;


		} catch(Exception exc) {
			logger.error("ERROR::EmployeeDaoImpl.getById", exc);
			return null;

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}


	@Override
	public String save(employee emp, department dept, address addr) {
		// TODO Auto-generated method stub
		logger.info("START::EmployeeDaoImp.save");
		Session session = null;
		try {
		    session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		    session.beginTransaction();
		    session.save(emp);
		    session.saveOrUpdate(dept);
		    session.saveOrUpdate(addr);
		    session.getTransaction().commit();
		    session.flush();
		
		    logger.info("END::EmployeeDaoImpl.add");
		    return "saved";
		
		} catch (Exception exc) {
		    session.getTransaction().rollback();
		    logger.error("ERROR::EmployeeDaoImpl.add", exc);
		    return "something went to wrong";
		} finally {
		    if (session != null && session.isOpen()) {
			session.close();
		    }
		}
	}

}
