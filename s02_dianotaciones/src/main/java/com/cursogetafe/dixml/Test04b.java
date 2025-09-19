package com.cursogetafe.dixml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("test")
public class Test04b {
	
//	@Autowired
//	@Qualifier("dataSourceProduccion")
	private DataSource dataSource;
	
	public Test04b() {
	}
	
	@Autowired
	// Si hay un sólo bean compatible con DataSource, lo inyecta
	// Si hay mas de uno, se debe indicar cual inyectar con @Qualifier
	public Test04b(@Qualifier("dataSourceDesarrollo") DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void consulta() throws SQLException {
		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from productos");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) + ": " + rs.getString(2));
		}
		
		con.close();

	}

	public static void main(String[] args) throws SQLException {
		
		BeanFactory ctx = new ClassPathXmlApplicationContext("a04_ctx.xml");
		
		Test04b test = ctx.getBean(Test04b.class);
		
		test.consulta();

	}
}
