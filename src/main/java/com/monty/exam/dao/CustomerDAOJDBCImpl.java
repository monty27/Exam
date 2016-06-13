package com.monty.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOJDBCImpl extends BaseDAO implements CustomerDAO {

	@Override
	public List<Customer> getALLCustomers() {
		
		return null;
	}

	@Override
	public void createCustomer(Customer customer) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = getConnection();
			String sql = "INSERT INTO CUSTOMERS (NAME, ADDRESS, SSN, USERNAME, PASSWORD) VALUES (?, ?, ?, ?, ?)";
			st = con.prepareStatement(sql);
			System.out.println(sql);
			st.setString(1, customer.getName());
			st.setString(2, customer.getAddress());
			st.setInt(3, customer.getSsn());
			st.setString(4, customer.getUsername());
			st.setString(5, customer.getPassword());
			st.executeUpdate();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			closeResources(null,st,con);
		}

	}

	@Override
	public void updateCustomer(Customer customer) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = getConnection();
			String sql = "UPDATE CUSTOMERS SET NAME = ?, ADDRESS = ?, SSN = ?, USERNAME = ?, PASSWORD = ?";
			st = con.prepareStatement(sql);
			st.setString(1, customer.getName());
			st.setString(2, customer.getAddress());
			st.setInt(3, customer.getSsn());
			st.setString(4, customer.getUsername());
			st.setString(5, customer.getPassword());
			st.executeUpdate();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			closeResources(null,st,con);
		}

	}

	@Override
	public void deleteCustomer(Customer customer) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = getConnection();
			String sql = "DELETE FROM CUSTOMERS WHERE ID = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, customer.getId());
			st.executeUpdate();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			closeResources(null,st,con);
		}

	}

	@Override
	public Customer getCustomerByUsername(String username) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Customer customer = null;
		try{
			con = getConnection();
			String sql = "SELECT * FROM CUSTOMERS WHERE USERNAME = ?";
			st = con.prepareStatement(sql);
			st.setString(1, username);
			rs = st.executeQuery();
			while(rs.next()){
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String address = rs.getString("ADDRESS");
				int ssn = rs.getInt("SSN");
				String password = rs.getString("PASSWORD");
				
				customer = new Customer(id,name,address,ssn,username,password);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			closeResources(null,st,con);
		}

		return customer;
	}

}
